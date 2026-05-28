package cl.valledelsol.ms_reportes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/*
 * DTO de entrada.
 * Se usa para recibir datos desde el frontend, BFF o Postman/curl.
 * No usamos directamente la entidad Reporte para proteger la estructura interna.
 */
public class ReporteRequest {

    /*
     * @NotBlank evita valores vacíos.
     * @Size limita la cantidad de caracteres.
     */
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede superar los 100 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 1000, message = "La descripción no puede superar los 1000 caracteres")
    private String descripcion;

    @NotBlank(message = "La ubicación es obligatoria")
    @Size(max = 150, message = "La ubicación no puede superar los 150 caracteres")
    private String ubicacion;

    @NotBlank(message = "El nivel de riesgo es obligatorio")
    private String nivelRiesgo;

    public ReporteRequest() {
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }
}