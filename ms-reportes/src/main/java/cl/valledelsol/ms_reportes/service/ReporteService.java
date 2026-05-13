package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.dto.ReporteResponse;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
 * Service Layer.
 * Esta clase contiene la lógica de negocio del microservicio.
 * El controlador no debe acceder directamente al repositorio.
 */
@Service
public class ReporteService {

    /*
     * Estado inicial asignado automáticamente a todo reporte nuevo.
     */
    private static final String ESTADO_INICIAL = "PENDIENTE";

    private final ReporteRepository reporteRepository;

    /*
     * Inyección de dependencia por constructor.
     * Spring entrega automáticamente una instancia de ReporteRepository.
     */
    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    /*
     * Crea un nuevo reporte de incendio.
     * Recibe un DTO de entrada, crea una entidad y la guarda en PostgreSQL.
     */
    public ReporteResponse crearReporte(ReporteRequest request) {

        Reporte reporte = new Reporte();

        reporte.setTitulo(request.getTitulo());
        reporte.setDescripcion(request.getDescripcion());
        reporte.setUbicacion(request.getUbicacion());
        reporte.setNivelRiesgo(request.getNivelRiesgo());
        reporte.setEstado(ESTADO_INICIAL);
        reporte.setFechaCreacion(LocalDateTime.now());

        Reporte reporteGuardado = reporteRepository.save(reporte);

        return convertirAResponse(reporteGuardado);
    }

    /*
     * Lista todos los reportes existentes.
     */
    public List<ReporteResponse> listarReportes() {

        return reporteRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    /*
     * Busca un reporte específico por ID.
     */
    public ReporteResponse buscarReportePorId(Long id) {

        Reporte reporte = obtenerReportePorId(id);

        return convertirAResponse(reporte);
    }

    /*
     * Actualiza todos los datos principales del reporte.
     */
    public ReporteResponse actualizarReporte(Long id, ReporteRequest request) {

        Reporte reporte = obtenerReportePorId(id);

        reporte.setTitulo(request.getTitulo());
        reporte.setDescripcion(request.getDescripcion());
        reporte.setUbicacion(request.getUbicacion());
        reporte.setNivelRiesgo(request.getNivelRiesgo());

        Reporte reporteActualizado = reporteRepository.save(reporte);

        return convertirAResponse(reporteActualizado);
    }

    /*
     * Actualiza solo el estado del reporte.
     * Ejemplo: PENDIENTE → EN_REVISION.
     */
    public ReporteResponse actualizarEstado(Long id, String nuevoEstado) {

        Reporte reporte = obtenerReportePorId(id);

        reporte.setEstado(nuevoEstado);

        Reporte reporteActualizado = reporteRepository.save(reporte);

        return convertirAResponse(reporteActualizado);
    }

    /*
     * Elimina un reporte.
     */
    public void eliminarReporte(Long id) {

        Reporte reporte = obtenerReportePorId(id);

        reporteRepository.delete(reporte);
    }

    /*
     * Método privado reutilizable.
     * Evita repetir findById en varios métodos públicos.
     */
    private Reporte obtenerReportePorId(Long id) {

        return reporteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Reporte no encontrado con ID: " + id));
    }

    /*
     * Convierte la entidad Reporte en un DTO de respuesta.
     * Así evitamos exponer directamente la entidad de base de datos.
     */
    private ReporteResponse convertirAResponse(Reporte reporte) {

        return new ReporteResponse(
                reporte.getId(),
                reporte.getTitulo(),
                reporte.getDescripcion(),
                reporte.getUbicacion(),
                reporte.getNivelRiesgo(),
                reporte.getEstado(),
                reporte.getFechaCreacion()
        );
    }
}