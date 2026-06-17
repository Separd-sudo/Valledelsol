package cl.valledelsol.ms_reportes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO que captura los datos de entrada desde el exterior.
 */
public class ReporteRequest {

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 1000, message = "La descripción no puede superar los 1000 caracteres")
    private String descripcion;

    @NotBlank(message = "La ubicación no puede estar vacía")
    private String ubicacion;

    @NotBlank(message = "El nivel de riesgo no puede estar vacío")
    private String nivelRiesgo;

    // Campos opcionales para el PATCH de actualización de estado y coordenadas
    private String estado;
    private Double latitud;
    private Double longitud;

    public ReporteRequest() {}

    // =========================================================
    // GETTERS Y SETTERS COMPLETOS
    // =========================================================
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

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
}