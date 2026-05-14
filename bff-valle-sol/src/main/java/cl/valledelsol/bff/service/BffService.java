package cl.valledelsol.bff.service;

import cl.valledelsol.bff.dto.DashboardResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Service Layer del BFF.
 *
 * Este servicio orquesta llamadas a microservicios internos
 * y adapta las respuestas para el frontend.
 */
@Service
public class BffService {

    private final RestTemplate restTemplate;

    /*
     * URL de ms-reportes leída desde application.properties.
     */
    @Value("${services.reportes.url}")
    private String reportesUrl;

    /*
     * URL de ms-usuarios leída desde application.properties.
     */
    @Value("${services.usuarios.url}")
    private String usuariosUrl;

    public BffService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
     * Construye el dashboard consumiendo ms-reportes y ms-usuarios.
     * El frontend recibe una respuesta resumida sin consultar servicios por separado.
     */
    public DashboardResponse obtenerDashboard() {
        Object[] reportes = restTemplate.getForObject(reportesUrl, Object[].class);
        Object[] usuarios = restTemplate.getForObject(usuariosUrl, Object[].class);

        int totalReportes = reportes != null ? reportes.length : 0;
        int totalUsuarios = usuarios != null ? usuarios.length : 0;

        return new DashboardResponse(
                totalReportes,
                totalUsuarios,
                "Dashboard generado desde el BFF Valle del Sol"
        );
    }

    /*
     * Lista reportes consumiendo ms-reportes.
     */
    public Object[] listarReportes() {
        return restTemplate.getForObject(reportesUrl, Object[].class);
    }

    /*
     * Lista usuarios consumiendo ms-usuarios.
     */
    public Object[] listarUsuarios() {
        return restTemplate.getForObject(usuariosUrl, Object[].class);
    }
}