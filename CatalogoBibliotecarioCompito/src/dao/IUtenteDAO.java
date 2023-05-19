package dao;

import java.util.List;

import entity.Utente;

public interface IUtenteDAO {

	public void salva(Utente u);
	public Utente trovaPerTessera(Integer id);
	public void delete(Utente u);
	public void update(Utente u);
	public List<Utente> mostraTutti();
}
