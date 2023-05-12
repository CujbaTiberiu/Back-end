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
		
		catalogo.add(new Libro("1L", "Il trono di spade", 2015, 400,"George R.R. Martin" ,"Fantasy"));
		catalogo.add(new Libro("2L", "Arte della guerra", 100, 600,"Sun Tzu" ,"Non-Fiction"));
		catalogo.add(new Libro("3L", "Il signore degli Anelli", 2015, 400,"J. R. R. Tolkien" ,"Fantasy"));
		
		catalogo.add(new Rivista("1R", "GamingNow", 2010, 60, Periodicità.SETTIMANALE));
		catalogo.add(new Rivista("2R", "TechnologyTomorrow", 2002, 100, Periodicità.MENSILE));
		catalogo.add(new Rivista("3R", "MotorShow", 2006, 150, Periodicità.SEMESTRALE));
		
	    catalogo.forEach(e -> System.out.println(e));
	    //try {
			//scriviSuFile();
		//} catch (IOException e1) {
			//log.info("Scritto su file!");
			//e1.printStackTrace();
		//}
	    String elementoRimosso = removeElement("3L");
	    System.out.println("Elemento rimosso" + elementoRimosso);
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
	
	public static void scriviSuFile() throws IOException {
		FileUtils.writeStringToFile(file, catalogo.toString(), "UTF-8", true);
		System.out.println("Testo scritto su file");
	}


}
