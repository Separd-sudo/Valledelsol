package cl.valledelsol.ms_usuarios.controller;

import cl.valledelsol.ms_usuarios.model.Usuario;
import cl.valledelsol.ms_usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import cl.valledelsol.ms_usuarios.dto.ActualizarUsuarioRequest;
import java.util.NoSuchElementException;
import java.util.Map;
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
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody cl.valledelsol.ms_usuarios.dto.UsuarioRequest request) {
    try {
        // 1. Llamamos al servicio pasando el DTO de entrada
        cl.valledelsol.ms_usuarios.dto.UsuarioResponse response = usuarioService.registrarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    /**
     * Endpoint para listar todos los usuarios del ecosistema.
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }


    @PutMapping("/{id}")
public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody ActualizarUsuarioRequest request) {
    try {
        var response = usuarioService.actualizarUsuario(id, request);
        return ResponseEntity.ok(response);
    } catch (NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage()));
    }
}
}