package cl.valledelsol.bff.controller;

import cl.valledelsol.bff.dto.DashboardResponse;
import cl.valledelsol.bff.dto.UsuarioResponse;
import cl.valledelsol.bff.dto.UsuarioRequest;
import cl.valledelsol.bff.dto.ReporteResponse;
import cl.valledelsol.bff.service.BffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controlador REST del BFF (Backend For Frontend).
 *
 * Este componente expone endpoints únicos para el frontend,
 * evitando que el frontend llame directamente a los microservicios.
 */
@RestController
@RequestMapping("/api/v1/bff")
public class BffController {

    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    /*
     * Endpoint principal del dashboard.
     * Consolida información de múltiples microservicios.
     */
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardResponse> obtenerDashboard() {
        return ResponseEntity.ok(bffService.obtenerDashboard());
    }

    /*
     * Lista usuarios desde ms-usuarios.
     * El BFF actúa como intermediario.
     */
    @PostMapping("/usuarios")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRequest request) {
        Object respuesta = bffService.registrarUsuario(request);
        return ResponseEntity.ok(respuesta);
    }
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        return ResponseEntity.ok(bffService.listarUsuarios());
    }

    /*
     * Lista reportes desde ms-reportes.
     */
    @GetMapping("/reportes")
    public ResponseEntity<List<ReporteResponse>> listarReportes() {
        return ResponseEntity.ok(bffService.listarReportes());
    }
}