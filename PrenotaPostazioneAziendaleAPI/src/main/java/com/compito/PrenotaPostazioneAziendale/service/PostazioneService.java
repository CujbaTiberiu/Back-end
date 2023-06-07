package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.TipoPostazione;
import com.compito.PrenotaPostazioneAziendale.repository.PostazioneDAORepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PostazioneService {

	@Autowired PostazioneDAORepository db;
	

	public Postazione insertPostazione(Postazione p) {
		if(db.existsById(p.getId())) {
			throw new EntityExistsException("Postazione already exists!");
		}
		db.save(p);
		return p;
	}
		
	public Postazione updatePostazione(Postazione p, Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Postazione doesn't exist!");
		}
		db.save(p);
		return p;
	}
		
	public String deletePostazione(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Postazione doesn't exist!");
		}
		db.deleteById(id);
		return "Postazione deleted!";
	}
		
	public Postazione getByID(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Postazione doesn't exist!");
		}
		return db.findById(id).get();
	}
		
	public List<Postazione> getAll() {
		return db.findAll();
	}
	
	public List<Postazione> findByCittaAndTipo(String citta, TipoPostazione tipo){
		if(!db.existsByCitta(citta) && !db.existsByTipo(tipo)) {
			throw new EntityNotFoundException("Postazione with citta and tipo selected doesn't exist!");
		}
		return db.findByCittaAndTipo(citta, tipo);
	}
	
}
