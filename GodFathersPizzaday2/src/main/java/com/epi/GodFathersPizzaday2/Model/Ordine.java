package com.epi.GodFathersPizzaday2.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ordine {
	
	private Integer numeroOrdine;
	private Integer numeroCoperti;
	private LocalDateTime oraAcquisizione;
	private StatoOrdine stato;
	private double sommaCosto;
	List<FoodItem> listaOrdine = new ArrayList<FoodItem>();
	
	public void aggiungiCibo(FoodItem foodItem) {
	    listaOrdine.add(foodItem);
	}
	
	public String mostraOrdine() {
		return "Numero ordine: " + this.numeroOrdine + ", Numero coperti: " + this.numeroCoperti +
				", Ora presa ordine: " + this.oraAcquisizione + ", Stato ordine: " + this.stato +
				", Conto totale: " + this.contoTotale();
	}
	
	public double contoTotale() {
	    double sommaCosto = 0;
	    for (FoodItem o : listaOrdine) {
	        sommaCosto += o.getPrice();
	    }
	    return sommaCosto;
	}
}
