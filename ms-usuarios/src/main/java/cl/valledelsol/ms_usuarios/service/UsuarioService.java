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
    public Usuario registrarUsuario(Usuario usuario) {
        // 1. Validar si el correo ya existe para evitar duplicados catastróficos
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo electrónico ya se encuentra registrado.");
        }

        // 2. Inicializar los campos obligatorios del ciclo de vida de la entidad
        usuario.setActivo(true); // Todo usuario nuevo ingresa habilitado
        usuario.setFechaRegistro(LocalDateTime.now()); // Marca de tiempo del servidor

        // 3. Forzar el formato del Rol para evitar inconsistencias de texto
        if (usuario.getRol() != null) {
            usuario.setRol(usuario.getRol().toUpperCase());
        } else {
            usuario.setRol("CIUDADANO"); // Rol por defecto por seguridad
        }

        // 4. Persistir en PostgreSQL
        return usuarioRepository.save(usuario);
    }

    /**
     * Retorna la lista completa de usuarios en el sistema.
     */
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}