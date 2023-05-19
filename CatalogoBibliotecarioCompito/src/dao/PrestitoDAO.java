package dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Prestito;
import utils.JpaUtil;

public class PrestitoDAO implements IPrestitoDAO{

	@Override
	public void salva(Prestito p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("Prestito salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public Prestito trovaPerId(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Prestito p =  em.find(Prestito.class, id);
			em.getTransaction().commit();
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Prestito p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			System.out.println("Prestito eliminato dal DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void update(Prestito p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			System.out.println("Prestito salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Prestito> mostraTutti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("mostraTuttiPrestiti");
			return q.getResultList();
		} finally {
			em.close();
		}
	}
	
	@Override
	public List<Prestito> cercaAttualmenteInPrestito(Integer tessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("cercaAttualmenteInPrestito");
			q.setParameter("tessera", tessera);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Prestito> mostraPrestitiScaduti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("mostraPrestitiScaduti");
			q.setParameter("dataOggi", LocalDate.now());
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
