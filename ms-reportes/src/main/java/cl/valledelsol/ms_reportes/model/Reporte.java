package cl.valledelsol.ms_reportes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/*
 * Entidad JPA que representa la tabla "reportes" en PostgreSQL.
 * @Entity permite que Hibernate/JPA administre esta clase como una tabla.
 */
@Entity
@Table(name = "reportes")
public class Reporte {

    /*
     * Identificador único del reporte.
     * GenerationType.IDENTITY permite que PostgreSQL genere el ID automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Título breve del reporte de incendio.
     */
    @Column(nullable = false)
    private String titulo;

    /*
     * Descripción detallada del evento reportado.
     */
    @Column(nullable = false, length = 1000)
    private String descripcion;

    /*
     * Ubicación textual del incidente.
     */
    @Column(nullable = false)
    private String ubicacion;

    /*
     * Nivel de riesgo del reporte.
     * Ejemplos: BAJO, MEDIO, ALTO, CRITICO.
     */
    @Column(nullable = false)
    private String nivelRiesgo;

    /*
     * Estado del reporte.
     * Ejemplos: PENDIENTE, EN_REVISION, ATENDIDO, CERRADO.
     */
    @Column(nullable = false)
    private String estado;

    /*
     * Fecha y hora en que se creó el reporte.
     */
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private Double latitud; // Coordenada geográfica para Monitoreo Geográfico      

    @Column(nullable = false)
    private Double longitud; // Coordenada geográfica para Monitoreo Geográfico     

    /*
     * Constructor vacío obligatorio para JPA.
     */
    public Reporte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}