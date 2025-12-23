package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.EstadisticasPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasPartidoRepository extends JpaRepository<EstadisticasPartido, Long> {
}