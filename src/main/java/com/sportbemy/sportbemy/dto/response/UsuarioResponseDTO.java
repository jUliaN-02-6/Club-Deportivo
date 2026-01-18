package com.sportbemy.sportbemy.dto.response;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String rol; // Devolveremos el nombre del rol (ej: "JUGADOR")
}