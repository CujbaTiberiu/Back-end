package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.repository.UtenteDAORepository;
import com.compito.PrenotaPostazioneAziendale.repository.UtentePageableRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {

	@Autowired UtenteDAORepository db;
	@Autowired UtentePageableRepository dbPageable;
	
	
	public Page<Utente> getAllPageable(Pageable pageable){
		return dbPageable.findAll(pageable);
	}
	
	public Utente insertUtente(Utente u) {
		if(db.existsByEmail(u.getEmail())) {
			throw new EntityExistsException("User with mail " + u.getEmail() + " already exists!");
		} else {
			db.save(u);
		}
		return u;
	}
	
	public Utente updateUtente(Utente u) {
		if(!db.existsById(u.getId())) {
			throw new EntityNotFoundException("User doesn't exist!");
		}
		db.save(u);
		return u;
	}
	
	public String deleteUtente(Long id) {
		if(!db.existsById(id)) {
			throw new EntityExistsException("User doesn't exist!");
		}
		db.deleteById(id);
		return "User deleted!";
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
			throw new EntityExistsException("User doesn't exist!");
		}
		return db.findByUserName(username);
	}
	
}
