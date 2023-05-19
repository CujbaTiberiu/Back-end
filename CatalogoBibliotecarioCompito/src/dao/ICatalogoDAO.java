package dao;

import java.util.List;

import entity.Catalogo;
import entity.Prestito;

public interface ICatalogoDAO {
	
	public void salvaNelCatalogo(Catalogo c);
	public void cancellaDalCatalogo(Integer isbn);
	public Catalogo cercaPerIsbn(Integer isbn);
	public List<Catalogo> cercaPerAnnoPubblicazione(Integer anno);
	public List<Catalogo> cercaPerAutore(String autore);
	public List<Catalogo> cercaPerTitolo(String titolo);
	
}
