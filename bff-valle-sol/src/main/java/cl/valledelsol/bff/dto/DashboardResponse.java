package cl.valledelsol.bff.dto;

/*
 * DTO del dashboard del BFF.
 */
public class DashboardResponse {

    private Integer totalReportes;
    private Integer totalUsuarios;
    private String mensaje;

    public DashboardResponse() {}

    public DashboardResponse(Integer totalReportes, Integer totalUsuarios, String mensaje) {
        this.totalReportes = totalReportes;
        this.totalUsuarios = totalUsuarios;
        this.mensaje = mensaje;
    }

    public Integer getTotalReportes() { return totalReportes; }
    public Integer getTotalUsuarios() { return totalUsuarios; }
    public String getMensaje() { return mensaje; }
}