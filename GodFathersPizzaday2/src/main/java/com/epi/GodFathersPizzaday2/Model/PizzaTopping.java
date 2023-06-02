package com.epi.GodFathersPizzaday2.Model;

import lombok.Setter;

public class PizzaTopping extends FoodItem {

	@Setter
	private Pizza pizza;

	public PizzaTopping(String name,double calories, double price) {
		super(name, price, calories);
	}

}