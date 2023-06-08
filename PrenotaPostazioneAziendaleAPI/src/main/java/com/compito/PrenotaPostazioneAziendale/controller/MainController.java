package com.compito.PrenotaPostazioneAziendale.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.service.EdificioService;
import com.compito.PrenotaPostazioneAziendale.service.PostazioneService;
import com.compito.PrenotaPostazioneAziendale.service.PrenotazioneService;
import com.compito.PrenotaPostazioneAziendale.service.UtenteService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api") 
public class MainController { 
	
	@Autowired UtenteService utenteService;
	@Autowired PostazioneService postazioneService;
	@Autowired EdificioService edificioService;
	@Autowired PrenotazioneService prenotazioneService;
	
	@GetMapping("/info/{lang}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public @ResponseBody String getInfo(@PathVariable String lang) {
		if(lang.equals("italiano")) {
			return "Regole prenotazione: ecc...";
		} else if(lang.equals("english")) {
			return "Booking rules: etc...";
		}else throw new EntityNotFoundException("Language not supported! Write 'english' or 'italiano'!");
	}
	
	@GetMapping("/utenti")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<Utente>> getUserAll() {
		return ResponseEntity.ok(utenteService.getAll());
	}
	
	@GetMapping("/utenti/page")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<Page<Utente>> getUserAllPageable(Pageable pageable) {
		return ResponseEntity.ok(utenteService.getAllPageable(pageable));
	}
	
	@GetMapping("/utenti/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getUserByID(@PathVariable long id) {
		return ResponseEntity.ok(utenteService.getByID(id));
	}
	
	@PostMapping("/utenti")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Utente> createUser(@RequestBody Utente u) {
		return ResponseEntity.ok(utenteService.insertUtente(u));
	}
	
	@PutMapping("/utenti/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Utente> updateUser(@RequestBody Utente u, @PathVariable Long id) {
		return ResponseEntity.ok(utenteService.updateUtente(u));
	}
	
	@DeleteMapping("/utenti/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		return ResponseEntity.ok(utenteService.deleteUtente(id));
	}
	
	
	
	@GetMapping("/postazioni")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<Postazione>> getPostazioniAll() {
		return ResponseEntity.ok(postazioneService.getAll());
	}
	
	@GetMapping("/postazioni/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getPostazioneByID(@PathVariable long id) {
		return ResponseEntity.ok(postazioneService.getByID(id));
	}
	
	
	@PostMapping("/postazioni")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Postazione> createPostazione(@RequestBody Postazione p) {
		return ResponseEntity.ok(postazioneService.insertPostazione(p));
	}
	
	@PutMapping("/postazioni/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Postazione> updatePostazione(@RequestBody Postazione p, @PathVariable Long id) {
		return ResponseEntity.ok(postazioneService.updatePostazione(p, id));
	}
	
	@DeleteMapping("/postazioni/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deletePostazione(@PathVariable Long id) {
		return ResponseEntity.ok(postazioneService.deletePostazione(id));
		
	}
	
	
	@GetMapping("/edifici")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<Edificio>> getEdificiAll() {
		return ResponseEntity.ok(edificioService.getAll());
	}
	
	@GetMapping("/edifici/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getEdificioByID(@PathVariable long id) {
		return ResponseEntity.ok(edificioService.getByID(id));
	}
	
	
	@PostMapping("/edifici")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Edificio> createEdificio(@RequestBody Edificio e) {
		return ResponseEntity.ok(edificioService.insertEdificio(e));
	}
	
	@PutMapping("/edifici/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Edificio> updateEdificio(@RequestBody Edificio e, @PathVariable Long id) {
		return ResponseEntity.ok(edificioService.updateEdificio(e, id));
	}
	
	@DeleteMapping("/edifici/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteEdificio(@PathVariable Long id) {
		return ResponseEntity.ok(edificioService.deleteEdificio(id));
		
	}

	
	@GetMapping("/prenotazioni")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<List<Prenotazione>> getPrenotazioniAll() {
		return ResponseEntity.ok(prenotazioneService.getAll());
	}
	
	@GetMapping("/prenotazioni/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MODERATOR')")
	public ResponseEntity<?> getPrenotazioneByID(@PathVariable long id) {
		return ResponseEntity.ok(prenotazioneService.getByID(id));
	}
	
	
	@PostMapping("/prenotazioni")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Prenotazione> createPrenotazione(@RequestParam Long idUser, @RequestParam Long idPostazione) {
		Optional<Utente> utente = utenteService.getByID(idUser);
		Optional<Postazione> postazione = postazioneService.getByID(idPostazione);
		return ResponseEntity.ok(prenotazioneService.insertPrenotazione(utente.get(), postazione.get()));
		
	}
	
	@PutMapping("/prenotazioni/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Prenotazione> updatePrenotazione(@RequestBody Prenotazione p, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok(prenotazioneService.updatePrenotazione(p, id));
	}
	
	@DeleteMapping("/prenotazioni/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deletePrenotazione(@PathVariable Long id) {
		return ResponseEntity.ok(prenotazioneService.deletePrenotazione(id));
		
	}
}
