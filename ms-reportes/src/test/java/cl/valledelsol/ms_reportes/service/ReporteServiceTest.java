package cl.valledelsol.ms_reportes.service;

import cl.valledelsol.ms_reportes.dto.ReporteRequest;
import cl.valledelsol.ms_reportes.model.Reporte;
import cl.valledelsol.ms_reportes.repository.ReporteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReporteServiceTest {

    @Mock
    private ReporteRepository reporteRepository;

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private ReporteService reporteService;

    @Test
    public void cuandoCrearReporte_entoncesPersisteCorrectamente() {
        // Arrange
        ReporteRequest request = new ReporteRequest();
        request.setTitulo("Incendio Controlado");
        request.setDescripcion("Prueba Unitaria de Cobertura");
        request.setUbicacion("Sector Valparaíso");
        request.setNivelRiesgo("BAJO");
        request.setLatitud(-33.0);
        request.setLongitud(-71.0);

        Reporte mockGuardado = new Reporte();
        mockGuardado.setId(5L);
        mockGuardado.setTitulo("Incendio Controlado");

        when(reporteRepository.save(any(Reporte.class))).thenReturn(mockGuardado);

        // Act
        Reporte resultado = reporteService.crearReporte(request);

        // Assert
        assertNotNull(resultado);
        assertEquals(5L, resultado.getId());
        verify(reporteRepository, times(1)).save(any(Reporte.class));
    }
}