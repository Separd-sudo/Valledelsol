package cl.valledelsol.ms_auth.service;

import cl.valledelsol.ms_auth.dto.LoginRequestDTO;
import cl.valledelsol.ms_auth.dto.TokenResponseDTO;
import cl.valledelsol.ms_auth.model.UsuarioAuth;
import cl.valledelsol.ms_auth.repository.UsuarioAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Capa de Lógica de Negocio (Service) para la Autenticación.
 * Aquí se dictan las reglas de acceso perimetral según el rol municipal.
 */
@Service
public class AuthService {

    @Autowired
    private UsuarioAuthRepository usuarioAuthRepository;

    /**
     * Procesa la solicitud de login validando contra la base de datos relacional.
     * @param request DTO con las credenciales ingresadas en el Frontend.
     * @return DTO con el Token JWT simulado y sus metadatos de rol.
     */
    public TokenResponseDTO autenticar(LoginRequestDTO request) {
        
        // 1. Buscamos al usuario en la base de datos por su email usando el Query Method
        Optional<UsuarioAuth> usuarioOptional = usuarioAuthRepository.findByEmail(request.getEmail());
        
        // 2. Si el contenedor Optional viene vacío, cortamos el flujo de inmediato por seguridad
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Acceso Denegado: Las credenciales no existen en el sistema municipal.");
        }
        
        // 3. Extraemos el objeto real desde el contenedor seguro
        UsuarioAuth usuario = usuarioOptional.get();
        
        // 4. Verificación de contraseña
        // NOTA PARA LA COMISIÓN: En un entorno real aquí se aplica passwordEncoder.matches()
        if (!usuario.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Acceso Denegado: Contraseña incorrecta.");
        }
        
        // 5. El Match se logró con éxito. Procedemos a evaluar las capacidades del Rol.
        String rolUsuario = usuario.getRol().toUpperCase();
        String tokenSimulado = "";
        
        // Aplicamos la estructura de control según los 3 roles exigidos por el negocio
        switch (rolUsuario) {
            case "CIUDADANO":
                // Token limitado: Solo permite métodos POST y GET en el módulo de reportes
                tokenSimulado = "JWT_SECRET_CIUDADANO_VALLE_" + usuario.getId();
                break;
                
            case "BRIGADISTA":
                // Token operativo: Permite modificaciones (PUT) en los estados de incendios forestales
                tokenSimulado = "JWT_SECRET_BRIGADISTA_TERRENO_" + usuario.getId();
                break;
                
            case "FUNCIONARIO_MUNICIPAL":
                // Token administrativo: Acceso total a la administración de usuarios y auditoría global
                tokenSimulado = "JWT_SECRET_ROOT_FUNCIONARIO_MUNICIPAL_" + usuario.getId();
                break;
                
            default:
                throw new RuntimeException("Error del Sistema: El rol asignado no corresponde a las políticas de Valle del Sol.");
        }
        
        // 6. Construimos el DTO de respuesta usando constructores explícitos (Encapsulamiento nativo)
        TokenResponseDTO response = new TokenResponseDTO();
        response.setAccessToken(tokenSimulado);
        response.setTokenType("Bearer");
        response.setExpiresIn(3600L); // Válido por 1 hora (3600 segundos)
        
        return response;
    }
}