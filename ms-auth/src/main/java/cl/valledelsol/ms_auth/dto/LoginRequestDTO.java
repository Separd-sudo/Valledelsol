package cl.valledelsol.ms_auth.dto;

/**
 * DTO para capturar las credenciales de inicio de sesión.
 * Implementado en Java puro para asegurar el encapsulamiento.
 */
public class LoginRequestDTO {
    
    private String correo; // 🔑 CORREGIDO: De email a correo
    private String password;

    // Constructor vacío obligatorio para Jackson
    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}