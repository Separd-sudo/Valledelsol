package cl.valledelsol.ms_geografico.dto;

/**
 * DTO que mapea el evento entrante de Kafka.
 * Captura específicamente las propiedades espaciales del incidente.
 */
public class GeoEventDTO {
    private Long id;
    private String ubicacion;
    private Double latitud;
    private Double longitud;
    private String estado;

    public GeoEventDTO() {}

    // Getters y Setters explícitos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}