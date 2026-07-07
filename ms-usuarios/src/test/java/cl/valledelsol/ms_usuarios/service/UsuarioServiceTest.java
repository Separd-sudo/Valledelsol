package cl.valledelsol.ms_usuarios.service;

import cl.valledelsol.ms_usuarios.dto.UsuarioRequest;
import cl.valledelsol.ms_usuarios.dto.UsuarioResponse;
import cl.valledelsol.ms_usuarios.model.Usuario;
import cl.valledelsol.ms_usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void cuandoRegistrarUsuario_entoncesRetornaCreadoConExito() {
        // Arrange
        UsuarioRequest request = new UsuarioRequest();
        request.setNombre("Brandon");
        request.setCorreo("brandon@valle.cl");
        request.setPassword("123456");
        request.setRol("CIUDADANO");

        Usuario usuarioMock = new Usuario();
        usuarioMock.setId(1L);
        usuarioMock.setNombre("Brandon");
        usuarioMock.setCorreo("brandon@valle.cl");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioMock);

        // Act
        UsuarioResponse response = usuarioService.registrarUsuario(request);

        // Assert
        assertNotNull(response);
        assertEquals("brandon@valle.cl", response.getCorreo());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }
}