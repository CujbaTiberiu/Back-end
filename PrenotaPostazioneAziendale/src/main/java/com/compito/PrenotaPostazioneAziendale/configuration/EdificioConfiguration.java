package com.compito.PrenotaPostazioneAziendale.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;

@Configuration
public class EdificioConfiguration {

	@Bean
	@Scope("prototype")
	public Edificio newEdificio(String nome, String indirizzo, String citta) {
		return new Edificio(nome, indirizzo, citta);
	}
}
