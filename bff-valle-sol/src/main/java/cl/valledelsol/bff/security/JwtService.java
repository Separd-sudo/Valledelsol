package cl.valledelsol.bff.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    @Value("${app.jwt.secret}")
    private String jwtSecretBase64;

    private SecretKey getSigningKey() {
        byte[] keyBytes = java.util.Base64.getDecoder().decode(jwtSecretBase64);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims validarYExtraerClaims(String token) throws JwtException {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extraerRol(Claims claims) {
        return claims.get("rol", String.class);
    }

    public String extraerCorreo(Claims claims) {
        return claims.getSubject();
    }

    public Long extraerIdUsuario(Claims claims) {
        Number idUsuario = claims.get("idUsuario", Number.class);
        return idUsuario != null ? idUsuario.longValue() : null;
    }
}