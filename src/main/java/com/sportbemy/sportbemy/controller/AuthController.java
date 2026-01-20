package com.sportbemy.sportbemy.controller;

import com.sportbemy.sportbemy.dto.request.RegistroJugadorDTO;
import com.sportbemy.sportbemy.dto.response.UsuarioResponseDTO;
import com.sportbemy.sportbemy.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    // Inyectamos el servicio (Tu servicio que tiene toda la logica)
    private final IAuthService authService;

    // Endpoint: POST http://localhost:8080/auth/registro-jugador
    @PostMapping("/registro-jugador")
     //    (1) LO QUE SALE                      (2) NOMBRE      (3) FILTRO          (4) LO QUE ENTRA
    public ResponseEntity<UsuarioResponseDTO> registrarJugador(@Valid @RequestBody RegistroJugadorDTO dto) {

        // PASO 1: Recibir el JSON y convertirlo a objeto Java (dto)
        // La anotación @Valid revisa que no vengan campos vacíos según pusiste en el DTO

        // PASO 2: Llamar al Servicio para que procese todo (Logica, BD, Encriptar)
        UsuarioResponseDTO nuevoUsuario = authService.registrarJugador(dto);

        // PASO 3: Responder al cliente
        // Devolvemos el objeto 'nuevoUsuario' y un código HTTP 201 (CREATED)
        // que significa "¡Éxito! Se creó algo nuevo".
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);

    }
}
