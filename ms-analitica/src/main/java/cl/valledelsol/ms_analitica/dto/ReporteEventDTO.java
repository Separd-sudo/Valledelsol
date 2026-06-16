package cl.valledelsol.ms_analitica.dto;

/**
 * DTO de Evento de Entrada.
 * Representa la estructura del JSON que viene navegando por el tópico de Apache Kafka.
 */
public class ReporteEventDTO {
    
    private Long idReporte;
    private String descripcion;
    private String estado;
    private String gravedad;
    private Double latitud;
    private Double longitud;
    private String sector;
    private String fechaCreacion;

    public ReporteEventDTO() {}

    // =========================================================
    // GETTERS Y SETTERS EXPLÍCITOS (Encapsulamiento de Datos)
    // =========================================================
    public Long getIdReporte() { return idReporte; }
    public void setIdReporte(Long idReporte) { this.idReporte = idReporte; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getGravedad() { return gravedad; }
    public void setGravedad(String gravedad) { this.gravedad = gravedad; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}