package cl.valledelsol.ms_reportes.controller;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.service.ReporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.valledelsol.ms_reportes.dto.ActualizarReporteRequest;
import java.util.NoSuchElementException;
import java.util.Map;

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
            // Ejecuta el flujo seguro de persistencia core
            Reporte nuevoReporte = reporteService.crearReporte(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReporte);
        } catch (Exception e) {
            // Captura controlada del error evitando la caída del Socket de red
            System.err.println("💥 Error controlado en controlador: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al procesar el reporte: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes() {
        return ResponseEntity.ok(reporteService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarReporte(@PathVariable Long id, @RequestBody ActualizarReporteRequest request) {
        try {
                 Reporte reporteActualizado = reporteService.actualizarReporte(id, request);
        return ResponseEntity.ok(reporteActualizado);
    } catch (NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Error interno al actualizar el reporte: " + e.getMessage()));
    }
}
}