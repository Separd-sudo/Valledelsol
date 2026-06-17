package cl.valledelsol.ms_reportes.controller;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.dto.ReporteResponse;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.service.ReporteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ResponseEntity<ReporteResponse> crearReporte(@Valid @RequestBody ReporteRequest request) {
        Reporte entidad = new Reporte();
        entidad.setTitulo(request.getTitulo());
        entidad.setDescripcion(request.getDescripcion());
        entidad.setUbicacion(request.getUbicacion());
        entidad.setNivelRiesgo(request.getNivelRiesgo());
        entidad.setLatitud(request.getLatitud());
        entidad.setLongitud(request.getLongitud());

        Reporte guardado = reporteService.crearReporte(entidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapearAResponse(guardado));
    }

    @GetMapping
    public ResponseEntity<List<ReporteResponse>> listarReportes() {
        List<ReporteResponse> respuestas = reporteService.listarReportes().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteResponse> buscarReportePorId(@PathVariable Long id) {
        Reporte reporte = reporteService.buscarReportePorId(id);
        return ResponseEntity.ok(mapearAResponse(reporte));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteResponse> actualizarReporte(@PathVariable Long id, @Valid @RequestBody ReporteRequest request) {
        Reporte datos = new Reporte();
        datos.setTitulo(request.getTitulo());
        datos.setDescripcion(request.getDescripcion());
        datos.setUbicacion(request.getUbicacion());
        datos.setNivelRiesgo(request.getNivelRiesgo());
        
        Reporte actualizado = reporteService.actualizarReporte(id, datos);
        return ResponseEntity.ok(mapearAResponse(actualizado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReporteResponse> actualizarParcial(@PathVariable Long id, @RequestBody ReporteRequest datosParciales) {
        // 1. Obtenemos la entidad Reporte modificada desde la capa de servicio
        Reporte reporteConEstadoNuevo = reporteService.actualizarEstado(id, datosParciales.getEstado());
        
        // 2. Mapeamos de forma explícita la entidad al DTO de salida
        ReporteResponse responseDto = mapearAResponse(reporteConEstadoNuevo);
        
        // 3. Retornamos la respuesta. Tipos alineados al 100%
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable Long id) {
        reporteService.eliminarReporte(id);
        return ResponseEntity.noContent().build();
    }

    private ReporteResponse mapearAResponse(Reporte r) {
        ReporteResponse res = new ReporteResponse();
        res.setId(r.getId());
        res.setTitulo(r.getTitulo());
        res.setDescripcion(r.getDescripcion());
        res.setUbicacion(r.getUbicacion());
        res.setNivelRiesgo(r.getNivelRiesgo());
        res.setEstado(r.getEstado());
        res.setFechaCreacion(r.getFechaCreacion());
        res.setLatitud(r.getLatitud());
        res.setLongitud(r.getLongitud());
        return res;
    }
}