package com.sportbemy.sportbemy.service;

import com.sportbemy.sportbemy.dto.request.LoginDTO;
import com.sportbemy.sportbemy.dto.request.RegistroJugadorDTO;
import com.sportbemy.sportbemy.dto.response.AuthResponseDTO;
import com.sportbemy.sportbemy.dto.response.UsuarioResponseDTO;

public interface IAuthService {

    UsuarioResponseDTO registrarJugador(RegistroJugadorDTO datosRegistro);

    // EL NUEVO: Recibe LoginDTO y devuelve AuthResponseDTO
    AuthResponseDTO login(LoginDTO dto);
}