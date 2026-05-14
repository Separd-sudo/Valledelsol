package cl.valledelsol.bff.controller;

import cl.valledelsol.bff.dto.DashboardResponse;
import cl.valledelsol.bff.service.BffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Controlador REST del BFF.
 *
 * Expone endpoints orientados al frontend.
 * El frontend consume el BFF, no directamente los microservicios.
 */
@RestController
@RequestMapping("/api/bff")
public class BffController {

    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    /*
     * GET /api/bff/dashboard
     * Devuelve resumen general del sistema.
     */
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardResponse> obtenerDashboard() {
        return ResponseEntity.ok(bffService.obtenerDashboard());
    }

    /*
     * GET /api/bff/reportes
     * Devuelve reportes obtenidos desde ms-reportes.
     */
    @GetMapping("/reportes")
    public ResponseEntity<Object[]> listarReportes() {
        return ResponseEntity.ok(bffService.listarReportes());
    }

    /*
     * GET /api/bff/usuarios
     * Devuelve usuarios obtenidos desde ms-usuarios.
     */
    @GetMapping("/usuarios")
    public ResponseEntity<Object[]> listarUsuarios() {
        return ResponseEntity.ok(bffService.listarUsuarios());
    }
}