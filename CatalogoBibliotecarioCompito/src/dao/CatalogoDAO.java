package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entity.Catalogo;
import utils.JpaUtil;

public class CatalogoDAO implements ICatalogoDAO{

	@Override
	public void salvaNelCatalogo(Catalogo c) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			System.out.println("Elemento " + c + " salvato nel DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		}finally {
			em.close();
		}
	}
	
	

	@Override
	public void cancellaDalCatalogo(Integer isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Catalogo c =  em.find(Catalogo.class, isbn);
			em.remove(c);
			em.getTransaction().commit();
			System.out.println("Elememento del " + c + " eliminato dal DB!!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella cancellazione!!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}



	@Override
	public Catalogo cercaPerIsbn(Integer isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Catalogo c =  em.find(Catalogo.class, isbn);
			em.getTransaction().commit();
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella ricerca!");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<Catalogo> cercaPerAnnoPubblicazione(Integer anno) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("mostraPerAnnoPub");
			q.setParameter("anno", anno);
			return q.getResultList();
		} finally {
			em.close();
		}
	}
	

	@Override
	public List<Catalogo> cercaPerAutore(String autore) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("cercaPerAutore");
			q.setParameter("autore", autore);
			return q.getResultList();
		} catch(Exception e) {
			System.out.println("Errore nella ricerca!");
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<Catalogo> cercaPerTitolo(String titolo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("cercaPerTitolo");
			 q.setParameter("titolo", "%" + titolo.toLowerCase() + "%");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	

}
