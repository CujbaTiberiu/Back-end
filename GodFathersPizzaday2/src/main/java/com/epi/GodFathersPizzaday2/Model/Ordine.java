package com.epi.GodFathersPizzaday2.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
public class Ordine {
	
	private Integer numeroOrdine;
	private Tavolo tavolo;
	List<FoodItem> listaOrdine;
	private StatoOrdine stato;
	private Integer numeroCoperti = 1;
	private LocalDateTime oraAcquisizione;
	private double costoCoperto;
	
	
	public Ordine(Integer numeroOrdine, Tavolo tavolo, Integer numeroCoperti, double costoCoperto) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.tavolo = tavolo;
		this.tavolo.setStato(true);
		this.listaOrdine = new ArrayList<FoodItem>();
		this.stato = StatoOrdine.IN_CORSO;
		this.numeroCoperti = numeroCoperti;
		this.oraAcquisizione = LocalDateTime.now();
		this.costoCoperto = costoCoperto;
		
	}
	
	public String mostraOrdine() {
		return "Numero ordine: " + this.numeroOrdine + ", Numero coperti: " + this.numeroCoperti +
				", Ora presa ordine: " + this.oraAcquisizione + ", Stato ordine: " + this.stato +
				", Conto totale: " + this.contoTotale();
	}
	
	public double contoTotale() {
	    double sommaCosto = 0;
	    double costoCoperti = costoCoperto * numeroCoperti;
	    for (FoodItem f : listaOrdine) {
	        sommaCosto += f.getPrice();
	    }
	    return sommaCosto + costoCoperti;
	}

}
