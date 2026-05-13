package cl.valledelsol.ms_reportes.controller;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.dto.ReporteResponse;
import cl.valledelsol.ms_reportes.service.ReporteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * @RestController indica que esta clase expone endpoints REST.
 * @RequestMapping define la ruta base del recurso.
 */
@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    /*
     * Inyección de dependencia por constructor.
     */
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    /*
     * POST /api/reportes
     * Crea un nuevo reporte de incendio.
     *
     * @Valid activa las validaciones del DTO.
     * @RequestBody indica que los datos vienen en formato JSON.
     */
    @PostMapping
    public ResponseEntity<ReporteResponse> crearReporte(
            @Valid @RequestBody ReporteRequest request
    ) {
        return ResponseEntity.ok(reporteService.crearReporte(request));
    }

    /*
     * GET /api/reportes
     * Lista todos los reportes.
     */
    @GetMapping
    public ResponseEntity<List<ReporteResponse>> listarReportes() {
        return ResponseEntity.ok(reporteService.listarReportes());
    }

    /*
     * GET /api/reportes/{id}
     * Busca un reporte por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReporteResponse> buscarReportePorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(reporteService.buscarReportePorId(id));
    }

    /*
     * PUT /api/reportes/{id}
     * Actualiza los datos principales de un reporte.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReporteResponse> actualizarReporte(
            @PathVariable Long id,
            @Valid @RequestBody ReporteRequest request
    ) {
        return ResponseEntity.ok(reporteService.actualizarReporte(id, request));
    }

    /*
     * PATCH /api/reportes/{id}/estado
     * Actualiza solo el estado del reporte.
     *
     * El cuerpo esperado es:
     * { "estado": "EN_REVISION" }
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ReporteResponse> actualizarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String nuevoEstado = body.get("estado");
        return ResponseEntity.ok(reporteService.actualizarEstado(id, nuevoEstado));
    }

    /*
     * DELETE /api/reportes/{id}
     * Elimina un reporte.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(
            @PathVariable Long id
    ) {
        reporteService.eliminarReporte(id);
        return ResponseEntity.noContent().build();
    }
}