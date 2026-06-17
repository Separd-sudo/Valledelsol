package cl.valledelsol.bff.service;

import cl.valledelsol.bff.dto.DashboardResponse;
import cl.valledelsol.bff.dto.ReporteResponse;
import cl.valledelsol.bff.dto.UsuarioResponse;
import cl.valledelsol.bff.dto.UsuarioRequest; // Importamos el nuevo DTO de registro
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Capa de Servicio del BFF (Backend For Frontend).
 * Este componente es el núcleo de la orquestación: se encarga de consumir las APIs 
 * síncronas de los microservicios traseros y unificar las respuestas para React.
 * Implementado sin dependencias de Lombok.
 */
@Service
public class BffService {

    // Instancia compartida de RestTemplate inyectada por el constructor
    private final RestTemplate restTemplate;

    /*
     * Inyección dinámica de las URLs base desde el archivo application.properties.
     * Permite cambiar los entornos de ejecución (Localhost vs Contenedores Docker) sin tocar el código.
     */
    @Value("${ms.usuarios.url:http://localhost:8082}")
    private String msUsuariosUrl;

    @Value("${ms.reportes.url:http://localhost:8081}")
    private String msReportesUrl;

    /**
     * Inyección de dependencia por constructor, cumpliendo con las buenas prácticas del arquetipo.
     */
    public BffService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Orquestación del Dashboard: Consume de manera síncrona y simultánea la lista de reportes 
     * y la lista de usuarios para calcular los totales requeridos por la pantalla de React.
     */
    public DashboardResponse obtenerDashboard() {
        // 1. Obtenemos la lista de reportes llamando al microservicio ms-reportes 
        List<ReporteResponse> reportes = listarReportes();
        Integer totalReportes = (reportes != null) ? reportes.size() : 0;

        // 2. Obtenemos la lista de usuarios llamando al microservicio ms-usuarios 
        List<UsuarioResponse> usuarios = listarUsuarios();
        Integer totalUsuarios = (usuarios != null) ? usuarios.size() : 0;

        // 3. Retornamos el DTO consolidado combinando ambos mundos en una sola respuesta síncrona 
        String mensajeInformativo = "Información unificada síncronamente desde ms-reportes (" + totalReportes 
                + " registros) y ms-usuarios (" + totalUsuarios + " registros) para la Municipalidad.";
        
        return new DashboardResponse(totalReportes, totalUsuarios, mensajeInformativo);
    }

    /**
     * Procesa el registro de un nuevo usuario actuando como intermediario.
     * Transfiere los datos de React hacia el controlador de ms-usuarios en la red interna.
     */
    /**
     * Procesa el registro de un nuevo usuario actuando como intermediario.
     * Transfiere los datos de React hacia el controlador de ms-usuarios en la red interna.
     * Modificado a Object para evitar quiebres de mapeo de DTOs en respuestas HTTP.
     */
    public Object registrarUsuario(UsuarioRequest request) {
        // Apunta al endpoint expuesto por el controlador nativo de ms-usuarios
        String urlEndpoint = msUsuariosUrl + "/api/v1/usuarios";

        // Usamos Object.class para capturar el JSON crudo del microservicio y enviarlo de vuelta directo al Front
        ResponseEntity<Object> response = restTemplate.postForEntity(
                urlEndpoint,
                request,
                Object.class
        );

        return response.getBody();
    }

    /**
     * Intermediario para recuperar la lista de usuarios desde ms-usuarios.
     * Utiliza ParameterizedTypeReference para mapear de forma segura colecciones genéricas JSON (List).
     */
    public List<UsuarioResponse> listarUsuarios() {
        String urlEndpoint = msUsuariosUrl + "/api/v1/usuarios"; // Alineado con la ruta REST del microservicio

        // Ejecutamos la llamada HTTP GET hacia el microservicio trasero
        ResponseEntity<List<UsuarioResponse>> response = restTemplate.exchange(
                urlEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UsuarioResponse>>() {}
        );

        return response.getBody(); // Retorna el cuerpo JSON transformado en lista de objetos Java
    }

    /**
     * Intermediario para recuperar la lista de reportes desde ms-reportes.
     */
    public List<ReporteResponse> listarReportes() {
        String urlEndpoint = msReportesUrl + "/api/v1/reportes"; // Alineado con la ruta REST del microservicio

        // Ejecutamos la llamada HTTP GET hacia ms-reportes
        ResponseEntity<List<ReporteResponse>> response = restTemplate.exchange(
                urlEndpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReporteResponse>>() {}
        );

        return response.getBody();
    }
}