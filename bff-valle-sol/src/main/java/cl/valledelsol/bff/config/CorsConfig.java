package cl.valledelsol.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Permitimos credenciales y tokens haca el Front
        config.setAllowCredentials(true);
        
        // Orígenes explícitos autorizados (localhost e IP de Vite)
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173", "http://127.0.0.1:5173"));
        
        // Permitimos cualquier cabecera (Authorization, Content-Type, etc.)
        config.setAllowedHeaders(Arrays.asList("*"));
        
        // Métodos HTTP explícitos
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Aplicar a todos los endpoints del BFF
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}