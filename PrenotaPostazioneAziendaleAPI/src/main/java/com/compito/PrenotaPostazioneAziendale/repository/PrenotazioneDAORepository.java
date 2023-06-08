package com.compito.PrenotaPostazioneAziendale.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;

@Repository
public interface PrenotazioneDAORepository extends JpaRepository<Prenotazione, Long>{

	//Page<Prenotazione> findByUserAndDataPrenotata(Utente user, LocalDate dataPrenotazione, Pageable pageable);

	//Page<Prenotazione> findByUser(Utente user, Pageable pageable);

}
