package cl.valledelsol.ms_reportes.dto;

import java.io.Serializable;

public class ReporteRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String nivelRiesgo; // 🔑 CORREGIDO: Tu variable real

    public ReporteRequest() {
    }

    public ReporteRequest(String titulo, String descripcion, String ubicacion, String nivelRiesgo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.nivelRiesgo = nivelRiesgo;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getNivelRiesgo() { return nivelRiesgo; }
    public void setNivelRiesgo(String nivelRiesgo) { this.nivelRiesgo = nivelRiesgo; }
}