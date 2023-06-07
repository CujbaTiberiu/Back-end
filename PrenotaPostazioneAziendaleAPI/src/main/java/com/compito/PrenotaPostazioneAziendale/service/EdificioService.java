package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.repository.EdificioDAORepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EdificioService {

	@Autowired EdificioDAORepository db;

	
	public Edificio insertEdificio(Edificio e) {
		if(db.existsByIndirizzo(e.getIndirizzo())) {
			throw new EntityExistsException("Edificio with this address already exists!");
		}
		db.save(e);
		return e;
	}
	
	public Edificio updateEdificio(Edificio e , Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Edificio doesn't exist!");
		}
		db.save(e);
		return e;
	}
	
	public String deleteEdificio(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Edificio doesn't exist!");
		}
		db.deleteById(id);
		return "Edificio deleted!";
	}
	
	public Edificio getByID(long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Edificio doesn't exist!");
		}
		return db.findById(id).get();
	}
	
	public List<Edificio> getAll() {
		return db.findAll();
	}
}
