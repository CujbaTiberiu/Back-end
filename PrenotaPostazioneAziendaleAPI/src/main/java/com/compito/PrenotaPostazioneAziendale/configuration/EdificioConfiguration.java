package com.compito.PrenotaPostazioneAziendale.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.github.javafaker.Faker;

@Configuration
public class EdificioConfiguration {

	@Bean
	@Scope("prototype")
	public Edificio newEdificio(String nome, String indirizzo, String citta) {
		return new Edificio(nome, indirizzo, citta);
	}
	

	@Bean
	@Scope("prototype")
	public Edificio fakeEdificio() {
		Faker fake = Faker.instance(new Locale("it-IT"));
        Edificio fakeEdificio = new Edificio();
        fakeEdificio.setCitta(fake.address().cityName());
        fakeEdificio.setIndirizzo(fake.address().streetAddress());
        fakeEdificio.setNome(fake.gameOfThrones().house());
        return fakeEdificio;
	}
}
