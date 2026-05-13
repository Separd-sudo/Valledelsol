package cl.valledelsol.ms_usuarios.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/*
 * Entidad JPA que representa la tabla usuarios en PostgreSQL.
 * Cada usuario puede ser ciudadano, brigadista o funcionario municipal.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    /*
     * Identificador único del usuario.
     * PostgreSQL genera este valor automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Nombre completo del usuario.
     */
    @Column(nullable = false)
    private String nombre;

    /*
     * Correo único del usuario.
     * Se usa unique = true para evitar registros duplicados.
     */
    @Column(nullable = false, unique = true)
    private String correo;

    /*
     * Rol del usuario en el sistema.
     * Valores esperados: CIUDADANO, BRIGADISTA, FUNCIONARIO_MUNICIPAL.
     */
    @Column(nullable = false)
    private String rol;

    /*
     * Indica si el usuario está activo en el sistema.
     */
    @Column(nullable = false)
    private Boolean activo;

    /*
     * Fecha de creación del usuario.
     */
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    public Usuario() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}