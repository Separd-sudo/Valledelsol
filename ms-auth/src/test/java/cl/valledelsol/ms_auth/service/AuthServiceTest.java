package cl.valledelsol.ms_auth.service;

import cl.valledelsol.ms_auth.dto.LoginRequestDTO;
import cl.valledelsol.ms_auth.dto.TokenResponseDTO;
import cl.valledelsol.ms_auth.model.UsuarioAuth;
import cl.valledelsol.ms_auth.repository.UsuarioAuthRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UsuarioAuthRepository usuarioAuthRepository;

    @InjectMocks
    private AuthService authService;

    private UsuarioAuth usuarioBase;

    @BeforeEach
    void setUp() {
        // 🔑 ALINEADO: Constructor de 5 parámetros incluyendo el campo 'nombre'
        usuarioBase = new UsuarioAuth(10L, "test@valledelsol.cl", "Clave123!", "CIUDADANO", "Vecino Colaborador");
    }

    // =========================================================================
    // 1. PRUEBAS DE LÓGICA DE NEGOCIO (MOCKITO)
    // =========================================================================

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de CIUDADANO")
    void autenticarCiudadanoExitoso() {
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        // 🔑 ALINEADO: findByCorreo() y getCorreo()
        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("Bearer", response.getTokenType());
        assertEquals(3600L, response.getExpiresIn());
        assertEquals("CIUDADANO", response.getRol());
        assertEquals("Vecino Colaborador", response.getNombre());
        // 🔑 ALINEADO: Verifica contra el método corregido getTokenJwt() y el prefijo de tu Service
        assertTrue(response.getTokenJwt().contains("JWT_SECRET_CIUDADANO_VALLE_10"));
    }

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de BRIGADISTA")
    void autenticarBrigadistaExitoso() {
        usuarioBase.setRol("BRIGADISTA");
        usuarioBase.setNombre("Trapesio");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("BRIGADISTA", response.getRol());
        assertTrue(response.getTokenJwt().contains("JWT_SECRET_BRIGADISTA_TERRENO_10"));
    }

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de FUNCIONARIO")
    void autenticarFuncionarioExitoso() {
        // 🔑 ALINEADO: Rol cambiado a 'FUNCIONARIO' para calzar con tu switch del Service y BD
        usuarioBase.setRol("FUNCIONARIO");
        usuarioBase.setNombre("Roro");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(usuarioAuthRepository.findByCorreo(request.getCorreo())).thenReturn(Optional.of(usuarioBase));

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("FUNCIONARIO", response.getRol());
        assertTrue(response.getTokenJwt().contains("JWT_SECRET_ROOT_FUNCIONARIO_MUNICIPAL_10"));
    }

    @Test
    @DisplayName("Debería lanzar excepción cuando el usuario no existe")
    void autenticarUsuarioNoExiste() {
        LoginRequestDTO request = new LoginRequestDTO("inexistente@valledelsol.cl", "Password123");
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
        usuarioVacio.setCorreo("vecino@valledelsol.cl"); // 🔑 ALINEADO
        usuarioVacio.setPassword("segura123");
        usuarioVacio.setRol("CIUDADANO");
        usuarioVacio.setNombre("Brandon");

        assertEquals(5L, usuarioVacio.getId());
        assertEquals("vecino@valledelsol.cl", usuarioVacio.getCorreo()); // 🔑 ALINEADO
        assertEquals("segura123", usuarioVacio.getPassword());
        assertEquals("CIUDADANO", usuarioVacio.getRol());
        assertEquals("Brandon", usuarioVacio.getNombre());
    }

    @Test
    @DisplayName("Debería validar los Getters y Setters de LoginRequestDTO")
    void testLoginRequestDTOGettersSettersYConstructores() {
        LoginRequestDTO dtoVacio = new LoginRequestDTO();
        assertNull(dtoVacio.getCorreo()); // 🔑 ALINEADO

        dtoVacio.setCorreo("funcionario@valledelsol.cl"); // 🔑 ALINEADO
        dtoVacio.setPassword("admin2026");

        assertEquals("funcionario@valledelsol.cl", dtoVacio.getCorreo()); // 🔑 ALINEADO
        assertEquals("admin2026", dtoVacio.getPassword());
    }

    @Test
    @DisplayName("Debería validar los Getters y Setters de TokenResponseDTO")
    void testTokenResponseDTOGettersSettersYConstructores() {
        TokenResponseDTO dtoVacio = new TokenResponseDTO();
        assertNull(dtoVacio.getTokenJwt()); // 🔑 ALINEADO

        dtoVacio.setTokenJwt("TOKEN_XYZ"); // 🔑 ALINEADO
        dtoVacio.setRol("CIUDADANO");
        dtoVacio.setNombre("Brandon");
        dtoVacio.setTokenType("Bearer");
        dtoVacio.setExpiresIn(3600L);

        assertEquals("TOKEN_XYZ", dtoVacio.getTokenJwt()); // 🔑 ALINEADO
        assertEquals("CIUDADANO", dtoVacio.getRol());
        assertEquals("Brandon", dtoVacio.getNombre());
        assertEquals("Bearer", dtoVacio.getTokenType());
        assertEquals(3600L, dtoVacio.getExpiresIn());

        // 🔑 ALINEADO: Constructor nuevo completo de 5 parámetros
        TokenResponseDTO dtoCompleto = new TokenResponseDTO("TOKEN_CONSTRUCTOR", "CIUDADANO", "Brandon", "Bearer", 1800L);
        assertEquals("TOKEN_CONSTRUCTOR", dtoCompleto.getTokenJwt());
        assertEquals("Bearer", dtoCompleto.getTokenType());
        assertEquals(1800L, dtoCompleto.getExpiresIn());
    }
}