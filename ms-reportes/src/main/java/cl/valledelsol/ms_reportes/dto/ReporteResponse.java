package cl.valledelsol.ms_reportes.dto;

import java.time.LocalDateTime;

/*
 * DTO de salida.
 * Define qué información devuelve la API al frontend o BFF.
 */
public class ReporteResponse {

    private Long id;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String nivelRiesgo;
    private String estado;
    private LocalDateTime fechaCreacion;

    public ReporteResponse(
            Long id,
            String titulo,
            String descripcion,
            String ubicacion,
            String nivelRiesgo,
            String estado,
            LocalDateTime fechaCreacion
    ) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.nivelRiesgo = nivelRiesgo;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}