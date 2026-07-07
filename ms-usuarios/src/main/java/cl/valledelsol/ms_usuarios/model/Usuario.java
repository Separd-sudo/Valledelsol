package cl.valledelsol.ms_usuarios.model; // Paquete exacto de tu proyecto

import jakarta.persistence.*;
import java.time.LocalDateTime;

/*
 * Entidad JPA que representa la tabla usuarios en PostgreSQL[cite: 490].
 * Cada usuario puede ser ciudadano, brigadista o funcionario municipal[cite: 491].
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PostgreSQL genera este valor automáticamente [cite: 493]
    private Long id;

    @Column(nullable = false)
    private String nombre; // Nombre completo del usuario [cite: 494]

    @Column(nullable = false, unique = true)
    private String correo; // Correo único para evitar registros duplicados [cite: 496, 497]

    /*
     * REFACTORIZACIÓN: Se cambia 'contraseña' por 'password' para evitar caracteres especiales.
     * Esto previene errores de codificación (encoding) al recibir datos desde el Frontend en React.
     */
    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false)
    private String rol; // Valores esperados: CIUDADANO, BRIGADISTA, FUNCIONARIO_MUNICIPAL [cite: 499, 500]

    @Column(nullable = false)
    private Boolean activo; // Indica si el usuario está activo en el sistema [cite: 501]

    @Column(nullable = false)
    private LocalDateTime fechaRegistro; // Fecha de creación del usuario [cite: 503]

    // Constructor vacío obligatorio para JPA [cite: 526, 626]
    public Usuario() {
    }

    // =======================================================
    // GETTERS Y SETTERS REFACTORIZADOS
    // =======================================================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    /*
     * Getter actualizado con el estándar de industria.
     */
    public String getPassword() { return password; }
    
    /*
     * Setter actualizado con el estándar de industria.
     */
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}