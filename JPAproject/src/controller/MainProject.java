package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class MainProject {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAproject");
	static EntityManager em = emf.createEntityManager();
	//statement di JPA che mi permette di collegarmi al DB
	
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		c.setNome("Marco");
		c.setCognome("Gianni");
		c.setRegioneResidenza("Toscana");
		c.setEmail("m.gianni@gmail.com");
		c.setDataNascita(LocalDate.of(1980, 02, 11));
		//inserisciCliente(c);
		Cliente c1 = leggiCliente(1);
		System.out.println(c1);
	}
	
	public static void inserisciCliente(Cliente c) {
		em.getTransaction().begin();//inizia
		em.persist(c);//quale azione
		em.getTransaction().commit();//fai azione
		System.out.println("Utente aggiunto nel DB!");
	}


	public static void modificaCliente(Cliente c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		System.out.println("Utente modificato nel DB!");
		
	}

	public static void eliminaCliente(Cliente c) {
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		System.out.println("Utente eliminato dal DB!");
		
	}

	public static Cliente leggiCliente(Integer id) {
		em.getTransaction().begin();
		Cliente c = em.find(Cliente.class, id);
		em.getTransaction().commit();
		System.out.println("Utente aggiunto nel DB!");
		return c;
	}
}
