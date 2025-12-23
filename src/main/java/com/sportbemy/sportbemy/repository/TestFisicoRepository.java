package com.sportbemy.sportbemy.repository;

import com.sportbemy.sportbemy.entity.TestFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestFisicoRepository extends JpaRepository<TestFisico, Long> {
}