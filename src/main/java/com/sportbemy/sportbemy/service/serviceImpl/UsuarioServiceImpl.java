package com.sportbemy.sportbemy.service.serviceImpl;

import com.sportbemy.sportbemy.entity.Usuario;
import com.sportbemy.sportbemy.repository.UsuarioRepository;
import com.sportbemy.sportbemy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
