package com.compito.PrenotaPostazioneAziendale.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.service.UtenteService;

@Component
public class GestionePrenotazioni implements ApplicationRunner{
	
	@Autowired private UtenteService utenteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Utente u1 = utenteService.createFakeUtente();
		System.out.println(u1);
		utenteService.insertUtente(u1);
		
	}

}
