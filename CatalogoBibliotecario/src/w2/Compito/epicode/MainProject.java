package w2.Compito.epicode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainProject {
	
	static public Logger log = LoggerFactory.getLogger(MainProject.class);
	private static String path = "CatalogoBiblioteca/cat.txt";
	private static File file = new File(path);
	static List<Catalogo> catalogo = new ArrayList<Catalogo>();
	static List<Catalogo> catalogoFile = new ArrayList<Catalogo>();

	public static void main(String[] args) {
		
		//log.info("--- Elementi aggiunti ---");
		catalogo.add(new Libro("1L", "Il trono di spade", 2015, 400,"George R.R. Martin" ,"Fantasy"));
		catalogo.add(new Libro("2L", "Arte della guerra", 100, 600,"Sun Tzu" ,"Non-Fiction"));
		catalogo.add(new Libro("3L", "Il signore degli Anelli", 2015, 400,"J. R. R. Tolkien" ,"Fantasy"));
		catalogo.add(new Libro("4L", "Programmazione di base e avanzata con Java", 2018, 300,"Pearson" ,"Manuale"));
		
		catalogo.add(new Rivista("1R", "GamingNow", 2010, 60, Periodicità.SETTIMANALE));
		catalogo.add(new Rivista("2R", "TechnologyTomorrow", 2002, 100, Periodicità.MENSILE));
		catalogo.add(new Rivista("3R", "MotorShow", 2006, 150, Periodicità.SEMESTRALE));
		
		  log.info("--- Elenco catalogo ---");
	    catalogo.forEach(e -> System.out.println(e));
	    
	    log.info("--- Rimozione di un elemento ---");
	    log.info("Elemento rimosso" + removeElement("3L"));
	    
	    log.info("--- Elenco catalogo ---");
	    catalogo.forEach(e -> System.out.println(e));
	    
	    log.info("--- Ricerca di un elemento per ISBN ---");
	    log.info("Elemento ricercato per codice ISBN -> " +  findByIsbn("3R"));
	    
	    log.info("--- Ricerca di un elemento per Anno pubblicazione ---");
	    log.info("Elemento ricercato per anno pubblicazione -> " +  findByPubYear(2015));
	    
	    log.info("--- Ricerca di un elemento per Autore ---");
	    log.info("Elemento ricercato per Autore -> " + findByAuthor("Sun Tzu"));
	    
	    try {
	    	log.info("*** Scrivi su File ***");
	    	writeToFile();
	    	log.info("*** Scritto su File! ***");
	    	log.info("*** Leggi da File ***");
	    	readFromFile();
	    	catalogoFile.forEach(e -> System.out.println(e));
	    	log.info("*** fine lettura da File ***");
		} catch (IOException e1) {
			log.info("Scritto su file!");
			e1.printStackTrace();
		}
	    
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
	
	public static String findByIsbn(String ISBN) {
		List<Catalogo> ricercaPerIsbn = catalogo.stream().filter(e -> e.getCodiceISBN().equals(ISBN)).collect(Collectors.toList());
		String ricerca = ricercaPerIsbn.toString();
		return ricerca;
	}
	
	public static String findByPubYear(int year) {
		List<Catalogo> ricercaPerAnnoPub = catalogo.stream().filter(e -> e.getAnnoPublicazione() == (year)).collect(Collectors.toList());
		String ricerca = ricercaPerAnnoPub.toString();
		return ricerca;
	}
	
	public static String findByAuthor(String autore) {
		List<Catalogo> ricercaPerAutore = catalogo.stream().filter(e -> e instanceof Libro && ((Libro)e).getAutore().equals(autore)).collect(Collectors.toList());
		String ricerca = ricercaPerAutore.toString();
		return ricerca;
	}
	
	public static void writeToFile() throws IOException {
		StringBuilder sb = new StringBuilder();
	    catalogo.forEach(e -> sb.append(e.toFileString()).append("@"));
		FileUtils.writeStringToFile(file, sb.toString(), "UTF-8", true);
		
	}
	
	public static void readFromFile() throws IOException{
		String cat = FileUtils.readFileToString(file, "UTF-8");
		String[] arr = cat.split("@");
		for (int i = 0; i < arr.length; i++) {
			String[] el = arr[i].split("#");
			if (el[0].substring(1).equals("L")) {
	            Catalogo e = new Libro(el[0], el[1], Integer.parseInt(el[2]), Integer.parseInt(el[3]), el[4], el[5]);
	            catalogoFile.add(e);
	        } else if(el[0].substring(1).equals("R")){
	            Catalogo e = new Rivista(el[0], el[1], Integer.parseInt(el[2]), Integer.parseInt(el[3]), Periodicità.valueOf(el[4]));
	            catalogoFile.add(e);
			}
		}
	}

}
