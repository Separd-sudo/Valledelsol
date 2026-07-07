package cl.valledelsol.bff.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public static final String ATTR_ROL = "rolUsuario";
    public static final String ATTR_CORREO = "correoUsuario";
    public static final String ATTR_ID_USUARIO = "idUsuario";

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        String method = request.getMethod();

        if (method.equals("OPTIONS")) {
            return true;
        }

        boolean esLogin = path.equals("/api/v1/bff/auth/login") && method.equals("POST");
        boolean esRegistroUsuario = path.equals("/api/v1/bff/usuarios") && method.equals("POST");

        return esLogin || esRegistroUsuario;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            responderNoAutorizado(response, "Falta el header Authorization con el formato 'Bearer <token>'.");
            return;
        }

        String token = header.substring(7);

        try {
            Claims claims = jwtService.validarYExtraerClaims(token);

            request.setAttribute(ATTR_ROL, jwtService.extraerRol(claims));
            request.setAttribute(ATTR_CORREO, jwtService.extraerCorreo(claims));
            request.setAttribute(ATTR_ID_USUARIO, jwtService.extraerIdUsuario(claims));

            filterChain.doFilter(request, response);

        } catch (JwtException e) {
            responderNoAutorizado(response, "Token invalido o expirado: " + e.getMessage());
        }
    }

    private void responderNoAutorizado(HttpServletResponse response, String mensaje) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(Map.of("error", mensaje)));
    }
}