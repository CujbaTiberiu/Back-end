package com.compito.PrenotaPostazioneAziendale.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.TipoPostazione;
import com.compito.PrenotaPostazioneAziendale.model.Utente;
import com.compito.PrenotaPostazioneAziendale.service.EdificioService;
import com.compito.PrenotaPostazioneAziendale.service.PostazioneService;
import com.compito.PrenotaPostazioneAziendale.service.PrenotazioneService;
import com.compito.PrenotaPostazioneAziendale.service.UtenteService;

@Component
public class GestionePrenotazioni implements ApplicationRunner{
	
	@Autowired  UtenteService utenteService;
	@Autowired  EdificioService edificioService;
	@Autowired  PostazioneService postazioneService;
	@Autowired  PrenotazioneService prenotazioneService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//Utente u2 = utenteService.createCustomUtente("#nikolatesla", "Nikola Tesla", "nikolatesla@custommail.com");
		//utenteService.insertUtente(u2);
		
		//Utente u1 = utenteService.createFakeUtente();
		//System.out.println(u1);
		//utenteService.insertUtente(u1);
		List<Utente> listaUtenti =  utenteService.getAll();
		listaUtenti.forEach(u -> System.out.println(u));
		Utente uGet = utenteService.getByID(5);
		System.out.println(uGet);
		//Edificio e1 = edificioService.createFakeEdificio();
		//System.out.println(e1);

		//Postazione p1 = postazioneService.createNewPostazione("Vista mare", 8, TipoPostazione.OPENSPACE, e1);
	}

}
