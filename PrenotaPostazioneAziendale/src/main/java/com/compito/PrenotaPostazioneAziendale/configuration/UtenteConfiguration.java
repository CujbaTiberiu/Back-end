package com.compito.PrenotaPostazioneAziendale.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfiguration {

	@Bean
	@Scope("prototype")
	public Utente fakeUtente() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Utente userFake = new Utente();
		userFake.setNomeCompleto(fake.name().fullName());
		userFake.setUserName( "#" + userFake.getNomeCompleto());
		userFake.setEmail(userFake.getNomeCompleto() + "@fakeMail.com");
		return userFake;
	}
}
