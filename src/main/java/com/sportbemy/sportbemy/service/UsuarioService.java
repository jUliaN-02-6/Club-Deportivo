package com.sportbemy.sportbemy.service;

import com.sportbemy.sportbemy.entity.Usuario;

public interface UsuarioService {

    // Aquí solo declaramos QUÉ vamos a hacer.
    // Estructura:  TipoDeDatoQueDevuelve  nombreDelMetodo (DatosQueRecibe);

    Usuario guardarUsuario(Usuario usuario);

    // Aquí pondremos los otros métodos después (listar, borrar, etc.)
}
