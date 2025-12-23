package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {
}