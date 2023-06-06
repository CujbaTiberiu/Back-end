package com.compito.PrenotaPostazioneAziendale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.service.UtenteService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api") 
public class InfoPage { 
	
	@Autowired UtenteService utenteService;
	
	@GetMapping("/info/{lang}")
	public @ResponseBody String getInfo(@PathVariable String lang) {
		if(lang.equals("italiano")) {
			return "Regole prenotazione: ecc...";
		} else if(lang.equals("english")) {
			return "Booking rules: etc...";
		}else throw new EntityNotFoundException("Language not supported! Write 'english' or 'italiano'!");
	}
	
	@GetMapping("/utenti")
	public List<Utente> getUserAll() {
		List<Utente> utente = utenteService.getAll();
		return utente;
	}
	
	@GetMapping("/utenti/{id}")
	public ResponseEntity<?> getUserByID(@PathVariable long id) {
		try {
			return new ResponseEntity<Utente>(utenteService.getByID(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return  new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/utenti")
	public Utente createProduct(@RequestBody Utente u) {
		Utente utente = utenteService.insertUtente(u);
		return utente;
	}
	
	@PutMapping("/utenti/{id}")
	public Utente updateProduct(@RequestBody Utente u, @PathVariable Long id) {
		Utente utente = utenteService.updateUtente(u);
		return utente;
	}
	
	@DeleteMapping("/utenti/{id}")
	public String deleteProduct(@PathVariable Long id) {
		utenteService.deleteUtente(id);
		return "User deleted!";
	}

}
