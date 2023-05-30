package com.epi.GodFathersPizzaday2.runner;

import org.springframework.stereotype.Component;

import com.epi.GodFathersPizzaday2.Configuration.MenuConfiguration;
import com.epi.GodFathersPizzaday2.Model.Drink;
import com.epi.GodFathersPizzaday2.Model.GestioneOrdini;
import com.epi.GodFathersPizzaday2.Model.Menu;
import com.epi.GodFathersPizzaday2.Model.Pizza;
import com.epi.GodFathersPizzaday2.Model.StatoOrdine;
import com.epi.GodFathersPizzaday2.Model.StatoTavolo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Component
public class MenuRunner implements CommandLineRunner{

	static Logger log = LoggerFactory.getLogger(MenuRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		log.info("fa?");
		configWith_Bean();
		
	}
	
	public static void configWith_Bean() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);

		Menu menu = (Menu) appContext.getBean("menu");
		
		log.info(" -- Pizzas --");
		menu.getMenuPizza().forEach(p -> log.info(p.getMenuItemLine()));
		log.info(" -- Toppings --");
		menu.getMenuTopping().forEach(t -> log.info(t.getMenuItemLine()));
		log.info(" -- Drinks --");
		menu.getMenuDrink().forEach(d -> log.info(d.getMenuItemLine()));
		log.info(" -- Franchise --");
		menu.getMenuGift().forEach(g -> log.info(g.getMenuItemLine()));
	
		GestioneOrdini go = (GestioneOrdini) appContext.getBean("gestioneOrdini");
		log.info(" -- Order --");
		go.getOrdine().setStato(StatoOrdine.IN_CORSO);
		go.getOrdine().setOraAcquisizione(LocalDateTime.now());
		go.getOrdine().setNumeroOrdine(1);
		go.getOrdine().setNumeroCoperti(2);
		go.getOrdine().aggiungiCibo((Drink)menu.getMenuDrink().get(0));
		go.getOrdine().aggiungiCibo((Drink)menu.getMenuDrink().get(1));
		go.getOrdine().aggiungiCibo((Pizza)menu.getMenuPizza().get(0));
		go.getOrdine().aggiungiCibo((Pizza)menu.getMenuPizza().get(1));
		
		go.getTavolo().setNumero(1);
		go.getTavolo().setNumeroCoperti(2);;
		go.getTavolo().setStato(StatoTavolo.OCCUPATO);
		
		log.info(go.getTavolo().toString());
		log.info(go.getOrdine().mostraOrdine());
		log.info(" -- Elenco Ordinazione --");
	    go.getOrdine().getListaOrdine().forEach(o -> log.info(o.toString()));
	    
		appContext.close();
		
	}
	
	

}

/*GestioneOrdini go = (GestioneOrdini) appContext.getBean("gestioneOrdini");
		log.info(" -- Order --");
		go.getOrdine().setStato(StatoOrdine.IN_CORSO);
		go.getOrdine().setOraAcquisizione(LocalDateTime.now());
		go.getOrdine().setNumeroOrdine(1);
		go.getOrdine().setNumeroCoperti(2);
		go.getOrdine().aggiungiCibo((Drink)menu.getMenuDrink().get(0));
		go.getOrdine().aggiungiCibo((Drink)menu.getMenuDrink().get(1));
		go.getOrdine().aggiungiCibo((Pizza)menu.getMenuPizza().get(0));
		go.getOrdine().aggiungiCibo((Pizza)menu.getMenuPizza().get(1));
		
		go.getTavolo().setNumero(1);
		go.getTavolo().setNumeroCoperti(2);;
		go.getTavolo().setStato(StatoTavolo.OCCUPATO);
		//log.info(go.toString());
 */