package cl.valledelsol.ms_reportes.repository;

import cl.valledelsol.ms_reportes.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Repository Pattern.
 * Esta interfaz separa el acceso a datos de la lógica de negocio.
 *
 * JpaRepository entrega métodos automáticos:
 * - save()
 * - findAll()
 * - findById()
 * - delete()
 */
@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}