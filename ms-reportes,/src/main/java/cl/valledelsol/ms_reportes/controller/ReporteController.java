package cl.valledelsol.ms_reportes.controller;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.dto.ReporteResponse;
import cl.valledelsol.ms_reportes.service.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ReporteResponse crearReporte(@RequestBody ReporteRequest request) {
        return reporteService.crearReporte(request);
    }

    @GetMapping
    public List<ReporteResponse> listarReportes() {
        return reporteService.listarReportes();
    }

    @GetMapping("/{id}")
    public ReporteResponse buscarReportePorId(@PathVariable Long id) {
        return reporteService.buscarReportePorId(id);
    }

    @PatchMapping("/{id}/estado")
    public ReporteResponse actualizarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String nuevoEstado = body.get("estado");
        return reporteService.actualizarEstado(id, nuevoEstado);
    }
}