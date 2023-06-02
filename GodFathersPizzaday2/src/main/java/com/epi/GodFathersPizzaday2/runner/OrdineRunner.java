package com.epi.GodFathersPizzaday2.runner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epi.GodFathersPizzaday2.Configuration.MenuConfiguration;
import com.epi.GodFathersPizzaday2.Configuration.OrdineConfiguration;
import com.epi.GodFathersPizzaday2.Model.Drink;
import com.epi.GodFathersPizzaday2.Model.Ordine;
import com.epi.GodFathersPizzaday2.Model.Pizza;
import com.epi.GodFathersPizzaday2.Model.PizzaTopping;
import com.epi.GodFathersPizzaday2.Model.Tavolo;

@Component
public class OrdineRunner implements CommandLineRunner{
	
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(OrdineConfiguration.class);
	AnnotationConfigApplicationContext appMenuContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);

	Map<Integer, Tavolo> listaTavoli = new HashMap<Integer, Tavolo>();

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ordine Runner!");
		
		configTavoloWith_Bean();
		configOrdineWith_Bean();
		
		appContext.close();
		appMenuContext.close();
	}
	

	public void configTavoloWith_Bean() {		
		
		Tavolo t1 = (Tavolo) appContext.getBean("creaTavolo",1,4);
		Tavolo t2 = (Tavolo) appContext.getBean("creaTavolo",2,2);
		Tavolo t3 = (Tavolo) appContext.getBean("creaTavolo",3,6);
		

		listaTavoli.put(t1.getNumeroTavolo(), t1);
		listaTavoli.put(t2.getNumeroTavolo(), t2);
		listaTavoli.put(t3.getNumeroTavolo(), t3);
		
		System.out.println(" --- Tavoli ---");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
	}
	
	public void configOrdineWith_Bean() {
		
		Ordine o1 = (Ordine) appContext.getBean("creaOrdine", 1, listaTavoli.get(1), 2);
		
		Pizza pm = (Pizza) appMenuContext.getBean("pizzaMargherita");
		Pizza ps = (Pizza) appMenuContext.getBean("pizzaSalami");
		
		PizzaTopping pt = (PizzaTopping) appMenuContext.getBean("onionPizzaTopping");
		pt.setPizza(ps);
		
		Drink dl = (Drink) appMenuContext.getBean("drinkLemonade");
		Drink dw = (Drink) appMenuContext.getBean("drinkWater");
		
		o1.getListaOrdine().add(pm);
		o1.getListaOrdine().add(ps);
		
		o1.getListaOrdine().add(dw);
		o1.getListaOrdine().add(dl);
		System.out.println(" --- Ordini ---");
		System.out.println(o1);
		
		System.out.println(" --- Conto Totale ---");
		System.out.println(o1.contoTotale());
		
	}
	
	
}






