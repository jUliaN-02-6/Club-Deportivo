package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.Convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Long> {
}