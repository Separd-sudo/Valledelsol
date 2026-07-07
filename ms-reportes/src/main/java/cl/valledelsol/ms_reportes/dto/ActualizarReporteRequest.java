package cl.valledelsol.ms_reportes.dto;

public class ActualizarReporteRequest {
    private String estado;
    private String descripcion;

    public ActualizarReporteRequest() {}

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}