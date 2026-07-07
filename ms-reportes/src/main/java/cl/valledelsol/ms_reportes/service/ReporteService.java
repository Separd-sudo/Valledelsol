package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import cl.valledelsol.ms_reportes.dto.ActualizarReporteRequest;
import java.util.NoSuchElementException;
import java.util.Set;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC_INCENDIOS = "incidentes-incendios";
    private static final Set<String> ESTADOS_VALIDOS = Set.of("PENDIENTE", "EN_REVISION", "ATENDIDO", "CERRADO");


    public ReporteService(ReporteRepository reporteRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.reporteRepository = reporteRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Reporte crearReporte(ReporteRequest request) {
        Reporte reporte = new Reporte();
        reporte.setTitulo(request.getTitulo());
        reporte.setDescripcion(request.getDescripcion());
        reporte.setUbicacion(request.getUbicacion());
        reporte.setNivelRiesgo(request.getNivelRiesgo() != null ? request.getNivelRiesgo().toUpperCase() : "MEDIO");
        reporte.setEstado("PENDIENTE");
        reporte.setFechaCreacion(LocalDateTime.now()); 
        
        // 🔑 REPARADO CRÍTICO: Mapeo de coordenadas que causaban el NullPointerException en BD
        reporte.setLatitud(request.getLatitud() != null ? request.getLatitud() : 0.0);
        reporte.setLongitud(request.getLongitud() != null ? request.getLongitud() : 0.0);

        // Guarda primero en la base de datos relacional PostgreSQL
        Reporte reporteGuardado = reporteRepository.save(reporte);

        // 🔑 BYPASS DE INFRAESTRUCTURA: Enviamos al broker ignorando fallas de red para liberar a Postman
        try {
        kafkaTemplate.send(TOPIC_INCENDIOS, reporteGuardado);
        } catch (Exception e) {
           System.err.println("🚨 [KAFKA] Reporte ID " + reporteGuardado.getId()
        + " guardado en BD pero no publicado en Kafka. Causa: " + e.getMessage());
        }

        return reporteGuardado;
    }

    public List<Reporte> listarTodos() {
        return reporteRepository.findAll();
    }


    public Reporte actualizarReporte(Long id, ActualizarReporteRequest request) {
    Reporte reporte = reporteRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("No existe un reporte con id " + id));

    if (request.getEstado() != null && !request.getEstado().isBlank()) {
        String estadoNormalizado = request.getEstado().toUpperCase();
        if (!ESTADOS_VALIDOS.contains(estadoNormalizado)) {
            throw new IllegalArgumentException("Estado invalido: '" + request.getEstado() + "'. Estados validos: " + ESTADOS_VALIDOS);
        }
        reporte.setEstado(estadoNormalizado);
    }

    if (request.getDescripcion() != null && !request.getDescripcion().isBlank()) {
        reporte.setDescripcion(request.getDescripcion());
    }

    Reporte reporteActualizado = reporteRepository.save(reporte);

    try {
        kafkaTemplate.send(TOPIC_INCENDIOS, reporteActualizado);
    } catch (Exception e) {
        System.err.println("🚨 [KAFKA] Reporte ID " + reporteActualizado.getId() + " actualizado en BD pero no publicado en Kafka. Causa: " + e.getMessage());
    }

    return reporteActualizado;
}
}