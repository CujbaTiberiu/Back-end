package com.EsSpring.day1.godfathersPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigHawaiianPizza {

	 @Autowired
	 private PizzaMargherita pizzaMargherita;

	@Bean
	public HawaiianPizza hawaiianPizza() {
		return new HawaiianPizza(pizzaMargherita, "prosciutto", "ananas", 1024, 6.99);
	}
	
	
	}
