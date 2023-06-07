package com.compito.PrenotaPostazioneAziendale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public class MainController { 
	
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
	public ResponseEntity<List<Utente>> getUserAll() {
		return ResponseEntity.ok(utenteService.getAll());
	}
	
	@GetMapping("/utenti/page")
	public ResponseEntity<Page<Utente>> getUserAllPageable(Pageable pageable) {
		return ResponseEntity.ok(utenteService.getAllPageable(pageable));
	}
	
	@GetMapping("/utenti/{id}")
	public ResponseEntity<?> getUserByID(@PathVariable long id) {
		return ResponseEntity.ok(utenteService.getByID(id));
	}
	
	
	@PostMapping("/utenti")
	public ResponseEntity<Utente> createProduct(@RequestBody Utente u) {
		return ResponseEntity.ok(utenteService.insertUtente(u));
	}
	
	@PutMapping("/utenti/{id}")
	public ResponseEntity<Utente> updateProduct(@RequestBody Utente u, @PathVariable Long id) {
		return ResponseEntity.ok(utenteService.updateUtente(u));
	}
	
	@DeleteMapping("/utenti/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		return ResponseEntity.ok(utenteService.deleteUtente(id));
		
	}

}
