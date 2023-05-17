package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import entity.Evento;
import entity.Location;
import entity.Partecipazione;
import entity.Persona;
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
		//addEvento(e1);
		//addEvento(e2);
		//addEvento(e3);
		//Evento e4 = findEvento(1);
		//System.out.println(e4);
		//removeEvento(e4);
		//Persona p = new Persona("Marco", "Verdi", "m.verdi@gmail.com", LocalDate.of(1990, 1, 20), Sesso.Maschio);
		//Location l = new Location("Stadio San Siro", "Milano");
		//Evento e = new Evento("E3", LocalDate.of(2023, 5, 20), "Festival giochi", tipoEvento.PUBBLICO, 2000, l);
		//Partecipazione pp = new Partecipazione(p,e,Stato.CONFERMATA);
		//addPartecipazione(pp);
		Evento er = findEvento(1);
		System.out.println(er.getLocation());
		//Persona p = findPersona(1);
		//p.getListaPartecipazioni().forEach(pa -> System.out.println(pa));
	}
	
	public static void addEvento(Evento e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Evento salvato nel DB!!");
	}
	
	public static void addPartecipazione(Partecipazione p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Evento salvato nel DB!!");
	}
	
	public static Evento findEvento(int id) {
		em.getTransaction().begin();
		Evento u = em.find(Evento.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public static Persona findPersona(int id) {
		em.getTransaction().begin();
		Persona p = em.find(Persona.class, id);
		em.getTransaction().commit();
		return p;
	}
	
	public static void removeEvento(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Evento eliminato dal DB!!");
	}
	
	public static void refreshEvento(Evento e) {
		em.getTransaction().begin();
		em.refresh(e);
		em.getTransaction().commit();
		System.out.println("Evento refreshato!");
	}

}
