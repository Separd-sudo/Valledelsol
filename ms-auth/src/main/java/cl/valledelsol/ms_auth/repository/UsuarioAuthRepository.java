package cl.valledelsol.ms_auth.repository;

import cl.valledelsol.ms_auth.model.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {
    
    // 🔑 CORREGIDO: Ahora busca por columna 'correo' de forma nativa
    Optional<UsuarioAuth> findByCorreo(String correo);
}