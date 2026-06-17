package cl.valledelsol.ms_auth.dto;

/**
 * DTO que envuelve el token JWT generado tras una autenticación exitosa.
 */
public class TokenResponseDTO {

    private String tokenJwt; // 🔑 Sincronizado con res.data en tu page.js
    private String rol;      // 🔑 Agregado para desestructuración del Front
    private String nombre;   // 🔑 Agregado para desestructuración del Front
    private String tokenType;
    private Long expiresIn;

    public TokenResponseDTO() {
    }

    public TokenResponseDTO(String tokenJwt, String rol, String nombre, String tokenType, Long expiresIn) {
        this.tokenJwt = tokenJwt;
        this.rol = rol;
        this.nombre = nombre;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
    }

    public String getTokenJwt() {
        return tokenJwt;
    }

    public void setTokenJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}