package com.sportbemy.sportbemy.service;

import com.sportbemy.sportbemy.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    // Aquí solo declaramos QUÉ vamos a hacer.
    // Estructura:  TipoDeDatoQueDevuelve  nombreDelMetodo (DatosQueRecibe);

    Usuario guardarUsuario(Usuario usuario);

    // Aquí pondremos los otros métodos después (listar, borrar, etc.)

    Optional<Usuario> buscarUsuarioPorId(Long id);

    List<Usuario> listarTodos();

    void desactivarUsuario(Long id);
}
