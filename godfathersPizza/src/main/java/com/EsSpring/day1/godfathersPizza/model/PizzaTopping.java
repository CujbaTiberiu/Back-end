package com.EsSpring.day1.godfathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class PizzaTopping extends FoodItem {

	public PizzaTopping() {
		super();
	}

	public PizzaTopping(String name,double calories, double price) {
		super(name, price, calories);
	}

}