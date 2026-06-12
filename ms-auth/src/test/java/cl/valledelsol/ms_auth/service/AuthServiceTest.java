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
        // Contraseña en texto plano puro ("Clave123!") tal como está en tu lógica actual
        usuarioBase = new UsuarioAuth(10L, "test@valledelsol.cl", "Clave123!", "CIUDADANO");
    }

    // =========================================================================
    // 1. PRUEBAS DE LÓGICA DE NEGOCIO (TEXTO PLANO)
    // =========================================================================

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de CIUDADANO")
    void autenticarCiudadanoExitoso() {
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(usuarioAuthRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(usuarioBase));

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertEquals("Bearer", response.getTokenType());
        assertEquals(3600L, response.getExpiresIn());
        assertTrue(response.getAccessToken().contains("TXT_MUNIC_CIUDADANO_VALLE_10"));
    }

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de BRIGADISTA")
    void autenticarBrigadistaExitoso() {
        usuarioBase.setRol("BRIGADISTA");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(usuarioAuthRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(usuarioBase));

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertTrue(response.getAccessToken().contains("TXT_MUNIC_BRIGADISTA_TERRENO_10"));
    }

    @Test
    @DisplayName("Debería autenticar exitosamente y retornar token de FUNCIONARIO_MUNICIPAL")
    void autenticarFuncionarioExitoso() {
        usuarioBase.setRol("FUNCIONARIO_MUNICIPAL");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(usuarioAuthRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(usuarioBase));

        TokenResponseDTO response = authService.autenticar(request);

        assertNotNull(response);
        assertTrue(response.getAccessToken().contains("TXT_MUNIC_MUNIC_FUNCIONARIO_MUNICIPAL_10"));
    }

    @Test
    @DisplayName("Debería lanzar excepción cuando el usuario no existe")
    void autenticarUsuarioNoExiste() {
        LoginRequestDTO request = new LoginRequestDTO("inexistente@valledelsol.cl", "Password123");
        when(usuarioAuthRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.autenticar(request);
        });

        assertTrue(exception.getMessage().contains("Acceso Denegado: Las credenciales no existen"));
    }

    @Test
    @DisplayName("Debería lanzar excepción cuando la contraseña es incorrecta")
    void autenticarContrasenaIncorrecta() {
        // Pasamos una clave que no va a hacer match con "Clave123!"
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "ClaveErronea");
        when(usuarioAuthRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(usuarioBase));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.autenticar(request);
        });

        assertTrue(exception.getMessage().contains("Acceso Denegado: Contraseña Incorrecta"));
    }

    @Test
    @DisplayName("Debería lanzar excepción si el rol del usuario no corresponde a las políticas")
    void autenticarRolInvalido() {
        usuarioBase.setRol("ROLE_ANOMALO");
        LoginRequestDTO request = new LoginRequestDTO("test@valledelsol.cl", "Clave123!");

        when(usuarioAuthRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(usuarioBase));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authService.autenticar(request);
        });

        assertTrue(exception.getMessage().contains("Error del Sistema: El rol asignado no corresponde a las políticas"));
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
        usuarioVacio.setEmail("vecino@valledelsol.cl");
        usuarioVacio.setPassword("segura123");
        usuarioVacio.setRol("CIUDADANO");

        assertEquals(5L, usuarioVacio.getId());
        assertEquals("vecino@valledelsol.cl", usuarioVacio.getEmail());
        assertEquals("segura123", usuarioVacio.getPassword());
        assertEquals("CIUDADANO", usuarioVacio.getRol());
    }

    @Test
    @DisplayName("Debería validar los Getters y Setters de LoginRequestDTO")
    void testLoginRequestDTOGettersSettersYConstructores() {
        LoginRequestDTO dtoVacio = new LoginRequestDTO();
        assertNull(dtoVacio.getEmail());

        dtoVacio.setEmail("funcionario@valledelsol.cl");
        dtoVacio.setPassword("admin2026");

        assertEquals("funcionario@valledelsol.cl", dtoVacio.getEmail());
        assertEquals("admin2026", dtoVacio.getPassword());
    }

    @Test
    @DisplayName("Debería validar los Getters y Setters de TokenResponseDTO")
    void testTokenResponseDTOGettersSettersYConstructores() {
        TokenResponseDTO dtoVacio = new TokenResponseDTO();
        assertNull(dtoVacio.getAccessToken());

        dtoVacio.setAccessToken("TOKEN_XYZ");
        dtoVacio.setTokenType("Bearer");
        dtoVacio.setExpiresIn(3600L);

        assertEquals("TOKEN_XYZ", dtoVacio.getAccessToken());
        assertEquals("Bearer", dtoVacio.getTokenType());
        assertEquals(3600L, dtoVacio.getExpiresIn());

        TokenResponseDTO dtoCompleto = new TokenResponseDTO("TOKEN_CONSTRUCTOR", "Bearer", 1800L);
        assertEquals("TOKEN_CONSTRUCTOR", dtoCompleto.getAccessToken());
        assertEquals("Bearer", dtoCompleto.getTokenType());
        assertEquals(1800L, dtoCompleto.getExpiresIn());
    }
}