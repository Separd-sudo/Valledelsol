package cl.valledelsol.ms_geografico.listener;

import cl.valledelsol.ms_geografico.dto.GeoEventDTO;
import cl.valledelsol.ms_geografico.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GeoListener {

    @Autowired
    private GeoService geoService;

    /**
     * Consume el mismo canal "alertas-incendios", completando el ecosistema de 3 oyentes simultáneos.
     */
    @KafkaListener(
        topics = "alertas-incendios",
        groupId = "valle-sol-geografico-group",
        properties = {"spring.json.value.default.type=cl.valledelsol.ms_geografico.dto.GeoEventDTO"}
    )
    public void escucharCoordenadas(GeoEventDTO evento) {
        geoService.registrarPuntoMapa(evento);
    }
}