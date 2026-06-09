package cl.valledelsol.bff.service;

import cl.valledelsol.bff.dto.DashboardResponse;
import cl.valledelsol.bff.dto.ReporteResponse;
import cl.valledelsol.bff.dto.UsuarioResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
 * Capa de Servicio del BFF (Backend For Frontend).
 * Este componente es el núcleo de la orquestación: se encarga de consumir las APIs 
 * síncronas de los microservicios traseros y unificar las respuestas para React[cite: 339, 340].
 */
@Service
public class BffService {

    // Instancia compartida de RestTemplate inyectada por el constructor [cite: 447]
    private final RestTemplate restTemplate;

    /*
     * Inyección dinámica de las URLs base desde el archivo application.properties.
     * Permite cambiar los entornos de ejecución (Localhost vs Contenedores Docker) sin tocar el código.
     */
    @Value("${ms.usuarios.url:http://localhost:8082}")
    private String msUsuariosUrl;

    @Value("${ms.reportes.url:http://localhost:8081}")
    private String msReportesUrl;

    /*
     * Inyección de dependencia por constructor, cumpliendo con las buenas prácticas del arquetipo[cite: 359, 391].
     */
    public BffService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Orquestación del Dashboard: Consume de manera síncrona y simultánea la lista de reportes 
     * y la lista de usuarios para calcular los totales requeridos por la pantalla de React[cite: 288, 340].
     */
    public DashboardResponse obtenerDashboard() {
        // 1. Obtenemos la lista de reportes llamando al microservicio ms-reportes 
        List<ReporteResponse> reportes = listarReportes();
        Integer totalReportes = (reportes != null) ? reportes.size() : 0;

        // 2. Obtenemos la lista de usuarios llamando al microservicio ms-usuarios 
        List<UsuarioResponse> usuarios = listarUsuarios();
        Integer totalUsuarios = (usuarios != null) ? usuarios.size() : 0;

        // 3. Retornamos el DTO consolidado combinando ambos mundos en una sola respuesta síncrona [cite: 340, 681]
        String mensajeInformativo = "Información unificada síncronamente desde ms-reportes (" + totalReportes 
                + " registros) y ms-usuarios (" + totalUsuarios + " registros) para la Municipalidad.";
        
        return new DashboardResponse(totalReportes, totalUsuarios, mensajeInformativo); // [cite: 681]
    }

    /**
     * Intermediario para recuperar la lista de usuarios desde ms-usuarios[cite: 675].
     * Utiliza ParameterizedTypeReference para mapear de forma segura colecciones genéricas JSON (List)[cite: 551].
     */
    public List<UsuarioResponse> listarUsuarios() {
        String urlEndpoint = msUsuariosUrl + "/api/usuarios"; // Endpoint expuesto en ms-usuarios [cite: 433]

        // Ejecutamos la llamada HTTP GET hacia el microservicio trasero [cite: 433]
        ResponseEntity<List<UsuarioResponse>> response = restTemplate.exchange(
                urlEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UsuarioResponse>>() {}
        );

        return response.getBody(); // Retorna el cuerpo JSON transformado en lista de objetos Java [cite: 551]
    }

    /**
     * Intermediario para recuperar la lista de reportes desde ms-reportes[cite: 677].
     */
    public List<ReporteResponse> listarReportes() {
        String urlEndpoint = msReportesUrl + "/api/reportes"; // Endpoint expuesto en ms-reportes [cite: 433]

        // Ejecutamos la llamada HTTP GET hacia ms-reportes [cite: 433]
        ResponseEntity<List<ReporteResponse>> response = restTemplate.exchange(
                urlEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReporteResponse>>() {}
        );

        return response.getBody(); // [cite: 572]
    }
}