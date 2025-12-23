package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.Lesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LesionRepository extends JpaRepository<Lesion, Long> {
}