package cl.valledelsol.ms_auth.repository;

import cl.valledelsol.ms_auth.model.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {
    
    // Este es el Query Method clave que tu AuthService necesita para buscar al usuario por correo
    Optional<UsuarioAuth> findByEmail(String email);
}