package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // SELECT * FROM usuarios WHERE email = ?
    Optional<Usuario> findByEmail(String email);

    // SELECT * FROM usuarios WHERE numero_documento = ?
    Optional<Usuario> findByNumeroDocumento(String numeroDocumento);
}
