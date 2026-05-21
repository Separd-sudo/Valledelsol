package cl.valledelsol.bff.service;

import cl.valledelsol.bff.dto.DashboardResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import cl.valledelsol.bff.dto.UsuarioResponse;
import cl.valledelsol.bff.dto.ReporteResponse;
import java.util.List;

/*
 * Service Layer del BFF.
 *“Porque el BFF desacopla los microservicios del frontend, evitando dependencias directas 
 * entre servicios y permitiendo transformar datos según necesidad del cliente.”
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
    public List<ReporteResponse> listarReportes() {

    /*
     * Consume ms-reportes y lo convierte a array tipado.
     */
    ReporteResponse[] response = restTemplate.getForObject(
            reportesUrl,
            ReporteResponse[].class
    );

    /*
     * Convierte a List para el controller.
     */
    return response != null ? List.of(response) : List.of();
}

    /*
     * Lista usuarios consumiendo ms-usuarios.
     */
    public List<UsuarioResponse> listarUsuarios() {

    /*
     * Consume ms-usuarios y lo convierte a array tipado.
     */
    UsuarioResponse[] response = restTemplate.getForObject(
            usuariosUrl,
            UsuarioResponse[].class
    );

    /*
     * Convierte a List para el controller.
     */
    return response != null ? List.of(response) : List.of();
}
}