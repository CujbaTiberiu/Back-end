package com.compito.PrenotaPostazioneAziendale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;

@Repository
public interface EdificioDAORepository extends JpaRepository<Edificio, Long>{

}
