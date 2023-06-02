package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.repository.UtenteDAORepository;

@Service
public class UtenteService {

	@Autowired UtenteDAORepository db;
	
	@Autowired @Qualifier("fakeUtente") ObjectProvider<Utente> fakeUtenteProvider;
	
	public Utente createFakeUtente() {
		return fakeUtenteProvider.getObject();
	}
	
	public void insertUtente(Utente u) {
		db.save(u);
		System.out.println("Utente " + u.getNomeCompleto() + " inserito nel DB!!!");
	}
	
	public void updateUtente(Utente u) {
		db.save(u);
		System.out.println("Utente " + u.getNomeCompleto() + " modificato nel DB!!!");
	}
	
	public void deleteUtente(Utente u) {
		db.delete(u);
		System.out.println("Utente " + u.getNomeCompleto() + " eliminato nel DB!!!");
	}
	
	public Utente getByID(long id) {
		return db.findById(id).get();
	}
	
	public List<Utente> getAll() {
		return db.findAll();
	}
	
	public List<Utente> findByUserName(String username){
		return db.findByUserName(username);
	}
	
}
