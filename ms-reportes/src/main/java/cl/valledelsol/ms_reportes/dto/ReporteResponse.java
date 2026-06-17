package cl.valledelsol.ms_reportes.dto;

import java.time.LocalDateTime;

/**
 * DTO que formatea la salida hacia el BFF y React.
 */
public class ReporteResponse {
    private Long id;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String nivelRiesgo;
    private String estado;
    private LocalDateTime fechaCreacion;
    private Double latitud;
    private Double longitud;

    public ReporteResponse() {}

    // =========================================================
    // GETTERS Y SETTERS
    // =========================================================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getNivelRiesgo() { return nivelRiesgo; }
    public void setNivelRiesgo(String nivelRiesgo) { this.nivelRiesgo = nivelRiesgo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
}