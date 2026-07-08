package cl.valledelsol.bff.dto;

/**
 * DTO de Salida (Response) para el Panel Principal.
 * Consolida métricas de múltiples microservicios en una sola respuesta HTTP
 * para optimizar la carga de la interfaz de usuario en React.
 */
public class DashboardResponse {

    private Integer totalReportes;
    private Integer totalUsuarios;
    private String mensaje;

    // Constructor vacío obligatorio para la serialización de Jackson (JSON)
    public DashboardResponse() {
    }

    // Constructor explícito utilizado por el BffService para armar el objeto rápido
    public DashboardResponse(Integer totalReportes, Integer totalUsuarios, String mensaje) {
        this.totalReportes = totalReportes;
        this.totalUsuarios = totalUsuarios;
        this.mensaje = mensaje;
    }

    // =========================================================
    // GETTERS EXPLÍCITOS (Lectura segura para el Frontend)
    // =========================================================
    public Integer getTotalReportes() {
        return totalReportes;
    }

    public Integer getTotalUsuarios() {
        return totalUsuarios;
    }

    public String getMensaje() {
        return mensaje;
    }

    // =========================================================
    // SETTERS EXPLÍCITOS (Por si se requiere mutación manual)
    // =========================================================
    public void setTotalReportes(Integer totalReportes) {
        this.totalReportes = totalReportes;
    }

    public void setTotalUsuarios(Integer totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}