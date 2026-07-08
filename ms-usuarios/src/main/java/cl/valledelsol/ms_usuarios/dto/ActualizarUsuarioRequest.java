package cl.valledelsol.ms_usuarios.dto;

public class ActualizarUsuarioRequest {
    private String nombre;
    private String correo;
    private String rol;
    private Boolean activo;

    public ActualizarUsuarioRequest() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}