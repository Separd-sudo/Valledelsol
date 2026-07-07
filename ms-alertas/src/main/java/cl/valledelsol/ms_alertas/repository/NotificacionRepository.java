package cl.valledelsol.ms_alertas.repository;

import cl.valledelsol.ms_alertas.model.NotificacionEnviada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<NotificacionEnviada, Long> {
}