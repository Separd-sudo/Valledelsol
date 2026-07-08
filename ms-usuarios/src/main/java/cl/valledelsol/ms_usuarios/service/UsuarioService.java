package cl.valledelsol.ms_usuarios.service;

import cl.valledelsol.ms_usuarios.model.Usuario;
import cl.valledelsol.ms_usuarios.repository.UsuarioRepository;
import cl.valledelsol.ms_usuarios.config.SecurityConfig;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import cl.valledelsol.ms_usuarios.dto.ActualizarUsuarioRequest;
import cl.valledelsol.ms_usuarios.dto.UsuarioResponse;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Servicio de lógica de negocio para la gestión de usuarios y roles (RBAC).
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Set<String> ROLES_VALIDOS = Set.of("CIUDADANO", "BRIGADISTA", "FUNCIONARIO_MUNICIPAL");


    // Inyección por constructor nativo
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra un nuevo usuario aplicando las reglas de negocio del sistema.
     */
    public cl.valledelsol.ms_usuarios.dto.UsuarioResponse registrarUsuario(cl.valledelsol.ms_usuarios.dto.UsuarioRequest request) {
    
    // 1. Validar si el correo ya existe usando el dato del DTO
         if (usuarioRepository.findByCorreo(request.getCorreo()).isPresent()) {
           throw new RuntimeException("El correo electrónico ya se encuentra registrado.");
    }

    // 2. Crear la entidad de base de datos y mapear los campos desde el Request
    Usuario usuario = new Usuario();
    usuario.setNombre(request.getNombre());
    usuario.setCorreo(request.getCorreo());
    usuario.setPassword(passwordEncoder.encode(request.getPassword())); // 🔑 ¡Ahora sí se asigna la password!
    
    // 3. Inicializar campos del sistema
    usuario.setActivo(true);
    usuario.setFechaRegistro(LocalDateTime.now());

    // 4. Forzar formato del Rol
    usuario.setRol(normalizarRolEstricto(request.getRol() != null ? request.getRol() : "CIUDADANO"));

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


    public UsuarioResponse actualizarUsuario(Long id, ActualizarUsuarioRequest request) {
    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("No existe un usuario con id " + id));

    if (request.getNombre() != null && !request.getNombre().isBlank()) {
        usuario.setNombre(request.getNombre());
    }

    if (request.getCorreo() != null && !request.getCorreo().isBlank()
            && !request.getCorreo().equalsIgnoreCase(usuario.getCorreo())) {
        usuarioRepository.findByCorreo(request.getCorreo()).ifPresent(otro -> {
            throw new RuntimeException("El correo electrónico ya se encuentra registrado por otro usuario.");
        });
        usuario.setCorreo(request.getCorreo());
    }

    if (request.getRol() != null && !request.getRol().isBlank()) {
        usuario.setRol(normalizarRolEstricto(request.getRol()));
    }

    if (request.getActivo() != null) {
        usuario.setActivo(request.getActivo());
    }

    Usuario usuarioActualizado = usuarioRepository.save(usuario);
    return aResponse(usuarioActualizado);
}

private String normalizarRolEstricto(String rolRecibido) {
    if (rolRecibido == null || rolRecibido.isBlank()) {
        throw new IllegalArgumentException("El rol es obligatorio. Roles válidos: " + ROLES_VALIDOS);
    }
    String rolFormateado = rolRecibido.toUpperCase();
    if ("FUNCIONARIO".equals(rolFormateado)) {
        rolFormateado = "FUNCIONARIO_MUNICIPAL";
    }
    if (!ROLES_VALIDOS.contains(rolFormateado)) {
        throw new IllegalArgumentException("Rol inválido: '" + rolRecibido + "'. Roles válidos: " + ROLES_VALIDOS);
    }
    return rolFormateado;
}

private UsuarioResponse aResponse(Usuario usuario) {
    return new UsuarioResponse(
        usuario.getId(), usuario.getNombre(), usuario.getCorreo(),
        usuario.getRol(), usuario.getActivo(), usuario.getFechaRegistro()
    );
}
}   