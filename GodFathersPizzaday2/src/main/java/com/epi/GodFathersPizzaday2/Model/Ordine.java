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
	//private double sommaCosto;
	List<FoodItem> listaOrdine = new ArrayList<FoodItem>();
	
	public void aggiungiCibo(FoodItem foodItem) {
	    listaOrdine.add(foodItem);
	}

}
