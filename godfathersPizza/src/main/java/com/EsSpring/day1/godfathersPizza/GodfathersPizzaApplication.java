package com.EsSpring.day1.godfathersPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class GodfathersPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
		
		System.out.println("Pizzas                             Calories  Prices");
		beanPizzaMargherita();		
		beanPizzaHawaii();
	}
	
	public static void beanPizzaMargherita() {
		// Creo un Container dove utilizzare i bean sulla base del file di configurazione ConfigurationTest creato
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigPizzaMargherita.class);
		
		// Recupero il Bean test
		PizzaMargherita p1 = (PizzaMargherita) appContext.getBean("pizzaMargherita");
		p1.readTxt();
		
		
		// Chiudo il Context
		appContext.close();
	}

	public static void beanPizzaHawaii() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigHawaiianPizza.class);

		HawaiianPizza p1 = (HawaiianPizza) appContext.getBean("hawaiianPizza");
		p1.readTxt();
		
		appContext.close();
	}

}
