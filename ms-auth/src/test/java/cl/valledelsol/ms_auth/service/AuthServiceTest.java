package cl.valledelsol.ms_auth.service;

import cl.valledelsol.ms_auth.dto.LoginRequestDTO;
import cl.valledelsol.ms_auth.dto.TokenResponseDTO;
import cl.valledelsol.ms_auth.model.UsuarioAuth;
import cl.valledelsol.ms_auth.repository.UsuarioAuthRepository;
import cl.valledelsol.ms_auth.security.JwtService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthServiceTest {

    @Mock
    private UsuarioAuthRepository usuarioAuthRepository;

    // Necesario porque AuthService depende de PasswordEncoder para
    // verificar el login. Sin este mock, el test fallaria con NPE.
    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    private UsuarioAuth usuarioBase;

    @BeforeEach
    void setUp() {
        usuarioBase = new UsuarioAuth(10L, "test@valledelsol.cl", "Clave123!", "CIUDADANO", "Vecino Colaborador");
    }

    // =========================================================================
    // 1. PRUEBAS DE LÓGICA DE NEGOCIO (MOCKITO)
    // =========================================================================

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de CIUDADANO")
    void autenticarCiudadanoExitoso() {
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        // Simula que el password recibido SI coincide con el hash guardado
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));
        when(jwtService.generarToken(anyLong(), anyString(), anyString(), anyString())).thenReturn("jwt-simulado");
        when(jwtService.getExpirationMs()).thenReturn(3600000L);

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("Bearer", response.getTokenType());
        assertEquals(3600L, response.getExpiresIn());
        assertEquals("CIUDADANO", response.getRol());
        assertEquals("Vecino Colaborador", response.getNombre());
        // El token devuelto es el que retorna el mock de jwtService
        assertEquals("jwt-simulado", response.getTokenJwt());
    }

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de BRIGADISTA")
    void autenticarBrigadistaExitoso() {
        usuarioBase.setRol("BRIGADISTA");
        usuarioBase.setNombre("Trapesio");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));
        when(jwtService.generarToken(anyLong(), anyString(), anyString(), anyString())).thenReturn("jwt-simulado");
        when(jwtService.getExpirationMs()).thenReturn(3600000L);

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("BRIGADISTA", response.getRol());
        assertEquals("jwt-simulado", response.getTokenJwt());
    }

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de FUNCIONARIO")
    void autenticarFuncionarioExitoso() {
        usuarioBase.setRol("FUNCIONARIO");
        usuarioBase.setNombre("Roro");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));
        when(jwtService.generarToken(anyLong(), anyString(), anyString(), anyString())).thenReturn("jwt-simulado");
        when(jwtService.getExpirationMs()).thenReturn(3600000L);

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("FUNCIONARIO", response.getRol());
        assertEquals("jwt-simulado", response.getTokenJwt());
    }

    @Test
    @DisplayName("Debería lanzar excepción cuando el usuario no existe")
    void autenticarUsuarioNoExiste() {
        LoginRequestDTO request = new LoginRequestDTO("inexistente@valledelsol.cl", "Password123");

        // Cuando el usuario no existe, el servicio lanza ANTES de llamar a passwordEncoder
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.autenticar(request);
        });

        assertTrue(exception.getMessage().contains("Acceso Denegado: Las credenciales no existen"));
    }

    @Test
    @DisplayName("Debería lanzar excepción cuando la contraseña es incorrecta")
    void autenticarContrasenaIncorrecta() {
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "ClaveErronea");

        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.autenticar(request);
        });

        assertTrue(exception.getMessage().contains("Acceso Denegado: Contraseña incorrecta"));
    }

    @Test
    @DisplayName("Debería lanzar excepción si el rol del usuario no corresponde a las políticas")
    void autenticarRolInvalido() {
        usuarioBase.setRol("ROLE_ANOMALO");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        // El password debe pasar para que el servicio llegue a validar el rol
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.autenticar(request);
        });

        assertTrue(exception.getMessage().contains("Error del Sistema: El rol"));
    }

    // =========================================================================
    // 2. PRUEBAS DE COBERTURA PARA MODELOS (Getters, Setters y Constructores)
    // =========================================================================

    @Test
    @DisplayName("Debería validar los Getters y Setters de UsuarioAuth")
    void testUsuarioAuthGettersSettersYConstructores() {
        UsuarioAuth usuarioVacio = new UsuarioAuth();
        assertNull(usuarioVacio.getId());

        usuarioVacio.setId(5L);
        usuarioVacio.setCorreo("vecino@valledelsol.cl");
        usuarioVacio.setPassword("segura123");
        usuarioVacio.setRol("CIUDADANO");
        usuarioVacio.setNombre("Brandon");

        assertEquals(5L, usuarioVacio.getId());
        assertEquals("vecino@valledelsol.cl", usuarioVacio.getCorreo());
        assertEquals("segura123", usuarioVacio.getPassword());
        assertEquals("CIUDADANO", usuarioVacio.getRol());
        assertEquals("Brandon", usuarioVacio.getNombre());
    }

    @Test
    @DisplayName("Debería validar los Getters y Setters de LoginRequestDTO")
    void testLoginRequestDTOGettersSettersYConstructores() {
        LoginRequestDTO dtoVacio = new LoginRequestDTO();
        assertNull(dtoVacio.getCorreo());

        dtoVacio.setCorreo("funcionario@valledelsol.cl");
        dtoVacio.setPassword("admin2026");

        assertEquals("funcionario@valledelsol.cl", dtoVacio.getCorreo());
        assertEquals("admin2026", dtoVacio.getPassword());
    }

    @Test
    @DisplayName("Debería validar los Getters y Setters de TokenResponseDTO")
    void testTokenResponseDTOGettersSettersYConstructores() {
        TokenResponseDTO dtoVacio = new TokenResponseDTO();
        assertNull(dtoVacio.getTokenJwt());

        dtoVacio.setTokenJwt("TOKEN_XYZ");
        dtoVacio.setRol("CIUDADANO");
        dtoVacio.setNombre("Brandon");
        dtoVacio.setTokenType("Bearer");
        dtoVacio.setExpiresIn(3600L);

        assertEquals("TOKEN_XYZ", dtoVacio.getTokenJwt());
        assertEquals("CIUDADANO", dtoVacio.getRol());
        assertEquals("Brandon", dtoVacio.getNombre());
        assertEquals("Bearer", dtoVacio.getTokenType());
        assertEquals(3600L, dtoVacio.getExpiresIn());

        TokenResponseDTO dtoCompleto = new TokenResponseDTO("TOKEN_CONSTRUCTOR", "CIUDADANO", "Brandon", "Bearer", 1800L);
        assertEquals("TOKEN_CONSTRUCTOR", dtoCompleto.getTokenJwt());
        assertEquals("Bearer", dtoCompleto.getTokenType());
        assertEquals(1800L, dtoCompleto.getExpiresIn());
    }
}