package cl.valledelsol.ms_auth.dto;

/**
 * DTO que envuelve el token JWT generado tras una autenticación exitosa.
 */
public class TokenResponseDTO {

    private String accessToken;
    private String tokenType;
    private Long expiresIn;

    // =========================================================
    // CONSTRUCTORES
    // =========================================================

    public TokenResponseDTO() {
    }

    public TokenResponseDTO(String accessToken, String tokenType, Long expiresIn) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
    }

    // =========================================================
    // GETTERS Y SETTERS
    // =========================================================

    // Obtiene el token de acceso string
    public String getAccessToken() {
        return accessToken;
    }

    // Asigna el token generado por el servidor de seguridad
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // Obtiene el tipo de token (Generalmente "Bearer")
    public String getTokenType() {
        return tokenType;
    }

    // Asigna el tipo de token
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    // Obtiene el tiempo de expiración en segundos
    public Long getExpiresIn() {
        return expiresIn;
    }

    // Asigna el tiempo de vida del token
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}