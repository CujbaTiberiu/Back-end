package com.compito.PrenotaPostazioneAziendale.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.repository.PrenotazioneDAORepository;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDAORepository db;
	
	@Autowired @Qualifier("newPrenotazione") ObjectProvider<Prenotazione> newPrenotazioneProvider;
	@Autowired @Qualifier("newSetPrenotazione") ObjectProvider<Prenotazione> newSetPrenotazioneProvider;
	
	public Prenotazione createNewPrenotazione(Postazione postazione, Utente utente) {
		return newPrenotazioneProvider.getObject();
	}
	public Prenotazione createSetNewPrenotazione() {
		return newSetPrenotazioneProvider.getObject();
	}
	
	public void insertPrenotazione(Prenotazione p) {
		db.save(p);
		System.out.println("Prenotazione per il giorno " + p.getInizioPrenotazione() + " inserito nel DB!!!");
	}
		
	public void updatePrenotazione(Prenotazione p) {
		db.save(p);
		System.out.println("Prenotazione per il giorno " + p.getInizioPrenotazione() + " modificato nel DB!!!");
	}
		
	public void deletePrenotazione(Prenotazione p) {
		db.delete(p);
		System.out.println("Prenotazione per il giorno " + p.getInizioPrenotazione() + " eliminato nel DB!!!");
	}
		
	public Prenotazione getByID(long id) {
		return db.findById(id).get();
	}
		
	public List<Prenotazione> getAll() {
		return db.findAll();
	}
	
}
