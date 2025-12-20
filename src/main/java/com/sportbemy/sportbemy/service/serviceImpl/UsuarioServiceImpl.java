package com.sportbemy.sportbemy.service.serviceImpl;

import com.sportbemy.sportbemy.entity.Usuario;
import com.sportbemy.sportbemy.repository.UsuarioRepository;
import com.sportbemy.sportbemy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void desactivarUsuario(Long id) {
        // 1. Buscamos al usuario. Si no existe, lanzamos un error (excepción)
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // 2. En lugar de borrarlo, le cambiamos el estado a FALSE
        usuarioEncontrado.setActivo(false);

        // 3. Guardamos el cambio (JPA detecta que ya existe y hace un UPDATE)
        usuarioRepository.save(usuarioEncontrado);
    }
}
