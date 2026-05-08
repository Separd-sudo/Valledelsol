package cl.valledelsol.ms_reportes.repository;

import cl.valledelsol.ms_reportes.model.Reporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReporteRepositoryMemoria implements ReporteRepository {

    private final List<Reporte> reportes = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong(1);

    @Override
    public Reporte guardar(Reporte reporte) {
        reporte.setId(secuencia.getAndIncrement());
        reportes.add(reporte);
        return reporte;
    }

    @Override
    public List<Reporte> listar() {
        return reportes;
    }

    @Override
    public Optional<Reporte> buscarPorId(Long id) {
        return reportes.stream()
                .filter(reporte -> reporte.getId().equals(id))
                .findFirst();
    }

    @Override
    public Reporte actualizar(Reporte reporteActualizado) {
        buscarPorId(reporteActualizado.getId()).ifPresent(reporte -> {
            reporte.setTitulo(reporteActualizado.getTitulo());
            reporte.setDescripcion(reporteActualizado.getDescripcion());
            reporte.setUbicacion(reporteActualizado.getUbicacion());
            reporte.setEstado(reporteActualizado.getEstado());
        });

        return reporteActualizado;
    }
}