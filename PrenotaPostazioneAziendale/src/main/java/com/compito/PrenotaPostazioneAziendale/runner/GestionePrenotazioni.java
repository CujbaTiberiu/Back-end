package com.compito.PrenotaPostazioneAziendale.runner;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.compito.PrenotaPostazioneAziendale.model.Edificio;
import com.compito.PrenotaPostazioneAziendale.model.Postazione;
import com.compito.PrenotaPostazioneAziendale.model.Prenotazione;
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
		
		System.out.println(" --- Utente runner --- ");
		/*
		Utente u2 = utenteService.createCustomUtente();
		u2.setEmail("nikolatesla@custommail.com");
		u2.setNomeCompleto("Nikola Tesla");
		u2.setUserName("#nikolatesla");
		utenteService.insertUtente(u2);
		
		Utente u1 = utenteService.createFakeUtente();
		System.out.println(u1);
		utenteService.insertUtente(u1);
		*/
		List<Utente> listaUtenti =  utenteService.getAll();
		listaUtenti.forEach(u -> System.out.println(u));
		
		Utente uGet = utenteService.getByID(1);
		System.out.println(uGet);
		System.out.println(" -- Lista preotazioni di un utente -- ");
		uGet.getPrenotazioni().forEach(p -> System.out.println(p));
		
		System.out.println(" --- Edificio runner --- ");
		
		//Edificio e1 = edificioService.createFakeEdificio();
		//System.out.println(e1);
		//edificioService.insertEdificio(e1);
		List<Edificio> eRecuperato = edificioService.getAll();
        eRecuperato.forEach(e -> System.out.println(e));
		Edificio ee = edificioService.getByID(1);
		System.out.println(ee);

        System.out.println(" -- Postazione presenti in un edificio -- ");
        eRecuperato.forEach(e ->System.out.println(e.getPostazioni()));
        
        System.out.println(" --- Postazione runner --- ");
        /*
		Postazione p1 = postazioneService.createSetNewPostazione();
		p1.setDescrizione("Vista mare");
		p1.setEdificio(eRecuperato.get(0));
		p1.setNumeroMaxOccupanti(8);
		p1.setTipo(TipoPostazione.OPENSPACE);
        postazioneService.insertPostazione(p1);
        
		Postazione p2 = postazioneService.createSetNewPostazione();
		p2.setDescrizione("Executive");
		p2.setTipo(TipoPostazione.PRIVATO);
		p2.setNumeroMaxOccupanti(10);
		p2.setEdificio(eRecuperato.get(1));
		postazioneService.insertPostazione(p2);
        */
		List<Postazione> pRec = postazioneService.getAll();
		pRec.forEach(p -> System.out.println(p));
		
		System.out.println(" -- Ricerca per citta e tipo -- ");
		System.out.println(postazioneService.findByCittaAndTipo("Barbieri nell'emilia", TipoPostazione.OPENSPACE));
		
		System.out.println(" --- Prenotazione runner --- ");
		
		try {
			
		
		//Prenotazione pr1 = prenotazioneService.createSetNewPrenotazione();
		//pr1.setPostazione(pRec.get(1));
		//pr1.setUtente(uGet);
		
		//Prenotazione pr2 = prenotazioneService.createSetNewPrenotazione();
		//pr2.setPostazione(pRec.get(1));
		//pr2.setUtente(uGet);
		
		//prenotazioneService.insertPrenotazione(pr2);
		//prenotazioneService.insertPrenotazione(pr1);
		
		List<Prenotazione> listaPreonotazioni = prenotazioneService.getAll();
		listaPreonotazioni.forEach(p -> System.out.println(p));
		
		
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	
}
