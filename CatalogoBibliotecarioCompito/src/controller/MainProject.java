package controller;

import java.time.LocalDate;
import java.util.List;
import dao.CatalogoDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import entity.Catalogo;
import entity.Libro;
import entity.Prestito;
import entity.Rivista;
import entity.Utente;
import enums.Periodicita;

public class MainProject {

	public static void main(String[] args) {
	
		Rivista r1 = new Rivista("Forbes",2000, 60, Periodicita.SEMESTRALE);
		Rivista r2 = new Rivista("Vogue",2002, 40, Periodicita.MENSILE);
		
		Libro l1 = new Libro("The Ice Dragon", 1980, 250, "George R. R. Martin", "fantasy");
		Libro l2 = new Libro("The Lord of The Rings", 1954, 350, "J. R. R. Tolkien", "fantasy");
		Libro l3 = new Libro("The Book of Enoch", 1, 500, "Enoch", "history - fantasy");
		
		Utente u1 = new Utente("Fidel", "Castro", LocalDate.of(1926, 8, 13));
		Utente u2 = new Utente("Joe", "Biden", LocalDate.of(1942, 11, 20));
		

		/* -- Salva nel Catalogo -- */
		//CatalogoDAO cd = new CatalogoDAO();
		//cd.salvaNelCatalogo(r1);
		//cd.salvaNelCatalogo(r2);
		//cd.salvaNelCatalogo(l1);
		//cd.salvaNelCatalogo(l2);
		//cd.salvaNelCatalogo(l3);
		
		
		/* -- Rimozione di un elemento del catalogo dato un codice ISBN -- */
		//cd.cancellaDalCatalogo(5);
		
		
		/* -- Salva utenti -- */
		//UtenteDAO ud = new UtenteDAO();
		//ud.salva(u1);
		//ud.salva(u2);
		
		
		/* -- Cerca utente con numero tessera -- */
		//Utente fidel = ud.trovaPerTessera(1);
		//System.out.println(fidel);
		
		
		/* -- Cerca nel catologo con Isbn -- */
		//Catalogo iceDragon = cd.cercaPerIsbn(3);
		//System.out.println(iceDragon);
		
		
		/* -- Salva un Prestito -- */
		//Prestito p1 = new Prestito(fidel, iceDragon, LocalDate.of(2023, 5, 19));
		//PrestitoDAO pd = new PrestitoDAO();
		//pd.salva(p1);
		
		
		/* -- Ricerca per anno pubblicazione -- */
		//List<Catalogo> ap = cd.cercaPerAnnoPubblicazione(1954);
		//ap.forEach(p -> System.out.println(p));
		
		
		/* -- Ricerca per autore -- */
		//List<Catalogo> tolk = cd.cercaPerAutore("J. R. R. Tolkien");
		//tolk.forEach(a -> System.out.println(a));
		
		
		/* -- Ricerca per titolo o parte di esso -- */
		//List<Catalogo> lordRings = cd.cercaPerTitolo("lord");
		//lordRings.forEach(c -> System.out.println(c));
		//List<Catalogo> vogue = cd.cercaPerTitolo("vo");
		//vogue.forEach(c -> System.out.println(c));
		
		
		/* -- Ricerca degli elementi attualmente in prestito dato un numero di tessera utente -- */
		//List<Prestito> p = pd.cercaAttualmenteInPrestito(1);
		//p.forEach(pe -> System.out.println(pe));
		
		
		/* -- Ricerca di tutti i prestiti scaduti e non ancora restituiti -- */
		//Prestito ps = pd.trovaPerId(6);
		//ps.setDataRestituzioneEffettiva(LocalDate.of(2023, 7, 1));
		//pd.update(ps);
		//List<Prestito> p2 = pd.mostraPrestitiScaduti();//not working well..in revision
		//p2.forEach(psca -> System.out.println(psca));
		
	}

}
