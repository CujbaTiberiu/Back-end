package com.EsSpring.day1.godfathersPizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class FoodItem {

	protected String name;
	protected double price;
	protected double calories;

	public String getMenuItemLine() {
		return this.name + " - calories: " + this.calories + " - price: " + this.price;
	}

}