package cl.valledelsol.bff.dto;

/*
 * DTO del BFF para representar usuarios desde ms-usuarios.
 */
public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String correo;
    private String rol;
    private Boolean activo;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String nombre, String correo, String rol, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getRol() { return rol; }
    public Boolean getActivo() { return activo; }
}