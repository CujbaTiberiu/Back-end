package com.compito.SistemaRilevaIncendi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.SistemaRilevaIncendi.models.CentroDiControllo;

@Repository
public interface CentroDiControlloRepository extends JpaRepository<CentroDiControllo, Long>{

}
