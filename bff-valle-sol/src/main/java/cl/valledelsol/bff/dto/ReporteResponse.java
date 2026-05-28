package cl.valledelsol.bff.dto;

import java.time.LocalDateTime;

/*
 * DTO del BFF para mapear reportes desde ms-reportes.
 * Debe reflejar la estructura real del microservicio.
 */
public class ReporteResponse {

    private Long id;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String nivelRiesgo;
    private String estado;
    private LocalDateTime fechaCreacion;

    public ReporteResponse() {
    }

    public ReporteResponse(Long id, String titulo, String descripcion, String ubicacion,
                           String nivelRiesgo, String estado, LocalDateTime fechaCreacion) {
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