package com.compito.PrenotaPostazioneAziendale.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;

@Configuration
public class PrenotazioneConfiguration {

	@Bean
	@Scope("prototype")
	@Primary
	public Prenotazione newPrenotazione(Postazione postazione, Utente utente) {
		return new Prenotazione(postazione, utente);
	}
	
	@Bean
	@Scope("prototype")
	public Prenotazione newSetPrenotazione() {
		return new Prenotazione();
	}
}
