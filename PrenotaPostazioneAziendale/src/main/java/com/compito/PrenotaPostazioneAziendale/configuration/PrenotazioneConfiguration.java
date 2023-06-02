package com.compito.PrenotaPostazioneAziendale.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;

@Configuration
public class PrenotazioneConfiguration {

	@Bean
	@Scope("prototype")
	public Prenotazione newPrenotazione(Postazione postazione, Utente utente, LocalDate inizioPrenotazione) {
		return new Prenotazione(postazione, utente, inizioPrenotazione);
	}
}
