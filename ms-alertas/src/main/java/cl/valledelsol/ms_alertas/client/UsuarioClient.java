package cl.valledelsol.ms_alertas.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioClient {

    private final RestTemplate restTemplate;

    @Value("${ms.usuarios.url}")
    private String msUsuariosUrl;

    private static final Set<String> ROLES_A_NOTIFICAR = Set.of("CIUDADANO", "BRIGADISTA");

    public UsuarioClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UsuarioDTO> obtenerDestinatariosActivos() {
        try {
            UsuarioDTO[] usuarios = restTemplate.getForObject(msUsuariosUrl + "/api/v1/usuarios", UsuarioDTO[].class);
            if (usuarios == null) return List.of();
            return Arrays.stream(usuarios)
                    .filter(u -> Boolean.TRUE.equals(u.getActivo()))
                    .filter(u -> u.getRol() != null && ROLES_A_NOTIFICAR.contains(u.getRol().toUpperCase()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("🚨 [MS-ALERTAS] No se pudo consultar ms-usuarios: " + e.getMessage());
            return List.of();
        }
    }
}