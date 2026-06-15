package cl.valledelsol.ms_analitica.controller;

import cl.valledelsol.ms_analitica.model.RegistroHistorico;
import cl.valledelsol.ms_analitica.service.AnaliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/analitica")
public class AnaliticaController {

    @Autowired
    private AnaliticaService service;

    /**
     * Endpoint de consulta para auditoría e indicadores municipales.
     * Accedido a través de Kong por el BFF.
     */
    @GetMapping("/historial")
    public ResponseEntity<List<RegistroHistorico>> listarHistorial() {
        List<RegistroHistorico> lista = service.obtenerTodoElHistorial();
        return ResponseEntity.ok(lista);
    }
}