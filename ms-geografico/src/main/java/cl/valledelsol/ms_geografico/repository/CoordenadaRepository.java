package cl.valledelsol.ms_geografico.repository;

import cl.valledelsol.ms_geografico.model.CoordenadaIncendio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CoordenadaRepository extends JpaRepository<CoordenadaIncendio, Long> {
    // Operaciones CRUD nativas de Spring Data
    Optional<CoordenadaIncendio> findByIdReporte(Long idReporte);
}
