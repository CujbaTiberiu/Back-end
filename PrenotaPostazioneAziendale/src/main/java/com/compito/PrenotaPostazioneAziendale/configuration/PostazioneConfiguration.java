package com.compito.PrenotaPostazioneAziendale.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.TipoPostazione;


@Configuration
public class PostazioneConfiguration {

	@Bean
	@Scope("prototype")
	public Postazione newPostazione(String descrizione, int numeroMaxOccupanti, TipoPostazione tipo, Edificio edificio) {
		return new Postazione(descrizione, numeroMaxOccupanti, tipo, edificio);
	}
	
}
