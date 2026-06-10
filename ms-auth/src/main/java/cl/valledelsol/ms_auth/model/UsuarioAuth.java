package cl.valledelsol.ms_auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 * Clase de Arquitectura de Datos (Clase de Persistencia).
 * Representa la tabla "usuarios_auth" dentro de la base de datos "auth_db".
 * Al usar @Entity, Spring Boot lee esta estructura y genera la tabla en PostgreSQL de forma automática.
 */
@Entity
@Table(name = "usuarios_auth")
public class UsuarioAuth {

    // =========================================================================
    // ATRIBUTOS (Campos de la Tabla)
    // =========================================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Guardamos el correo municipal único para evitar duplicados en el login
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    // IMPORTANTE: La contraseña en producción se guarda encriptada (BCrypt), no en texto plano
    @Column(nullable = false, length = 255)
    private String password;

    // Guardamos el rol para la autorización perimetral (ej. "OPERADOR", "ADMINISTRADOR")
    @Column(nullable = false, length = 30)
    private String rol;

    // =========================================================================
    // CONSTRUCTORES (Buenas Prácticas de Encapsulamiento)
    // =========================================================================

    /**
     * Constructor Vacío obligatorio por la especificación de JPA / Hibernate.
     * Si no se incluye, Spring Boot lanzará una excepción al intentar mapear las filas de la BD.
     */
    public UsuarioAuth() {
    }

    /**
     * Constructor Completo para inicializar instancias de forma explícita en tus servicios.
     */
    public UsuarioAuth(Long id, String email, String password, String rol) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // =========================================================================
    // GETTERS Y SETTERS EXPLÍCITOS (Control de Acceso Puro)
    // =========================================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}