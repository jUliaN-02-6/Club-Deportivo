package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.CuerpoTecnicoAsignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuerpoTecnicoAsignacionRepository extends JpaRepository<CuerpoTecnicoAsignacion, Long> {
}