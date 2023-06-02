package com.epi.GodFathersPizzaday2.Model;

import lombok.Data;

@Data
public class Tavolo {
	
	private Integer numeroTavolo;
	private Integer numeroCoperti;
	private boolean stato = false;
	
	
	public Tavolo(Integer numeroTavolo, Integer numeroCoperti) {
		super();
		this.numeroTavolo = numeroTavolo;
		this.numeroCoperti = numeroCoperti;
	}
	
	
}
