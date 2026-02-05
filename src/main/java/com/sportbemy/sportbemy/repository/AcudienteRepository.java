package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.Acudiente;
import com.sportbemy.sportbemy.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcudienteRepository extends JpaRepository<Acudiente, Long> {

    // 1. Buscar quiénes son los acudientes de un niño (puede tener Papá y Mamá)
    List<Acudiente> findByMenor(Usuario menor);

    // 2. Buscar todos los hijos que tiene un acudiente a cargo
    List<Acudiente> findByResponsable(Usuario responsable);

    // 3. Verificar si una relación ya existe (para evitar duplicados)
    boolean existsByMenorAndResponsable(Usuario menor, Usuario responsable);
}