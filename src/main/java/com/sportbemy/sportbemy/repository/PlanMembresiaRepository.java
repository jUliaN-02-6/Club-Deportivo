package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.PlanMembresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMembresiaRepository extends JpaRepository<PlanMembresia, Long> {
}