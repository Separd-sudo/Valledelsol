package cl.valledelsol.bff.dto;

/**
 * DTO (Data Transfer Object) para capturar los datos del formulario 
 * de registro que envía el Frontend en React.
 * Implementado en Java nativo sin dependencias de Lombok.
 */
public class UsuarioRequest {

    private String nombre;
    private String email;
    private String password;
    private String rol;

    // Constructor vacío obligatorio para la deserialización de Jackson (JSON a Objeto)
    public UsuarioRequest() {
    }

    // Constructor completo útil para instanciaciones manuales o pruebas unitarias
    public UsuarioRequest(String nombre, String email, String password, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // ==========================================
    // GETTERS Y SETTERS NATIVOS
    // ==========================================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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