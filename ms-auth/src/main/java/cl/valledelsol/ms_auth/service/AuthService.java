package cl.valledelsol.ms_auth.service;

import cl.valledelsol.ms_auth.dto.LoginRequestDTO;
import cl.valledelsol.ms_auth.dto.TokenResponseDTO;
import cl.valledelsol.ms_auth.model.UsuarioAuth;
import cl.valledelsol.ms_auth.repository.UsuarioAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService {

    @Autowired
    private UsuarioAuthRepository usuarioAuthRepository;
    // Verifica el password recibido en el login contra el hash BCrypt
    // guardado por ms-usuarios (ambos comparten la misma tabla "usuarios").
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        
        switch (rolUsuario) {
            case "CIUDADANO":
                tokenSimulado = "JWT_SECRET_CIUDADANO_VALLE_" + usuario.getId();
                break;
                
            case "BRIGADISTA":
                tokenSimulado = "JWT_SECRET_BRIGADISTA_TERRENO_" + usuario.getId();
                break;
                
            case "FUNCIONARIO": // 🔑 ALINEADO: Coincide exactamente con tu registro SQL
                tokenSimulado = "JWT_SECRET_ROOT_FUNCIONARIO_MUNICIPAL_" + usuario.getId();
                break;
                
            default:
                throw new RuntimeException("Error del Sistema: El rol '" + rolUsuario + "' no corresponde a las políticas.");
        }
        
        // 5. Construimos el TokenResponseDTO con todos los metadatos exigidos por el Front
        TokenResponseDTO response = new TokenResponseDTO();
        response.setTokenJwt(tokenSimulado);
        response.setRol(rolUsuario);
        
        // Salvavidas por si el nombre viene null en la tabla
        response.setNombre(usuario.getNombre() != null ? usuario.getNombre() : "Usuario Valle del Sol");
        response.setTokenType("Bearer");
        response.setExpiresIn(3600L);
        
        return response;
    }
}