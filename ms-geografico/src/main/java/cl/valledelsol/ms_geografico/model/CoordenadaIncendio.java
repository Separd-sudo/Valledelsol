package cl.valledelsol.ms_geografico.model;

import jakarta.persistence.*;

/**
 * Representa los puntos geográficos críticos almacenados en geografico_db.
 */
@Entity
@Table(name = "coordenadas_incendios")
public class CoordenadaIncendio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGeo;

    @Column(nullable = false, unique = true)
    private Long idReporte; // Garantiza un único pin en el mapa por reporte

    private String sector;
    private Double latitud;
    private Double longitud;
    private String estado;

    public CoordenadaIncendio() {}

    // Getters y Setters explícitos
    public Long getIdGeo() { return idGeo; }
    public void setIdGeo(Long idGeo) { this.idGeo = idGeo; }

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