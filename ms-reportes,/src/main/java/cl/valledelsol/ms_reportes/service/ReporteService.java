package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.dto.ReporteResponse;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    public ReporteResponse crearReporte(ReporteRequest request) {
        Reporte reporte = new Reporte();
        reporte.setTitulo(request.getTitulo());
        reporte.setDescripcion(request.getDescripcion());
        reporte.setUbicacion(request.getUbicacion());
        reporte.setEstado("PENDIENTE");
        reporte.setFechaCreacion(LocalDateTime.now());

        Reporte reporteGuardado = reporteRepository.guardar(reporte);

        return convertirAResponse(reporteGuardado);
    }

    public List<ReporteResponse> listarReportes() {
        return reporteRepository.listar()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public ReporteResponse buscarReportePorId(Long id) {
        Reporte reporte = reporteRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));

        return convertirAResponse(reporte);
    }

    public ReporteResponse actualizarEstado(Long id, String nuevoEstado) {
        Reporte reporte = reporteRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));

        reporte.setEstado(nuevoEstado);

        Reporte actualizado = reporteRepository.actualizar(reporte);

        return convertirAResponse(actualizado);
    }

    private ReporteResponse convertirAResponse(Reporte reporte) {
        return new ReporteResponse(
                reporte.getId(),
                reporte.getTitulo(),
                reporte.getDescripcion(),
                reporte.getUbicacion(),
                reporte.getEstado(),
                reporte.getFechaCreacion()
        );
    }
}