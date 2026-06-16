package cl.valledelsol.ms_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase Principal de Arranque del Microservicio de Autenticación.
 * Aquí se configura el contexto de Spring Boot y se inicia la aplicación en el puerto 8083,
 * tal como se ha definido en el archivo application.properties.
 */
@SpringBootApplication
public class MsAuthApplication {

    public static void main(String[] args) {
        // Enciende el motor de Spring Boot en el puerto 8083
        SpringApplication.run(MsAuthApplication.class, args);
    }
}