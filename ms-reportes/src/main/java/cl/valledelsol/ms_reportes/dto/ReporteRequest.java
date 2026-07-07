package cl.valledelsol.ms_reportes.dto;

import java.io.Serializable;

public class ReporteRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String nivelRiesgo;
    // 🔑 REPARADO CRÍTICO: Añadimos las propiedades que faltaban en el contrato del DTO
    private Double latitud;
    private Double longitud;

    public ReporteRequest() {
    }

    public ReporteRequest(String titulo, String descripcion, String ubicacion, String nivelRiesgo, Double latitud, Double longitud) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.nivelRiesgo = nivelRiesgo;
        this.latitud = latitud;
        this.longitud = longitud;
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

    // 🔑 Getters y Setters añadidos para la API REST
    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
}