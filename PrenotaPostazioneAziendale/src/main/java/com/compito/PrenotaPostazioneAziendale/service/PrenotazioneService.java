package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.repository.PrenotazioneDAORepository;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneDAORepository db;
	
	@Autowired @Qualifier("newPostazione") ObjectProvider<Prenotazione> newPrenotazioneProvider;
	
	public Prenotazione createNewPrenotazione() {
		return newPrenotazioneProvider.getObject();
	}
	
	public void insertPostazione(Prenotazione p) {
		db.save(p);
		System.out.println("Prenotazione per il giorno " + p.getGiornoPrenotazione() + " inserito nel DB!!!");
	}
		
	public void updatePostazione(Prenotazione p) {
		db.save(p);
		System.out.println("Prenotazione per il giorno " + p.getGiornoPrenotazione() + " modificato nel DB!!!");
	}
		
	public void deletePostazione(Prenotazione p) {
		db.delete(p);
		System.out.println("Prenotazione per il giorno " + p.getGiornoPrenotazione() + " eliminato nel DB!!!");
	}
		
	public Prenotazione getByID(long id) {
		return db.findById(id).get();
	}
		
	public List<Prenotazione> getAll() {
		return db.findAll();
	}
	
}
