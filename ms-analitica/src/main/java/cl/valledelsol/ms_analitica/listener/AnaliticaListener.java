package cl.valledelsol.ms_analitica.listener;

import cl.valledelsol.ms_analitica.dto.ReporteEventDTO;
import cl.valledelsol.ms_analitica.service.AnaliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnaliticaListener {

    @Autowired
    private AnaliticaService analiticaService;

    /**
     * Consume del mismo tópico de incidentes, demostrando el patrón Publish-Subscribe de Kafka.
     */
    @KafkaListener(
        topics = "incidentes-incendios",
        groupId = "valle-sol-analitica-group",
        properties = {"spring.json.value.default.type=cl.valledelsol.ms_analitica.dto.ReporteEventDTO"}
    )
    public void escucharNuevosReportes(ReporteEventDTO evento) {
        // Redirige el flujo hacia la capa de negocio para persistir el dato
        analiticaService.registrarEnHistorial(evento);
    }
}