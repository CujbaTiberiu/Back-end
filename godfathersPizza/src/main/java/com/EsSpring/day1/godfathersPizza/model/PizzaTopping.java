package com.EsSpring.day1.godfathersPizza.model;

public class PizzaTopping extends FoodItem {

	private Pizza pizza;

	public PizzaTopping(String name,double calories, double price) {
		super(name, price, calories);
	}

}