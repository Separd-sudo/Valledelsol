package cl.valledelsol.ms_auth.service;

import cl.valledelsol.ms_auth.dto.LoginRequestDTO;
import cl.valledelsol.ms_auth.dto.TokenResponseDTO;
import cl.valledelsol.ms_auth.model.UsuarioAuth;
import cl.valledelsol.ms_auth.repository.UsuarioAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import cl.valledelsol.ms_auth.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService {

    @Autowired
    private UsuarioAuthRepository usuarioAuthRepository;
    // Verifica el password recibido en el login contra el hash BCrypt
    // guardado por ms-usuarios (ambos comparten la misma tabla "usuarios").
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public TokenResponseDTO autenticar(LoginRequestDTO request) {
        
        // 1. Buscamos al usuario en la base de datos por su correo (Query Method Corregido)
        Optional<UsuarioAuth> usuarioOptional = usuarioAuthRepository.findByCorreo(request.getCorreo());
        
        // 2. Control de seguridad perimetral
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Acceso Denegado: Las credenciales no existen en el sistema municipal.");
        }
        
        UsuarioAuth usuario = usuarioOptional.get();
        
        // 3. Verificación de contraseña plana para desarrollo local
        // matches() aplica el mismo algoritmo BCrypt al password recibido y
        // compara el resultado contra el hash guardado, SIN necesitar
        // desencriptar nada (BCrypt no es reversible por diseño).
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Acceso Denegado: Contraseña incorrecta.");
        }
        
        // 4. Evaluación de las capacidades del Rol
        String rolUsuario = usuario.getRol().toUpperCase();
        String tokenSimulado = "";
        
         if (!rolUsuario.equals("CIUDADANO") && !rolUsuario.equals("BRIGADISTA")
                 && !rolUsuario.equals("FUNCIONARIO") && !rolUsuario.equals("FUNCIONARIO_MUNICIPAL")) {
             throw new RuntimeException("Error del Sistema: El rol '" + rolUsuario + "' no corresponde a las políticas.");
         }   
        String token = jwtService.generarToken(usuario.getId(), usuario.getCorreo(), rolUsuario, usuario.getNombre());

        
        // 5. Construimos el TokenResponseDTO con todos los metadatos exigidos por el Front
        TokenResponseDTO response = new TokenResponseDTO();
        response.setTokenJwt(token);
        response.setRol(rolUsuario);
        
        // Salvavidas por si el nombre viene null en la tabla
        response.setNombre(usuario.getNombre() != null ? usuario.getNombre() : "Usuario Valle del Sol");
        response.setTokenType("Bearer");
        response.setExpiresIn(jwtService.getExpirationMs() / 1000);
        
        return response;
    }
}