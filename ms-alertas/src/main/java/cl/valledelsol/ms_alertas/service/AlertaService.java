package cl.valledelsol.ms_alertas.service;

import cl.valledelsol.ms_alertas.client.UsuarioClient;
import cl.valledelsol.ms_alertas.client.UsuarioDTO;
import cl.valledelsol.ms_alertas.dto.AlertaIncendioDTO;
import cl.valledelsol.ms_alertas.model.NotificacionEnviada;
import cl.valledelsol.ms_alertas.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertaService {

    private final UsuarioClient usuarioClient;
    private final NotificacionRepository notificacionRepository;

    public AlertaService(UsuarioClient usuarioClient, NotificacionRepository notificacionRepository) {
        this.usuarioClient = usuarioClient;
        this.notificacionRepository = notificacionRepository;
    }

    public void enviarNotificacionesMunicipales(AlertaIncendioDTO alerta) {
        List<UsuarioDTO> destinatarios = usuarioClient.obtenerDestinatariosActivos();

        if (destinatarios.isEmpty()) {
            System.out.println("⚠️ [MS-ALERTAS] Sin destinatarios activos para reporte ID " + alerta.getId());
            return;
        }

        String mensaje = construirMensaje(alerta);
        LocalDateTime ahora = LocalDateTime.now();

        for (UsuarioDTO destinatario : destinatarios) {
            NotificacionEnviada notificacion = new NotificacionEnviada(
                    alerta.getId(), destinatario.getId(), destinatario.getCorreo(),
                    destinatario.getRol(), mensaje, ahora
            );
            notificacionRepository.save(notificacion);
        }

        System.out.println("🚨 [MS-ALERTAS] Reporte ID " + alerta.getId() + " notificado a " + destinatarios.size() + " usuarios");
    }

    private String construirMensaje(AlertaIncendioDTO alerta) {
        return "Alerta de incendio (" + alerta.getNivelRiesgo() + ") en " + alerta.getUbicacion() + ": " + alerta.getDescripcion();
    }
}