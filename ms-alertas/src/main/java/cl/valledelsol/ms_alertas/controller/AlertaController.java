package cl.valledelsol.ms_alertas.controller;

import cl.valledelsol.ms_alertas.model.NotificacionEnviada;
import cl.valledelsol.ms_alertas.repository.NotificacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alertas")
public class AlertaController {

    private final NotificacionRepository notificacionRepository;

    public AlertaController(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    @GetMapping("/notificaciones")
    public ResponseEntity<List<NotificacionEnviada>> listarNotificaciones() {
        return ResponseEntity.ok(notificacionRepository.findAll());
    }
}