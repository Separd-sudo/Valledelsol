package cl.valledelsol.ms_usuarios.service;

import cl.valledelsol.ms_usuarios.model.Usuario;
import cl.valledelsol.ms_usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio de lógica de negocio para la gestión de usuarios y roles (RBAC).
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección por constructor nativo
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Registra un nuevo usuario aplicando las reglas de negocio del sistema.
     */
    // Cambia tu método registrarUsuario en UsuarioService.java por este:
public cl.valledelsol.ms_usuarios.dto.UsuarioResponse registrarUsuario(cl.valledelsol.ms_usuarios.dto.UsuarioRequest request) {
    
    // 1. Validar si el correo ya existe usando el dato del DTO
    if (usuarioRepository.findByCorreo(request.getCorreo()).isPresent()) {
        throw new RuntimeException("El correo electrónico ya se encuentra registrado.");
    }

    // 2. Crear la entidad de base de datos y mapear los campos desde el Request
    Usuario usuario = new Usuario();
    usuario.setNombre(request.getNombre());
    usuario.setCorreo(request.getCorreo());
    usuario.setPassword(request.getPassword()); // 🔑 ¡Ahora sí se asigna la password!
    
    // 3. Inicializar campos del sistema
    usuario.setActivo(true);
    usuario.setFechaRegistro(LocalDateTime.now());

    // 4. Forzar formato del Rol
    if (request.getRol() != null) {
        String rolFormateado = request.getRol().toUpperCase();
        if ("FUNCIONARIO".equals(rolFormateado)) {
            usuario.setRol("FUNCIONARIO_MUNICIPAL");
        } else {
            usuario.setRol(rolFormateado);
        }
    } else {
        usuario.setRol("CIUDADANO");
    }

    // 5. Persistir en PostgreSQL
    Usuario usuarioGuardado = usuarioRepository.save(usuario);

    // 6. Retornar el Response DTO estructurado (Sin exponer la password al BFF/Front)
    return new cl.valledelsol.ms_usuarios.dto.UsuarioResponse(
        usuarioGuardado.getId(),
        usuarioGuardado.getNombre(),
        usuarioGuardado.getCorreo(),
        usuarioGuardado.getRol(),
        usuarioGuardado.getActivo(),
        usuarioGuardado.getFechaRegistro()
    );
}

    /**
     * Método adicional para listar todos los usuarios (puede ser útil para el Dashboard).
     */
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}   