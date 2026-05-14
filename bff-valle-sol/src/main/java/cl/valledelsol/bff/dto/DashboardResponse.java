package cl.valledelsol.bff.dto;

/*
 * DTO de salida para el dashboard del BFF.
 *
 * Este objeto resume información obtenida desde distintos microservicios.
 * Por ejemplo:
 * - total de reportes desde ms-reportes
 * - total de usuarios desde ms-usuarios
 *
 * Así el frontend recibe una respuesta simple y adaptada,
 * sin consultar cada microservicio por separado.
 */
public class DashboardResponse {

    private Integer totalReportes;
    private Integer totalUsuarios;
    private String mensaje;

    public DashboardResponse(Integer totalReportes, Integer totalUsuarios, String mensaje) {
        this.totalReportes = totalReportes;
        this.totalUsuarios = totalUsuarios;
        this.mensaje = mensaje;
    }

    public Integer getTotalReportes() {
        return totalReportes;
    }

    public Integer getTotalUsuarios() {
        return totalUsuarios;
    }

    public String getMensaje() {
        return mensaje;
    }
}