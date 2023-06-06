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

@Service
public class PostazioneService {

	@Autowired PostazioneDAORepository db;
	
	@Autowired @Qualifier("newPostazione") ObjectProvider<Postazione> newPostazioneProvider;
	@Autowired @Qualifier("setNewPostazione") ObjectProvider<Postazione> setNewPostazioneProvider;
	
	public Postazione createNewPostazione(String descrizione, int numeroMaxOccupanti, TipoPostazione tipo, Edificio edificio) {
		return newPostazioneProvider.getObject();
	}
	
	public Postazione createSetNewPostazione() {
		return setNewPostazioneProvider.getObject();
	}

	public void insertPostazione(Postazione p) {
		db.save(p);
		System.out.println("Postazione " + p.getDescrizione() + " inserito nel DB!!!");
	}
		
	public void updatePostazione(Postazione p) {
		db.save(p);
		System.out.println("Postazione " + p.getDescrizione() + " modificato nel DB!!!");
	}
		
	public void deletePostazione(Postazione p) {
		db.delete(p);
		System.out.println("Postazione " + p.getDescrizione() + " eliminato nel DB!!!");
	}
		
	public Postazione getByID(long id) {
		return db.findById(id).get();
	}
		
	public List<Postazione> getAll() {
		return db.findAll();
	}
	
	public List<Postazione> findByCittaAndTipo(String citta, TipoPostazione tipo){
		return db.findByCittaAndTipo(citta, tipo);
		
	}
	
}
