package com.compito.PrenotaPostazioneAziendale.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.exception.PrenotazioneException;
import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.repository.PrenotazioneDAORepository;
import com.compito.PrenotaPostazioneAziendale.repository.UtenteDAORepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDAORepository db;
	@Autowired UtenteDAORepository dbUtente;
	
	
	public Prenotazione insertPrenotazione(Utente utente, Postazione postazione) {
		if(postazione.getPrenotato() == true) {
			throw new PrenotazioneException("Postazione already booked!");
		}
		if(!dbUtente.existsById(utente.getId())) {
			throw new EntityNotFoundException("User doesn't exists!");
		}
		Prenotazione p = new Prenotazione( postazione, utente);
		db.save(p);
		return p;
	}
		
	public Prenotazione updatePrenotazione(Prenotazione p, Long id) throws Exception {
		Optional<Prenotazione> prenotazioneResult = db.findById(id);

		if (prenotazioneResult.isPresent()) {
			Prenotazione prenotazioneUpdate = prenotazioneResult.get();
			prenotazioneUpdate.setInizioPrenotazione(p.getInizioPrenotazione());
			prenotazioneUpdate.setPostazione(p.getPostazione());
			prenotazioneUpdate.setUtente(p.getUtente());
			db.save(prenotazioneUpdate);
			return prenotazioneUpdate;
		} else {
			throw new PrenotazioneException("Elemento non aggiornato");
		}
	}
		
	public String deletePrenotazione(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Prenotazione doesn't exist!");
		}
		db.deleteById(id);
		return "Prenotazione deleted with success!";
	}
		
	public Prenotazione getByID(long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Prenotazione doesn't exist!");
		}
		return db.findById(id).get();
	}
		
	public List<Prenotazione> getAll() {
		return db.findAll();
	}
	
}
