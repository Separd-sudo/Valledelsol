package cl.valledelsol.ms_geografico.controller;

import cl.valledelsol.ms_geografico.model.CoordenadaIncendio;
import cl.valledelsol.ms_geografico.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/geografia")
public class GeoController {

    @Autowired
    private GeoService service;

    /**
     * Consume las coordenadas a través de Kong para alimentar el mapa de React.
     */
    @GetMapping("/puntos")
    public ResponseEntity<List<CoordenadaIncendio>> obtenerCoordenadasPines() {
        List<CoordenadaIncendio> puntos = service.obtenerPuntosMapa();
        return ResponseEntity.ok(puntos);
    }
}