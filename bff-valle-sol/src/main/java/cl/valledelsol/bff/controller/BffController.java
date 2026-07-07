package cl.valledelsol.bff.controller;

import cl.valledelsol.bff.security.JwtAuthFilter;
import cl.valledelsol.bff.service.BffService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bff")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BffController {

    private final BffService bffService;
    private final RestTemplate restTemplate;

    private static final String ROL_FUNCIONARIO = "FUNCIONARIO";
    private static final String ROL_FUNCIONARIO_MUNICIPAL = "FUNCIONARIO_MUNICIPAL";
    private static final String ROL_BRIGADISTA = "BRIGADISTA";

    @Value("${ms.auth.url:http://ms-auth:8083}")
    private String msAuthUrl;

    @Value("${ms.reportes.url}")
    private String msReportesUrl;

    @Value("${ms.usuarios.url}")
    private String msUsuariosUrl;

    @Value("${ms.analitica.url}")
    private String msAnaliticaUrl;

    @Value("${ms.geografico.url}")
    private String msGeograficoUrl;

    @Value("${ms.alertas.url}")
    private String msAlertasUrl;

    public BffController(BffService bffService, RestTemplate restTemplate) {
        this.bffService = bffService;
        this.restTemplate = restTemplate;
    }

    private ResponseEntity<?> verificarRol(HttpServletRequest request, String... rolesPermitidos) {
        Object rolObj = request.getAttribute(JwtAuthFilter.ATTR_ROL);
        String rol = rolObj != null ? rolObj.toString() : null;

        for (String permitido : rolesPermitidos) {
            if (permitido.equals(rol)) {
                return null;
            }
        }
        return ResponseEntity.status(403)
                .body(Map.of("error", "Acceso denegado: tu rol (" + rol + ") no tiene permiso para esta acción."));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> obtenerDashboard(HttpServletRequest request) {
        ResponseEntity<?> denegado = verificarRol(request, ROL_FUNCIONARIO, ROL_FUNCIONARIO_MUNICIPAL);
        if (denegado != null) return denegado;
        return ResponseEntity.ok(bffService.obtenerDashboard());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> registrarUsuario(@RequestBody Map<String, Object> requestBody) {
        try {
            Object response = bffService.registrarUsuario(requestBody);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de usuarios BFF: " + e.getMessage());
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> listarUsuarios(HttpServletRequest request) {
        ResponseEntity<?> denegado = verificarRol(request, ROL_FUNCIONARIO, ROL_FUNCIONARIO_MUNICIPAL);
        if (denegado != null) return denegado;
        try {
            return ResponseEntity.ok(bffService.listarUsuarios());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recuperar listado de usuarios en BFF: " + e.getMessage());
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> loginBody) {
        try {
            String urlMsAuth = msAuthUrl + "/api/v1/auth/login";
            ResponseEntity<Object> response = restTemplate.postForEntity(urlMsAuth, loginBody, Object.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de autenticación BFF: " + e.getMessage());
        }
    }

    @PostMapping("/reportes")
    public ResponseEntity<?> crearReporte(@RequestBody Map<String, Object> reporteBody, HttpServletRequest request) {
        try {
            String urlMsReportes = msReportesUrl + "/api/v1/reportes";
            // 🔑 FIX: Reenviar el header Authorization al microservicio de reportes
            String authHeader = request.getHeader("Authorization");
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
            if (authHeader != null) {
                headers.set("Authorization", authHeader);
            }
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(reporteBody, headers);
            ResponseEntity<Object> response = restTemplate.exchange(urlMsReportes, HttpMethod.POST, entity, Object.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de creación de reportes BFF: " + e.getMessage());
        }
    }

    @GetMapping("/reportes")
    public ResponseEntity<?> listarReportes() {
        try {
            String urlMsReportes = msReportesUrl + "/api/v1/reportes";
            ResponseEntity<Object[]> response = restTemplate.getForEntity(urlMsReportes, Object[].class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recuperar listado de reportes en BFF: " + e.getMessage());
        }
    }

    @PutMapping("/reportes/{id}")
    public ResponseEntity<?> actualizarReporte(@PathVariable Long id,
                                                @RequestBody Map<String, Object> reporteBody,
                                                HttpServletRequest request) {
        ResponseEntity<?> denegado = verificarRol(request, ROL_BRIGADISTA, ROL_FUNCIONARIO, ROL_FUNCIONARIO_MUNICIPAL);
        if (denegado != null) return denegado;
        try {
            String urlMsReportes = msReportesUrl + "/api/v1/reportes/" + id;
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(reporteBody);
            ResponseEntity<Object> response = restTemplate.exchange(urlMsReportes, HttpMethod.PUT, entity, Object.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de actualización de reportes BFF: " + e.getMessage());
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id,
                                                @RequestBody Map<String, Object> usuarioBody,
                                                HttpServletRequest request) {
        ResponseEntity<?> denegado = verificarRol(request, ROL_FUNCIONARIO, ROL_FUNCIONARIO_MUNICIPAL);
        if (denegado != null) return denegado;

        Object idUsuarioObj = request.getAttribute(JwtAuthFilter.ATTR_ID_USUARIO);
        boolean esUnoMismo = idUsuarioObj != null && id.equals(((Number) idUsuarioObj).longValue());
        boolean intentaDesactivarse = esUnoMismo && Boolean.FALSE.equals(usuarioBody.get("activo"));

        if (intentaDesactivarse) {
            return ResponseEntity.status(409)
                    .body(Map.of("error", "No puedes desactivar tu propia cuenta de Funcionario."));
        }

        try {
            String urlMsUsuarios = msUsuariosUrl + "/api/v1/usuarios/" + id;
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(usuarioBody);
            ResponseEntity<Object> response = restTemplate.exchange(urlMsUsuarios, HttpMethod.PUT, entity, Object.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de actualización de usuarios BFF: " + e.getMessage());
        }
    }

    @GetMapping("/analitica/historial")
    public ResponseEntity<?> obtenerHistorial(HttpServletRequest request) {
        ResponseEntity<?> denegado = verificarRol(request, ROL_FUNCIONARIO, ROL_FUNCIONARIO_MUNICIPAL);
        if (denegado != null) return denegado;
        try {
            String urlMsAnalitica = msAnaliticaUrl + "/api/v1/analitica/historial";
            ResponseEntity<Object[]> response = restTemplate.getForEntity(urlMsAnalitica, Object[].class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recuperar historial de analítica en BFF: " + e.getMessage());
        }
    }

    @GetMapping("/geografia/puntos")
    public ResponseEntity<?> obtenerPuntosMapa() {
        try {
            String urlMsGeografico = msGeograficoUrl + "/api/v1/geografia/puntos";
            ResponseEntity<Object[]> response = restTemplate.getForEntity(urlMsGeografico, Object[].class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recuperar puntos del mapa en BFF: " + e.getMessage());
        }
    }

    @GetMapping("/alertas/notificaciones")
    public ResponseEntity<?> obtenerNotificaciones(HttpServletRequest request) {
        ResponseEntity<?> denegado = verificarRol(request, ROL_FUNCIONARIO, ROL_FUNCIONARIO_MUNICIPAL);
        if (denegado != null) return denegado;
        try {
            String urlMsAlertas = msAlertasUrl + "/api/v1/alertas/notificaciones";
            ResponseEntity<Object[]> response = restTemplate.getForEntity(urlMsAlertas, Object[].class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recuperar notificaciones en BFF: " + e.getMessage());
        }
    }
}