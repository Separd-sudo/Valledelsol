package cl.valledelsol.ms_alertas.listener;

import cl.valledelsol.ms_alertas.dto.AlertaIncendioDTO;
import cl.valledelsol.ms_alertas.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AlertaListener {

    @Autowired
    private AlertaService alertaService;

    /**
     * Captura el evento de Kafka y delega la ejecución al servicio correspondiente.
     * Spring se encarga de parsear el JSON entrante directo al DTO.
     */
    @KafkaListener(
        topics = "alertas-incendios", 
        groupId = "valle-sol-alertas-group",
        properties = {"spring.json.value.default.type=cl.valledelsol.ms_alertas.dto.AlertaIncendioDTO"}
    )
    public void consumirMensajeIncendio(AlertaIncendioDTO alertaDto) {
        // Delegamos el flujo a la capa de servicio
        alertaService.enviarNotificacionesMunicipales(alertaDto);
    }
}