package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Utente;
import utils.JpaUtil;

public class UtenteDAO implements IUtenteDAO{

	@Override
	public void salva(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println(u + " salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public Utente trovaPerTessera(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Utente u =  em.find(Utente.class, id);
			em.getTransaction().commit();
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su ricerca!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			System.out.println(u + " eliminato dal DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void update(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			System.out.println(u + "salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella modifica del " + u + " nel DB!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Utente> mostraTutti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("mostraTuttiUtenti");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
