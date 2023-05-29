package com.EsSpring.day1.godfathers.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.EsSpring.day1.godfathersPizza.model.Cheese;
import com.EsSpring.day1.godfathersPizza.model.Drink;
import com.EsSpring.day1.godfathersPizza.model.Gift;
import com.EsSpring.day1.godfathersPizza.model.Ham;
import com.EsSpring.day1.godfathersPizza.model.Lemonade;
import com.EsSpring.day1.godfathersPizza.model.Menu;
import com.EsSpring.day1.godfathersPizza.model.Mug;
import com.EsSpring.day1.godfathersPizza.model.Onions;
import com.EsSpring.day1.godfathersPizza.model.Pineapple;
import com.EsSpring.day1.godfathersPizza.model.Pizza;
import com.EsSpring.day1.godfathersPizza.model.PizzaFamilySize;
import com.EsSpring.day1.godfathersPizza.model.PizzaHawaiian;
import com.EsSpring.day1.godfathersPizza.model.PizzaMargherita;
import com.EsSpring.day1.godfathersPizza.model.PizzaSalami;
import com.EsSpring.day1.godfathersPizza.model.PizzaTopping;
import com.EsSpring.day1.godfathersPizza.model.Salami;
import com.EsSpring.day1.godfathersPizza.model.Shirt;
import com.EsSpring.day1.godfathersPizza.model.Water;
import com.EsSpring.day1.godfathersPizza.model.Wine;



@Configuration
public class MenuConfiguration {

	@Bean
	public Menu menu() {
		Menu m = new Menu();

//		List<Pizza> listaPizze = m.getMenuPizza();
//		PizzaMargherita pm = pizzaMargherita();
//		listaPizze.add(pm);

		m.getMenuPizza().add(pizzaMargherita());
		m.getMenuPizza().add(pizzaHawaiian());
		m.getMenuPizza().add(pizzaSalami());
		m.getMenuPizza().add(pizzaFamilySize(pizzaMargherita()));
		
		m.getMenuDrink().add(drinkLemonade());
		m.getMenuDrink().add(drinkWater());
		m.getMenuDrink().add(drinkWine());
		
		m.getMenuGift().add(shirtGift());
		m.getMenuGift().add(mugGift());
		
		m.getMenuTopping().add(cheesePizzaTopping());
		m.getMenuTopping().add(pineapplePizzaTopping());
		m.getMenuTopping().add(onionPizzaTopping());
		m.getMenuTopping().add(hamPizzaTopping());
		m.getMenuTopping().add(salamiPizzaTopping());

		return m;
	}

	@Bean
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	public PizzaFamilySize pizzaFamilySize(Pizza p) {
		return new PizzaFamilySize(p);
	}
	
	@Bean
	public Drink drinkLemonade() {
		return new Lemonade();
	}
	
	@Bean
	public Drink drinkWater() {
		return new Water();
	}
	
	@Bean
	public Drink drinkWine() {
		return new Wine();
	}
	
	@Bean
	public Gift shirtGift() {
		return new Shirt();
	}
	
	@Bean
	public Gift mugGift() {
		return new Mug();
	}
	
	
	@Bean
	public PizzaTopping cheesePizzaTopping() {
		return new Cheese();
	}
	
	@Bean
	public PizzaTopping hamPizzaTopping() {
		return new Ham();
	}
	
	@Bean
	public PizzaTopping pineapplePizzaTopping() {
		return new Pineapple();
	}
	
	@Bean
	public PizzaTopping onionPizzaTopping() {
		return new Onions();
	}
	
	@Bean
	public PizzaTopping salamiPizzaTopping() {
		return new Salami();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}