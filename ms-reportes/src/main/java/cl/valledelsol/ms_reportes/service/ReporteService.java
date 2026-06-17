package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * LOGICA DE NEGOCIO PRINCIPAL (Persistencia + Evento Asíncrono)
     */
    public Reporte crearReporte(Reporte nuevoReporte) {
        nuevoReporte.setEstado("ACTIVO");
        nuevoReporte.setFechaCreacion(LocalDateTime.now());
        
        Reporte reporteGuardado = reporteRepository.save(nuevoReporte);
        System.out.println("💾 [MS-REPORTES] Incendio guardado en la BD con ID local: " + reporteGuardado.getId());

        try {
            kafkaTemplate.send("alertas-incendios", reporteGuardado);
            System.out.println("🚀 [MS-REPORTES ➔ KAFKA] Evento distribuido exitosamente en el bus general de Valle del Sol.");
        } catch (Exception e) {
            System.err.println("❌ Error de comunicación no bloqueante con Apache Kafka: " + e.getMessage());
        }

        return reporteGuardado;
    }

    public List<Reporte> listarReportes() {
        return reporteRepository.findAll();
    }

    public Reporte buscarReportePorId(Long id) {
        return reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Reporte forestal no localizado con ID: " + id));
    }

    public Reporte actualizarReporte(Long id, Reporte datosNuevos) {
        Reporte existente = buscarReportePorId(id);
        existente.setTitulo(datosNuevos.getTitulo());
        existente.setDescripcion(datosNuevos.getDescripcion());
        existente.setUbicacion(datosNuevos.getUbicacion());
        existente.setNivelRiesgo(datosNuevos.getNivelRiesgo());
        return reporteRepository.save(existente);
    }

    public Reporte actualizarEstado(Long id, String nuevoEstado) {
        Reporte existente = buscarReportePorId(id);
        existente.setEstado(nuevoEstado);
        return reporteRepository.save(existente);
    }

    public void eliminarReporte(Long id) {
        Reporte existente = buscarReportePorId(id);
        reporteRepository.delete(existente);
    }
}