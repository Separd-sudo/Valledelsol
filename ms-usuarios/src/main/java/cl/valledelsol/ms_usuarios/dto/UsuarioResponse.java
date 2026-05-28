package cl.valledelsol.ms_usuarios.dto;

import java.time.LocalDateTime;

/*
 * DTO de salida para usuarios.
 * Define qué información se devuelve al BFF o frontend.
 */
public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String correo;
    private String rol;
    private Boolean activo;
    private LocalDateTime fechaRegistro;

    public UsuarioResponse(Long id, String nombre, String correo, String rol, Boolean activo, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
}
