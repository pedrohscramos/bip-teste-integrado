package com.example.backendmodule.repository;

import com.example.backendmodule.entity.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
}
