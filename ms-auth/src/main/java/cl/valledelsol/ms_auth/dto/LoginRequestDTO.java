package cl.valledelsol.ms_auth.dto;

/**
 * DTO para capturar las credenciales de inicio de sesión.
 * Implementado en Java puro para asegurar el encapsulamiento.
 */
public class LoginRequestDTO {
    
    // Atributos privados para restringir el acceso directo desde el exterior
    private String email;
    private String password;

    // =========================================================
    // CONSTRUCTORES
    // =========================================================

    // Constructor vacío obligatorio que utiliza Spring (Jackson) para deserializar el JSON
    public LoginRequestDTO() {
    }

    // Constructor con parámetros (Útil para pruebas unitarias con Mockito)
    public LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // =========================================================
    // GETTERS Y SETTERS (Métodos de Acceso)
    // =========================================================

    // Obtiene el email del usuario
    public String getEmail() {
        return email;
    }

    // Define o modifica el email del usuario
    public void setEmail(String email) {
        this.email = email;
    }

    // Obtiene la contraseña plana
    public String getPassword() {
        return password;
    }

    // Define o modifica la contraseña
    public void setPassword(String password) {
        this.password = password;
    }
}