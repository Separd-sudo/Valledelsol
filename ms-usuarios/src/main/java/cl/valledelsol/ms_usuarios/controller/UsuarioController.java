package cl.valledelsol.ms_usuarios.controller;

import cl.valledelsol.ms_usuarios.dto.UsuarioRequest;
import cl.valledelsol.ms_usuarios.dto.UsuarioResponse;
import cl.valledelsol.ms_usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * Controlador REST del microservicio de usuarios.
 * Expone los endpoints para gestionar usuarios y roles.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /*
     * Crea un usuario.
     */
    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@Valid @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(usuarioService.crearUsuario(request));
    }

    /*
     * Lista todos los usuarios.
     */
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    /*
     * Busca usuario por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    /*
     * Actualiza usuario completo.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequest request
    ) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, request));
    }

    /*
     * Cambia solo el rol.
     * JSON esperado: { "rol": "FUNCIONARIO_MUNICIPAL" }
     */
    @PatchMapping("/{id}/rol")
    public ResponseEntity<UsuarioResponse> cambiarRol(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String nuevoRol = body.get("rol");
        return ResponseEntity.ok(usuarioService.cambiarRol(id, nuevoRol));
    }

    /*
     * Activa o desactiva usuario.
     * JSON esperado: { "activo": false }
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<UsuarioResponse> cambiarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, Boolean> body
    ) {
        Boolean activo = body.get("activo");
        return ResponseEntity.ok(usuarioService.cambiarEstado(id, activo));
    }

    /*
     * Elimina usuario.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}