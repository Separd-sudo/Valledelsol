package cl.valledelsol.bff.service;

import cl.valledelsol.bff.dto.DashboardResponse;
import cl.valledelsol.bff.dto.ReporteResponse;
import cl.valledelsol.bff.dto.UsuarioResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BffServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BffService BffService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(BffService, "msUsuariosUrl", "http://localhost:8082");
        ReflectionTestUtils.setField(BffService, "msReportesUrl", "http://localhost:8081");
    }

    @Test
    void cuandoMicroserviciosRespondenOk_entoncesRetornaDashboardConsolidado() {
        // Usamos constructores vacíos y llenamos con Setters para evitar errores de longitud de parámetros
        UsuarioResponse user1 = new UsuarioResponse();
        UsuarioResponse user2 = new UsuarioResponse();
        
        List<UsuarioResponse> listaUsuariosSimulada = new ArrayList<>();
        listaUsuariosSimulada.add(user1);
        listaUsuariosSimulada.add(user2);
        
        // Evitamos la ambigüedad usando directamente el método estático .ok() de ResponseEntity
        ResponseEntity<List<UsuarioResponse>> responseUsuarios = ResponseEntity.ok(listaUsuariosSimulada);

        ReporteResponse rep1 = new ReporteResponse();
        ReporteResponse rep2 = new ReporteResponse();
        ReporteResponse rep3 = new ReporteResponse();

        List<ReporteResponse> listaReportesSimulada = new ArrayList<>();
        listaReportesSimulada.add(rep1);
        listaReportesSimulada.add(rep2);
        listaReportesSimulada.add(rep3);
        
        ResponseEntity<List<ReporteResponse>> responseReportes = ResponseEntity.ok(listaReportesSimulada);

        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.contains("/api/usuarios"),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.any(ParameterizedTypeReference.class)
        )).thenReturn(responseUsuarios);

        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.contains("/api/reportes"),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.any(ParameterizedTypeReference.class)
        )).thenReturn(responseReportes);

        DashboardResponse resultado = BffService.obtenerDashboard();

        assertNotNull(resultado);
        assertEquals(2, resultado.getTotalUsuarios());
        assertEquals(3, resultado.getTotalReportes());
    }

    @Test
    void cuandoMicroserviciosRespondenNulo_entoncesDashboardRetornaTotalesEnCero() {
        // Pasamos una lista vacía para simular la ausencia de registros de forma segura
        List<UsuarioResponse> listaUserVacia = new ArrayList<>();
        List<ReporteResponse> listaRepVacia = new ArrayList<>();

        ResponseEntity<List<UsuarioResponse>> responseUsuariosNula = ResponseEntity.ok(listaUserVacia);
        ResponseEntity<List<ReporteResponse>> responseReportesNula = ResponseEntity.ok(listaRepVacia);

        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.contains("/api/usuarios"),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.any(ParameterizedTypeReference.class)
        )).thenReturn(responseUsuariosNula);

        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.contains("/api/reportes"),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.any(ParameterizedTypeReference.class)
        )).thenReturn(responseReportesNula);

        DashboardResponse resultado = BffService.obtenerDashboard();

        assertNotNull(resultado);
        assertEquals(0, resultado.getTotalUsuarios());
        assertEquals(0, resultado.getTotalReportes());
    }
}