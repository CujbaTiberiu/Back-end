package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import DAO.PartecipazioneDAO;
import entity.Concerto;
import entity.Evento;
import entity.Location;
import entity.Partecipazione;
import entity.PartitaDiCalcio;
import entity.Persona;
import enums.Genere;
import enums.Sesso;
import enums.Stato;
import enums.tipoEvento;
import utils.JpaUtil;

public class MainProject {

	static  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public static void main(String[] args) {
		
		// Evento e1 = new Evento("E3", LocalDate.of(2023, 5, 20), "Festival giochi", tipoEvento.PUBBLICO, 2000, null, null);
		//Evento e2 = new Evento("Concerto", LocalDate.of(2023, 8, 5), "Live 50 cent", tipoEvento.PUBBLICO, 1500);
		//Evento e3 = new Evento("Matrimonio", LocalDate.of(2024, 1, 1), "Franco & Francesca", tipoEvento.PRIVATO, 300);
		
		//Persona p = new Persona("Marco", "Verdi", "m.verdi@gmail.com", LocalDate.of(1990, 1, 20), Sesso.Maschio);
		
		//Evento e = new Evento("E3", LocalDate.of(2023, 5, 20), "Festival giochi", tipoEvento.PUBBLICO, 2000, l);
		//Partecipazione pp = new Partecipazione(p,e,Stato.CONFERMATA);
		
		
			//Evento ev = new Evento();
		    //System.out.println(ev.getById(1));
		//PartitaDiCalcio pdc = new PartitaDiCalcio("Inter", "Milan", "Milan", 1, 3);
		Location l = new Location("Stadio San Siro", "Milano");
		
		Evento e = new Evento();
		e.setDataEvento(LocalDate.of(2023, 5, 30));
		e.setDescrizione("");
		e.setLocation(l);
		e.setNumeroMassimoPartecipanti(30000);
		e.setTipoEvento(tipoEvento.PUBBLICO);
		e.setTitolo("Derby");
		e.setTotPartecipazioni(null);
		//Evento e1 = e.getById(2);
		//e1.setDescrizione(pdc.toString());
		//e1.update(e1);
		//e.save(pdc);
		
		Concerto c1 = new Concerto("Concerto", LocalDate.of(2023, 5, 20), "Concerto Metallica", tipoEvento.PUBBLICO,
									30000, l, Genere.ROCK, true);
		
		//e.save(c1);
		PartitaDiCalcio p1 = new PartitaDiCalcio("Partita di Calcio", LocalDate.of(2023, 10, 1), "Derby Inter - Milan", tipoEvento.PUBBLICO, 40000, 
												l, "Inter", "Milan", "Milan", 1, 3);
		//e.save(p1);
		
		Persona pe = new Persona("Marco", "Neri", "m.neri@gmail.com",LocalDate.of(1980, 10, 1), Sesso.Maschio);
		Partecipazione pa = new Partecipazione(pe,p1,Stato.CONFERMATA);
		PartecipazioneDAO pd = new PartecipazioneDAO();
		pd.save(pa);
	}
	
}
