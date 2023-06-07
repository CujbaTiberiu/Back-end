package com.compito.PrenotaPostazioneAziendale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Utente;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long>{
	
	public Utente findByUserName(String username);
	
	public boolean existsByEmail(String email);
}
