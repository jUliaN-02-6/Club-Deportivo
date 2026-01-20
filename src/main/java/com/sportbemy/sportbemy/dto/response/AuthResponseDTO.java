package com.sportbemy.sportbemy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // Nos ayuda a construir el objeto más fácil
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {

    private String token;       // La "pulsera" de acceso (JWT)
    private String mensaje;     // "Login exitoso"
    private String rol;         // Para saber si es JUGADOR o ADMIN
    private String email;       // Para mostrar en el perfil
}