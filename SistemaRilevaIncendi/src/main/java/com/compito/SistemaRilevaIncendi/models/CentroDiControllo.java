package com.compito.SistemaRilevaIncendi.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Centri_controllo")
public class CentroDiControllo implements SondaObserver{
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String nome;
	 
	@Override
	public void update(Sonda sonda) {
		if(sonda.getLivelloFumo() == 1 || sonda.getLivelloFumo() == 2 || sonda.getLivelloFumo() == 3) {
			inviaAllarmeGiallo(sonda);
		}
		
		if(sonda.getLivelloFumo() == 4 || sonda.getLivelloFumo() == 5) {
			inviaAllarmeArancione(sonda);
		}
		
		if(sonda.getLivelloFumo() > 5) {
			inviaAllarmeRosso(sonda);
		}

	}
	 
	 private void inviaAllarmeRosso(Sonda sonda) {
	        String url = "http://host/alarm?idsonda=" + sonda.getId() + "&lat=" + sonda.getLatitudine()
	                + "&lon=" + sonda.getLongitudine() + "&smokelevel=" + sonda.getLivelloFumo();
	        System.out.println("Notificato il personale!");
	        System.out.println(url);
	    }
	 
	 private void inviaAllarmeGiallo(Sonda sonda) {
		 System.out.println("Posizione lat: " + sonda.getLatitudine()+ " e long: " + sonda.getLongitudine() 
		 + " in monitoraggio!");
	 }
	 
	 private void inviaAllarmeArancione(Sonda sonda) {
		 System.out.println("Centro di controllo in allerta per posizione lat: "+ sonda.getLatitudine()+
				 " e long: " + sonda.getLongitudine() );
	 }
	 

	// private String generaNotifica(Sonda sonda) {
	//	 return "Sonda ID: " + sonda.getId() + ", Latitudine: " + sonda.getLatitudine()
     //       + ", Longitudine: " + sonda.getLongitudine() + ", Livello Fumo: " + sonda.getLivelloFumo();
	 //}
}
