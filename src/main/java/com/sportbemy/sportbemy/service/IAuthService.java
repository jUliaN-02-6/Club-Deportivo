package com.sportbemy.sportbemy.service;

import com.sportbemy.sportbemy.dto.request.RegistroJugadorDTO;
import com.sportbemy.sportbemy.dto.response.UsuarioResponseDTO;

public interface IAuthService {
    UsuarioResponseDTO registrarJugador(RegistroJugadorDTO datosRegistro);
}