package cl.valledelsol.ms_usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuracion de Spring Security para ms-usuarios.
 *
 * IMPORTANTE para quien mantenga este servicio despues:
 * Spring Security se agrego UNICAMENTE para poder usar BCryptPasswordEncoder
 * (hashear el password antes de guardarlo en la BD). NO se esta usando para
 * proteger los endpoints con login/sesion: por defecto, Spring Security
 * bloquea TODOS los endpoints con una pantalla de login si no se configura
 * nada, y eso rompería la API REST que consume el BFF.
 *
 * Por eso el SecurityFilterChain de abajo hace lo contrario: desactiva el
 * login automatico y permite todas las peticiones sin autenticacion a nivel
 * de este microservicio. La proteccion real (JWT + rol) vive en el BFF
 * (ver bff-valle-sol/security/JwtAuthFilter.java), no aqui. Este servicio
 * confia en que si le llega una peticion, ya paso el filtro del BFF.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Expone el encoder de passwords como bean de Spring, para que
     * UsuarioService pueda inyectarlo y usar .encode() al registrar
     * un usuario nuevo.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Desactiva las protecciones por defecto de Spring Security que no
     * aplican aqui (CSRF es para formularios HTML con sesion; login/basic
     * auth no los usamos porque la autenticacion la maneja el BFF).
     * Sin este bean, Spring Security bloquearia todos los endpoints REST.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable);

        return http.build();
    }
}