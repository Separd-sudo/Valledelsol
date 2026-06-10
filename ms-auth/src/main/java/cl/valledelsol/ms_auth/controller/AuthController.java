package cl.valledelsol.ms_auth.controller;

import cl.valledelsol.ms_auth.dto.LoginRequestDTO;
import cl.valledelsol.ms_auth.dto.TokenResponseDTO;
import cl.valledelsol.ms_auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// Mapeo versionado oficial que coincide con la ruta configurada en Kong
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService; // Conexión a la lógica de negocio de seguridad

    // Endpoint encargado de recibir el formulario de inicio de sesión
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        
        // Ejecutamos la validación de credenciales en el servicio
        TokenResponseDTO tokenResponse = authService.autenticar(loginRequest);
        
        // Si el token se generó con éxito, respondemos un 200 OK con el JWT
        return ResponseEntity.ok(tokenResponse);
    }
}