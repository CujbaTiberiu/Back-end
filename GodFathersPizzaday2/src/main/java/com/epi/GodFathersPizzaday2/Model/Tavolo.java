package com.epi.GodFathersPizzaday2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tavolo {
	
	private Integer numero;
	private Integer numeroCoperti;
	private StatoTavolo stato;
	
}
