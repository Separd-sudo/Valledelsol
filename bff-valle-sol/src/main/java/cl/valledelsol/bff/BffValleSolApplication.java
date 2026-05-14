package cl.valledelsol.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Clase principal del BFF Valle del Sol.
 *
 * @SpringBootApplication inicia la aplicación Spring Boot y escanea
 * automáticamente los componentes dentro del paquete cl.valledelsol.bff,
 * incluyendo controller, service, dto y config.
 */
@SpringBootApplication
public class BffValleSolApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffValleSolApplication.class, args);
    }
}