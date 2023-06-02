package com.epi.GodFathersPizzaday2.runner;


import com.epi.GodFathersPizzaday2.Configuration.MenuConfiguration;
import com.epi.GodFathersPizzaday2.Model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

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
	
		
		appContext.close();
		
	}
	
}
