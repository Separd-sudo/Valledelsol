package cl.valledelsol.ms_reportes.dto;

public class ReporteRequest {

    private String titulo;
    private String descripcion;
    private String ubicacion;

    public ReporteRequest() {
    }

    public ReporteRequest(String titulo, String descripcion, String ubicacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}