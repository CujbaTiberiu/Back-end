package com.epi.GodFathersPizzaday2.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.epi.GodFathersPizzaday2.Model.Cheese;
import com.epi.GodFathersPizzaday2.Model.Drink;
import com.epi.GodFathersPizzaday2.Model.Gift;
import com.epi.GodFathersPizzaday2.Model.Ham;
import com.epi.GodFathersPizzaday2.Model.Lemonade;
import com.epi.GodFathersPizzaday2.Model.Menu;
import com.epi.GodFathersPizzaday2.Model.Mug;
import com.epi.GodFathersPizzaday2.Model.Onions;
import com.epi.GodFathersPizzaday2.Model.Pineapple;
import com.epi.GodFathersPizzaday2.Model.Pizza;
import com.epi.GodFathersPizzaday2.Model.PizzaFamilySize;
import com.epi.GodFathersPizzaday2.Model.PizzaHawaiian;
import com.epi.GodFathersPizzaday2.Model.PizzaMargherita;
import com.epi.GodFathersPizzaday2.Model.PizzaSalami;
import com.epi.GodFathersPizzaday2.Model.PizzaTopping;
import com.epi.GodFathersPizzaday2.Model.Salami;
import com.epi.GodFathersPizzaday2.Model.Shirt;
import com.epi.GodFathersPizzaday2.Model.Water;
import com.epi.GodFathersPizzaday2.Model.Wine;



@Configuration
public class MenuConfiguration {

	@Bean
	public Menu menu() {
		Menu m = new Menu();
		
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