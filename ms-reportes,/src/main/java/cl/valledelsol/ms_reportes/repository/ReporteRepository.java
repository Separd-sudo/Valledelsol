package cl.valledelsol.ms_reportes.repository;

import cl.valledelsol.ms_reportes.model.Reporte;

import java.util.List;
import java.util.Optional;

public interface ReporteRepository {

    Reporte guardar(Reporte reporte);

    List<Reporte> listar();

    Optional<Reporte> buscarPorId(Long id);

    Reporte actualizar(Reporte reporte);
}