package dao;

import java.util.List;

import entity.Prestito;

public interface IPrestitoDAO {
	public void salva(Prestito p);
	public Prestito trovaPerId(Integer id);
	public void delete(Prestito p);
	public void update(Prestito p);
	public List<Prestito> mostraTutti();
	public List<Prestito>  cercaAttualmenteInPrestito(Integer tessera);
	public List<Prestito> mostraPrestitiScaduti();
}
