package com.EsSpring.day1.godfathersPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.EsSpring.day1.godfathers.Config.MenuConfiguration;
import com.EsSpring.day1.godfathersPizza.model.Menu;

@SpringBootApplication
public class GodfathersPizzaApplication {

	public static void main(String[] args) {
		
		configWith_Bean();
	
	}
	

	public static void configWith_Bean() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);

		// Recupero il Bean Menu
		Menu menu = (Menu) appContext.getBean("menu");
		System.out.println(" -- Pizzas --");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println(" -- Toppings --");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuItemLine()));
		System.out.println(" -- Drinks --");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuItemLine()));
		System.out.println(" -- Gifts --");
		menu.getMenuGift().forEach(g -> System.out.println(g.getMenuItemLine()));
		// Chiudo il Context
		appContext.close();
	}

}