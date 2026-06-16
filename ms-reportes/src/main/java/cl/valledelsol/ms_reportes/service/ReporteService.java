package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    // Inyectamos el emisor nativo de Spring Kafka configurado para enviar Strings y Objetos
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * Guarda el reporte en la BD local y gatilla la notificación asíncrona global.
     */
    public Reporte crearReporteMunicipal(Reporte nuevoReporte) {
        
        // 1. Persistencia síncrona en la base de datos local (postgres-reportes)
        nuevoReporte.setEstado("ACTIVO"); // Todo incendio nace activo
        Reporte reporteGuardado = reporteRepository.save(nuevoReporte);
        
        System.out.println("💾 [MS-REPORTES] Incendio guardado localmente con ID: " + reporteGuardado.getId());

        // 2. CONEXIÓN ASÍNCRONA: Publicamos el evento robusto en el tópico de Kafka
        try {
            // El nombre del canal "alertas-incendios" debe coincidir con el de tus 3 listeners
            kafkaTemplate.send("alertas-incendios", reporteGuardado);
            System.out.println("🚀 [MS-REPORTES ➔ KAFKA] Evento publicado exitosamente en el bus de datos corporativo.");
        } catch (Exception e) {
            System.err.println("❌ Error crítico al intentar conectar con el broker de Kafka: " + e.getMessage());
        }

        return reporteGuardado;
    }
}