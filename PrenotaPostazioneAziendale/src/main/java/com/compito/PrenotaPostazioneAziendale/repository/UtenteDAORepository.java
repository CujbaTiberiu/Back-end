package com.compito.PrenotaPostazioneAziendale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compito.PrenotaPostazioneAziendale.model.Utente;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long>{
	
	public List<Utente> findByUserName(String username);
}
