package cl.valledelsol.ms_alertas.dto;

import java.time.LocalDateTime;

/**
 * DTO de Evento Global.
 * Modela la estructura completa del reporte para que viaje por Kafka
 * y alimente a Alertas, Historial y Monitoreo Geográfico de una sola vez.
 */
public class AlertaIncendioDTO {
    
    // Datos para la búsqueda e Historial
    private Long idReporte;
    private String descripcion;
    private String estado; // ACTIVO, CONTROLADO
    private String gravedad; // ALTA, MEDIA, BAJA
    
    // Datos para Monitoreo Geográfico (Coordenadas para el mapa)
    private Double latitud;
    private Double longitud;
    private String sector;
    
    // Datos de auditoría para Historial y Analítica
    private String fechaCreacion; 

    public AlertaIncendioDTO() {}

    // =========================================================
    // GETTERS Y SETTERS EXPLÍCITOS
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