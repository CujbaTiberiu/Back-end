package com.EsSpring.day1.godfathersPizza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPizzaMargherita {
	
	
	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita("pomodoro", "mozzarella", 1103, 4.99);	
	}

}
