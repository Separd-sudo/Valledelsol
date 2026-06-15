package cl.valledelsol.ms_geografico.dto;

/**
 * DTO que mapea el evento entrante de Kafka.
 * Captura específicamente las propiedades espaciales del incidente.
 */
public class GeoEventDTO {
    private Long idReporte;
    private String sector;
    private Double latitud;
    private Double longitud;
    private String estado;

    public GeoEventDTO() {}

    // Getters y Setters explícitos
    public Long getIdReporte() { return idReporte; }
    public void setIdReporte(Long idReporte) { this.idReporte = idReporte; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}