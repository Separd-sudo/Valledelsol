package cl.valledelsol.ms_analitica.service;

import cl.valledelsol.ms_analitica.dto.ReporteEventDTO;
import cl.valledelsol.ms_analitica.model.RegistroHistorico;
import cl.valledelsol.ms_analitica.repository.RegistroHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnaliticaService {

    @Autowired
    private RegistroHistoricoRepository repository;

    /**
     * Transforma el evento que viene de Kafka en una Entidad y lo guarda en la BD.
     */
    public void registrarEnHistorial(ReporteEventDTO evento) {
        RegistroHistorico historial = new RegistroHistorico();
        historial.setIdReporteOriginal(evento.getId());
        historial.setDescripcion(evento.getDescripcion());
        historial.setEstado(evento.getEstado());
        historial.setGravedad(evento.getNivelRiesgo());
        historial.setSector(evento.getUbicacion());
        historial.setFechaRegistroKafka(LocalDateTime.now().toString());

        repository.save(historial);
        System.out.println("💾 [MS-ANALITICA] Evento persistido con éxito en analitica_db para el reporte ID: " + evento.getId());
    }

    /**
     * Retorna todos los registros guardados para auditoría de la municipalidad.
     */
    public List<RegistroHistorico> obtenerTodoElHistorial() {
        return repository.findAll();
    }
}