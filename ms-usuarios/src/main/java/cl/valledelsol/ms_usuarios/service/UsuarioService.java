package cl.valledelsol.ms_usuarios.service;

import cl.valledelsol.ms_usuarios.dto.UsuarioRequest;
import cl.valledelsol.ms_usuarios.dto.UsuarioResponse;
import cl.valledelsol.ms_usuarios.model.Usuario;
import cl.valledelsol.ms_usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
 * Service Layer.
 * Contiene la lógica de negocio del microservicio de usuarios.
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /*
     * Crea un usuario nuevo.
     * Antes de guardar, valida que el correo no esté registrado.
     */
    public UsuarioResponse crearUsuario(UsuarioRequest request) {

        usuarioRepository.findByCorreo(request.getCorreo())
                .ifPresent(usuario -> {
                    throw new RuntimeException("Ya existe un usuario con el correo: " + request.getCorreo());
                });

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setCorreo(request.getCorreo());
        usuario.setRol(request.getRol());
        usuario.setActivo(true);
        usuario.setFechaRegistro(LocalDateTime.now());

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return convertirAResponse(usuarioGuardado);
    }

    /*
     * Lista todos los usuarios.
     */
    public List<UsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    /*
     * Busca un usuario por ID.
     */
    public UsuarioResponse buscarUsuarioPorId(Long id) {
        Usuario usuario = obtenerUsuario(id);
        return convertirAResponse(usuario);
    }

    /*
     * Actualiza los datos generales del usuario.
     */
    public UsuarioResponse actualizarUsuario(Long id, UsuarioRequest request) {
        Usuario usuario = obtenerUsuario(id);

        usuario.setNombre(request.getNombre());
        usuario.setCorreo(request.getCorreo());
        usuario.setRol(request.getRol());

        Usuario actualizado = usuarioRepository.save(usuario);

        return convertirAResponse(actualizado);
    }

    /*
     * Cambia únicamente el rol del usuario.
     */
    public UsuarioResponse cambiarRol(Long id, String nuevoRol) {
        Usuario usuario = obtenerUsuario(id);

        usuario.setRol(nuevoRol);

        Usuario actualizado = usuarioRepository.save(usuario);

        return convertirAResponse(actualizado);
    }

    /*
     * Activa o desactiva un usuario.
     */
    public UsuarioResponse cambiarEstado(Long id, Boolean activo) {
        Usuario usuario = obtenerUsuario(id);

        usuario.setActivo(activo);

        Usuario actualizado = usuarioRepository.save(usuario);

        return convertirAResponse(actualizado);
    }

    /*
     * Elimina un usuario existente.
     */
    public void eliminarUsuario(Long id) {
        Usuario usuario = obtenerUsuario(id);
        usuarioRepository.delete(usuario);
    }

    /*
     * Método auxiliar para evitar repetir la búsqueda por ID.
     */
    private Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    /*
     * Convierte una entidad Usuario a UsuarioResponse.
     * Esto evita exponer directamente la entidad de persistencia.
     */
    private UsuarioResponse convertirAResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol(),
                usuario.getActivo(),
                usuario.getFechaRegistro()
        );
    }
}