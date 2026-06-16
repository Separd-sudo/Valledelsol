package cl.valledelsol.ms_analitica.repository;

import cl.valledelsol.ms_analitica.model.RegistroHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de Acceso a Datos utilizando Spring Data JPA.
 */
@Repository
public interface RegistroHistoricoRepository extends JpaRepository<RegistroHistorico, Long> {
    // Hereda de forma nativa métodos como save(), findAll(), findById()
}