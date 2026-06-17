package cl.valledelsol.ms_analitica.model;

import jakarta.persistence.*;

/**
 * Entidad de Negocio Relacional.
 * Define la estructura de la tabla "registro_historico_incendios" en analitica_db.
 */
@Entity
@Table(name = "registro_historico_incendios")
public class RegistroHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInterno; // Clave primaria interna del microservicio de analítica

    @Column(nullable = false)
    private Long idReporteOriginal; // Mantiene la trazabilidad con el ms-reportes

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 30)
    private String estado;

    @Column(length = 20)
    private String gravedad;

    private String sector;
    private String fechaRegistroKafka; // Registra el momento exacto del procesamiento asíncrono

    public RegistroHistorico() {}

    // =========================================================
    // GETTERS Y SETTERS EXPLÍCITOS
    // =========================================================
    public Long getIdInterno() { return idInterno; }
    public void setIdInterno(Long idInterno) { this.idInterno = idInterno; }

    public Long getIdReporteOriginal() { return idReporteOriginal; }
    public void setIdReporteOriginal(Long idReporteOriginal) { this.idReporteOriginal = idReporteOriginal; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getGravedad() { return gravedad; }
    public void setGravedad(String gravedad) { this.gravedad = gravedad; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public String getFechaRegistroKafka() { return fechaRegistroKafka; }
    public void setFechaRegistroKafka(String fechaRegistroKafka) { this.fechaRegistroKafka = fechaRegistroKafka; }
}