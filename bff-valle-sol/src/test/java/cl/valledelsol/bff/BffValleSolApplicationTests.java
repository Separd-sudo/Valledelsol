package cl.valledelsol.bff.service; // Asegúrate de que coincida con su paquete real

import cl.valledelsol.bff.BffValleSolApplication; // Importa tu clase principal
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BffValleSolApplication.class) // Le indicamos la clase exacta aquí
class BffValleSolApplicationTests {

    @Test
    void contextLoads() {
        // Prueba automática que solo verifica que el proyecto logre arrancar
    }
}