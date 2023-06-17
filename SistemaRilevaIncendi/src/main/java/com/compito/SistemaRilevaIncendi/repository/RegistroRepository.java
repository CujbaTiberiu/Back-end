package com.compito.SistemaRilevaIncendi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.SistemaRilevaIncendi.models.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

}
