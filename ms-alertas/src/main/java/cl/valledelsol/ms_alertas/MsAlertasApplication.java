package cl.valledelsol.ms_alertas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Clase principal del microservicio de alertas.
 *
 * @SpringBootApplication inicia Spring Boot y escanea automáticamente
 * todos los componentes dentro de este paquete:
 *
 * cl.valledelsol.ms_alertas.controller
 * cl.valledelsol.ms_alertas.service
 * cl.valledelsol.ms_alertas.repository
 * cl.valledelsol.ms_alertas.model
 * cl.valledelsol.ms_alertas.dto
 * Esto permite que Spring gestione la inyección de dependencias y el ciclo de vida
 */
@SpringBootApplication
public class MsAlertasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAlertasApplication.class, args);
    }
}