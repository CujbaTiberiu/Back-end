package com.epi.GodFathersPizzaday2.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import com.epi.GodFathersPizzaday2.Model.Ordine;
import com.epi.GodFathersPizzaday2.Model.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class OrdineConfiguration{

	@Value("${tavolo.coperto.costo}") private double costoCoperto;
	
	

	@Bean
	@Scope("prototype")
	public Ordine creaOrdine(Integer numeroOrdine, Tavolo tavolo, Integer numeroCoperti) {
		return new Ordine(numeroOrdine, tavolo, numeroCoperti, costoCoperto);
	}
	
	
	@Bean
	@Scope("prototype")
	public Ordine ordine(int numeroOrdine, Tavolo tavolo, int numeroCoperti) {
		try {
			return new Ordine(numeroOrdine, tavolo, numeroCoperti, costoCoperto);
		} catch (Exception e) {
			return null;
		}
		
	}

	

}
