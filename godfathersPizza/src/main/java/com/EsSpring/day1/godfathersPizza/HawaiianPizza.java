package com.EsSpring.day1.godfathersPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HawaiianPizza {

	
	private PizzaMargherita pizza;
	private String prosciutto;
	private String ananas;
	private Integer calorie;
	private double prezzo;
	
	public void readTxt() {
		 System.out.println("HawaiianPizza" + "(" + pizza.getPomodoro() + "," + pizza.getMozzarella() + "," + prosciutto  + "," + ananas +") "  
	+ getCalorie() + " " + getPrezzo());
		}
	
}
