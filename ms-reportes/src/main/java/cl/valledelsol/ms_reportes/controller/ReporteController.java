package cl.valledelsol.ms_reportes.controller;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.service.ReporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ResponseEntity<?> crearReporte(@RequestBody ReporteRequest request) {
        try {
            Reporte nuevoReporte = reporteService.crearReporte(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al procesar el reporte: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes() {
        return ResponseEntity.ok(reporteService.listarTodos());
    }
}