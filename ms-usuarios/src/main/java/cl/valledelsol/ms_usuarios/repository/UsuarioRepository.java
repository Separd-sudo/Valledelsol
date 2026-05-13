package cl.valledelsol.ms_usuarios.repository;

import cl.valledelsol.ms_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * Repository Pattern.
 * Se encarga del acceso a datos de usuarios.
 * JpaRepository entrega métodos CRUD automáticos.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /*
     * Busca un usuario por correo.
     * Spring Data JPA genera la consulta automáticamente usando el nombre del método.
     */
    Optional<Usuario> findByCorreo(String correo);
}