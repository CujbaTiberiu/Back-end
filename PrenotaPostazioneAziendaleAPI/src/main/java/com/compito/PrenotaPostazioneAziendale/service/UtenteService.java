package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.repository.UtenteDAORepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {

	@Autowired UtenteDAORepository db;
	
	
	public Utente insertUtente(Utente u) {
		db.save(u);
		return u;
	}
	
	public Utente updateUtente(Utente u) {
		if(!db.existsById(u.getId())) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		db.save(u);
		return u;
	}
	
	public void deleteUtente(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		db.deleteById(id);
	}
	
	public Utente getByID(long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		return db.findById(id).get();
	}
	
	public List<Utente> getAll() {
		return db.findAll();
	}
	
	public Utente findByUserName(String username){
		if(db.findByUserName(username) == null) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		return db.findByUserName(username);
	}
	
}
