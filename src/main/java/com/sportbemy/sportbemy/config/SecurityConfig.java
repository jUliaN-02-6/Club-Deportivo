package com.sportbemy.sportbemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. ESTE ES EL BEAN QUE NECESITAS PARA EL SERVICIO
    // Esto habilita la inyección de 'PasswordEncoder' en tu AuthService
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. CONFIGURACIÓN BÁSICA DE SEGURIDAD
    // Por ahora, dejamos pasar todo (permitAll) para probar el registro sin bloqueos.
    // Más adelante cerraremos las puertas.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para pruebas en Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // ¡OJO! Permitimos todo temporalmente
                );

        return http.build();
    }
}