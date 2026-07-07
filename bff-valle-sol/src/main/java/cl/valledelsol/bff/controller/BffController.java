package cl.valledelsol.bff.controller;

import cl.valledelsol.bff.service.BffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bff")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BffController {

    private final BffService bffService;
    private final RestTemplate restTemplate;

    // Aprovechamos el RestTemplate inyectado nativamente por el arquetipo
    public BffController(BffService bffService, RestTemplate restTemplate) {
        this.bffService = bffService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> obtenerDashboard() {
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

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> loginBody) {
        try {
            String urlMsAuth = "http://ms-auth:8083/api/v1/auth/login";
            ResponseEntity<Object> response = restTemplate.postForEntity(urlMsAuth, loginBody, Object.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (org.springframework.web.client.HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de autenticación BFF: " + e.getMessage());
        }
    }

    @PostMapping("/reportes")
    public ResponseEntity<?> crearReporte(@RequestBody Map<String, Object> reporteBody) {
        try {
            String urlMsReportes = "http://ms-reportes:8081/api/v1/reportes";
            ResponseEntity<Object> response = restTemplate.postForEntity(urlMsReportes, reporteBody, Object.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en pasarela de creación de reportes BFF: " + e.getMessage());
        }
    }

    @GetMapping("/reportes")
    public ResponseEntity<?> listarReportes() {
        try {
            String urlMsReportes = "http://ms-reportes:8081/api/v1/reportes";
            ResponseEntity<Object[]> response = restTemplate.getForEntity(urlMsReportes, Object[].class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recuperar listado de reportes en BFF: " + e.getMessage());
        }
    }
}