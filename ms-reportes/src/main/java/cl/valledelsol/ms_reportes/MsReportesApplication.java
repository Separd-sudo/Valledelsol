package cl.valledelsol.ms_reportes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/*
 * Clase principal del microservicio de reportes.
 *
 * @SpringBootApplication inicia Spring Boot y escanea automáticamente
 * todos los componentes dentro de este paquete:
 *
 * cl.valledelsol.ms_reportes.controller
 * cl.valledelsol.ms_reportes.service
 * cl.valledelsol.ms_reportes.repository
 * cl.valledelsol.ms_reportes.model
 * cl.valledelsol.ms_reportes.dto
 * Esto permite que Spring gestione la inyección de dependencias y el ciclo de vida
 */
@EnableKafka
@SpringBootApplication
public class MsReportesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsReportesApplication.class, args);
    }
}