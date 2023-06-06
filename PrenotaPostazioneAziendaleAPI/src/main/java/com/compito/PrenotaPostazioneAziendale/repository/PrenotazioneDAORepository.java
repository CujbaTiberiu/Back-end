package com.compito.PrenotaPostazioneAziendale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;

@Repository
public interface PrenotazioneDAORepository extends JpaRepository<Prenotazione, Long>{

}
