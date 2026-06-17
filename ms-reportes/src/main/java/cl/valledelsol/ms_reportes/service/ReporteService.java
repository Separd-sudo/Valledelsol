package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC_INCENDIOS = "incidentes-incendios";

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
        
        // 🔑 CORRECCIÓN: Usamos 'setFecha' que es el método real de tu entidad Reporte
        reporte.setFechaCreacion(LocalDateTime.now()); 

        Reporte reporteGuardado = reporteRepository.save(reporte);

        try {
            kafkaTemplate.send(TOPIC_INCENDIOS, reporteGuardado);
        } catch (Exception e) {
            System.err.println("⚠️ Alerta Kafka: " + e.getMessage());
        }

        return reporteGuardado;
    }

    public List<Reporte> listarTodos() {
        return reporteRepository.findAll();
    }
}