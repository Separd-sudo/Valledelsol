package cl.valledelsol.ms_usuarios.controller;

import cl.valledelsol.ms_usuarios.model.Usuario;
import cl.valledelsol.ms_usuarios.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST del Microservicio Temático de Usuarios (ms-usuarios).
 * Expone endpoints internos consumidos por el BFF.
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Endpoint para procesar el registro de un nuevo usuario.
     */
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (RuntimeException e) {
            // Retorna un mensaje de error limpio en caso de correo duplicado
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint para listar todos los usuarios del ecosistema.
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
}