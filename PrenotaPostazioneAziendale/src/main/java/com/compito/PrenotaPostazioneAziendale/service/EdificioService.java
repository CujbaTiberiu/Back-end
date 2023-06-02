package com.compito.PrenotaPostazioneAziendale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.repository.EdificioDAORepository;

@Service
public class EdificioService {

	@Autowired EdificioDAORepository db;
	
	@Autowired @Qualifier("newEdificio") ObjectProvider<Edificio> newEdificioProvider;
	
	public Edificio createFakeUtente() {
		return newEdificioProvider.getObject();
	}
	
	public void insertUtente(Edificio e) {
		db.save(e);
		System.out.println("Edificio " + e.getNome() + " inserito nel DB!!!");
	}
	
	public void updateUtente(Edificio e) {
		db.save(e);
		System.out.println("Edificio " + e.getNome() + " modificato nel DB!!!");
	}
	
	public void deleteUtente(Edificio e) {
		db.delete(e);
		System.out.println("Edificio " + e.getNome() + " eliminato nel DB!!!");
	}
	
	public Edificio getByID(long id) {
		return db.findById(id).get();
	}
	
	public List<Edificio> getAll() {
		return db.findAll();
	}
}
