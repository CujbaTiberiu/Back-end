package w2.Compito.epicode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainProject {
	
	static public Logger log = LoggerFactory.getLogger(MainProject.class);
	private static String path = "CatalogoBiblioteca/cat.txt";
	private static File file = new File(path);
	static List<Catalogo> catalogo = new ArrayList<Catalogo>();

	public static void main(String[] args) {
		
		//log.info("--- Elementi aggiunti ---");
		catalogo.add(new Libro("1L", "Il trono di spade", 2015, 400,"George R.R. Martin" ,"Fantasy"));
		catalogo.add(new Libro("2L", "Arte della guerra", 100, 600,"Sun Tzu" ,"Non-Fiction"));
		catalogo.add(new Libro("3L", "Il signore degli Anelli", 2015, 400,"J. R. R. Tolkien" ,"Fantasy"));
		
		catalogo.add(new Rivista("1R", "GamingNow", 2010, 60, Periodicità.SETTIMANALE));
		catalogo.add(new Rivista("2R", "TechnologyTomorrow", 2002, 100, Periodicità.MENSILE));
		catalogo.add(new Rivista("3R", "MotorShow", 2006, 150, Periodicità.SEMESTRALE));
		
		  log.info("--- Elenco catalogo ---");
	    catalogo.forEach(e -> System.out.println(e));
	    //try {
			//scriviSuFile();
		//} catch (IOException e1) {
			//log.info("Scritto su file!");
			//e1.printStackTrace();
		//}
	    log.info("--- Rimozione di un elemento ---");
	    String elementoRimosso = removeElement("3L");
	    log.info("Elemento rimosso" + elementoRimosso);
	    
	    log.info("--- Elenco catalogo ---");
	    catalogo.forEach(e -> System.out.println(e));
	    
	    log.info("--- Ricerca di un elemento per ISBN ---");
	    String ricercaPerIsbn = findByIsbn("3R").toString();
	    log.info("Elemento ricercato per codice ISBN" + ricercaPerIsbn);
	    
	    log.info("--- Ricerca di un elemento per Anno pubblicazione ---");
	    String ricercaPerAnnoPub = findByPubYear(2015).toString();
	    log.info("Elemento ricercato per anno pubblicazione" + ricercaPerAnnoPub);
	    
	    log.info("--- Ricerca di un elemento per Autore ---");
	    String ricercaPerAutore = findByAuthor("Sun Tzu").toString();
	    log.info("Elemento ricercato per Autore" + ricercaPerAutore);
	    
	}
	
	public static String removeElement(String ISBN) {
		Optional<Catalogo> s =  catalogo.stream()
				.filter(c -> c.getCodiceISBN().equals(ISBN))
				.findFirst();
		if(s.isPresent()) {
			Catalogo removedEl = s.get();
			catalogo.remove(removedEl);
			return removedEl.toString();
		}else {
			return null;
		}
		
	}
	
	public static List<Catalogo> findByIsbn(String ISBN) {
		return catalogo.stream().filter(e -> e.getCodiceISBN().equals(ISBN)).collect(Collectors.toList());
	}
	
	public static List<Catalogo> findByPubYear(int year) {
		return catalogo.stream().filter(e -> e.getAnnoPublicazione() == (year)).collect(Collectors.toList());
	}
	
	public static List<Catalogo> findByAuthor(String autore) {
		return catalogo.stream().filter(e -> e instanceof Libro && ((Libro)e).getAutore().equals(autore)).collect(Collectors.toList());
	}
	
	public static void scriviSuFile() throws IOException {
		FileUtils.writeStringToFile(file, catalogo.toString(), "UTF-8", true);
		System.out.println("Testo scritto su file");
	}


}
