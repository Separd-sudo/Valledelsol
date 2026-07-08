package cl.valledelsol.ms_geografico.service;

import cl.valledelsol.ms_geografico.dto.GeoEventDTO;
import cl.valledelsol.ms_geografico.model.CoordenadaIncendio;
import cl.valledelsol.ms_geografico.repository.CoordenadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeoService {

    @Autowired
    private CoordenadaRepository repository;

    /**
     * Procesa de forma asíncrona las coordenadas del mapa.
     */
    public void registrarPuntoMapa(GeoEventDTO evento) {
        CoordenadaIncendio geo = repository.findByIdReporte(evento.getId())
                 .orElse(new CoordenadaIncendio());
        geo.setIdGeo(null);
        geo.setIdReporte(evento.getId());
        geo.setSector(evento.getUbicacion());
        geo.setLatitud(evento.getLatitud());
        geo.setLongitud(evento.getLongitud());
        geo.setEstado(evento.getEstado());

        repository.save(geo);
        System.out.println("📍 [MS-GEOGRAFICO] Coordenadas guardadas para el mapa interactivo. Reporte ID: " + evento.getId());
    }

    /**
     * Lista todos los pines activos para renderizar en las pantallas de React.
     */
    public List<CoordenadaIncendio> obtenerPuntosMapa() {
        return repository.findAll();
    }
}