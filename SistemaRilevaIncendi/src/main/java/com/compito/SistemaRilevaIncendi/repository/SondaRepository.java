package com.compito.SistemaRilevaIncendi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.SistemaRilevaIncendi.models.Sonda;

@Repository
public interface SondaRepository extends JpaRepository<Sonda, Long>{

}
