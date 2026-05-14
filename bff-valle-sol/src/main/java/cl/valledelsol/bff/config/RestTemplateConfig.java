package cl.valledelsol.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * Configuración del BFF.
 * RestTemplate permite que el BFF consuma otros servicios HTTP,
 * como ms-reportes y ms-usuarios.
 */
@Configuration
public class RestTemplateConfig {

    /*
     * Bean administrado por Spring.
     * Así podemos inyectar RestTemplate en BffService.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}