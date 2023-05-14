package w2.Compito.epicode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainProject {
	
	public static Logger log = LoggerFactory.getLogger(MainProject.class);
	private static String path = "CatalogoBiblioteca/cat.txt";
	private static File file = new File(path);
	private static Scanner sc = new Scanner(System.in);
	
	
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
		
		
		Opzioni();

	}
	
	public static void addRivista() {
		boolean continueSearch = true;
		do {
		System.out.println("Inserisci un codice ISBN valido -> es. '1R':");
		String inputIsbn = sc.nextLine();
		while(inputIsbn == null || !isValidRivistaIsbn(inputIsbn)){
		    inputIsbn = sc.nextLine();
		    System.out.println("Non valido!");
		  
		}
		    
		 System.out.println("Inserisci un titolo: ");
		 String inputTitolo = sc.nextLine();
		 while(inputTitolo == null || inputTitolo.trim().isEmpty()) {
			 System.out.println("Inserisci almeno un carattere: ");
		     inputTitolo = sc.nextLine();
		 }
		
		 System.out.println("Inserisci l'anno di pubblicazione: ");
		 int inputAnnoPub = 0;
		 while (inputAnnoPub <= 0) {
		 try {
			 
		     inputAnnoPub += Integer.parseInt(sc.nextLine());
		     
		 } catch (NumberFormatException e) {
		     System.out.println("Input non valido. Inserisci un numero valido per l'anno di pubblicazione.");
		     
		 }

		 }
		
		 System.out.println("Inserisci il numero di pagine: ");
		 int inputPagine = 0;
		
			 while(inputPagine <= 0) {
		 try {
			 
			 inputPagine += Integer.parseInt(sc.nextLine());
		     
			 } catch (NumberFormatException e) {
			     System.out.println("Input non valido. Inserisci un numero valido per il numero delle pagine.");
			     
			 }

		 }
		
		 System.out.println("Inserisci la periodicità tra Settimanale, Mensile e Semestrale: ");
		 Periodicità inputPeriodicità = Periodicità.valueOf(sc.nextLine().toUpperCase());
		 while (inputPeriodicità == null) {
			 try {
			    System.out.println("Inserisci la periodicità tra Settimanale, Mensile e Semestrale: ");
			    inputPeriodicità = Periodicità.valueOf(sc.nextLine().toUpperCase());
			    } catch (Exception e) {
			        System.out.println("Periodicità non valida. Inserisci una periodicità valida tra Settimanale, Mensile e Semestrale.");
			    }
			}
		 
		 Rivista r = new Rivista(inputIsbn, inputTitolo, inputAnnoPub, inputPagine, inputPeriodicità);
		 catalogo.add(r);
		 System.out.println("Rivista aggiunta con successo: " + r.toString());
		 
		 System.out.println("Vuoi aggiungere un'altra Rivista? (S/N)");
	        String scelta = sc.nextLine().trim().toLowerCase();

	        if (scelta.equals("n")) {
	        	continueSearch = false;
	            Opzioni();
	        }
		}while(continueSearch);
	}
	
	public static void addLibro() {
		boolean continueSearch = true;
		do {
		System.out.println("Inserisci un codice ISBN valido -> es. '1L':");
		String inputIsbn = sc.nextLine();
		while(inputIsbn == null || !isValidLibroIsbn(inputIsbn)){
		    inputIsbn = sc.nextLine();
		    System.out.println("Non valido!");
		  
		}
		    
		 System.out.println("Inserisci un titolo: ");
		 String inputTitolo = sc.nextLine();
		 while(inputTitolo == null || inputTitolo.trim().isEmpty()) {
			 System.out.println("Inserisci almeno un carattere: ");
		     inputTitolo = sc.nextLine();
		 }
		
		 System.out.println("Inserisci l'anno di pubblicazione: ");
		int inputAnnoPub = 0;
		 while(inputAnnoPub <= 0) {
			 try {
			 inputAnnoPub += Integer.parseInt(sc.nextLine());
			 } catch (NumberFormatException e) {
			     System.out.println("Input non valido. Inserisci un numero valido per l'anno di pubblicazione.");
			     
			 }
		 }
		
		 System.out.println("Inserisci il numero di pagine: ");
		 int inputPagine = 0;
		 while(inputPagine <= 0) {
			 try {
			
			 inputPagine = Integer.parseInt(sc.nextLine());
			 } catch (NumberFormatException e) {
			     System.out.println("Input non valido. Inserisci un numero valido per numero pagine.");
			     
			 }
		 }
		 
		 System.out.println("Inserisci un autore: ");
		 String inputAutore = sc.nextLine();
		 while(inputAutore == null || inputAutore.trim().isEmpty()) {
			 System.out.println("Inserisci almeno un carattere: ");
			 inputAutore = sc.nextLine();
		 }
		 
		 System.out.println("Inserisci un genere: ");
		 String inputGenere = sc.nextLine();
		 while(inputGenere == null || inputGenere.trim().isEmpty()) {
			 System.out.println("Inserisci almeno un carattere: ");
			 inputGenere = sc.nextLine();
		 }
		
		 
		 Libro r = new Libro(inputIsbn, inputTitolo, inputAnnoPub, inputPagine, inputAutore, inputGenere);
		 catalogo.add(r);
		 System.out.println("Libro aggiunta con successo: " + r.toString());
		 
		 System.out.println("Vuoi aggiungere un altro Libro? (S/N)");
	        String scelta = sc.nextLine().trim().toLowerCase();

	        if (scelta.equals("n")) {
	        	continueSearch = false;
	            Opzioni();
	        }
		}while(continueSearch);
	}	
	
	public static void removeElement() throws Exception {
	    boolean continueSearch = true;

	    while (continueSearch) {
	        System.out.println("Inserisci un codice ISBN valido -> es. '1R' - per le Riviste oppure '1L' per i Libri");
	        String in = sc.next();

	        if (isValidIsbn(in)) {
	            Optional<Catalogo> s = catalogo.stream()
	                    .filter(c -> c.getCodiceISBN().equals(in))
	                    .findFirst();

	            if (s.isPresent()) {
	                Catalogo removedEl = s.get();
	                catalogo.remove(removedEl);
	                System.out.println("Elemento rimosso con successo! -> " + removedEl.toString());
	                System.out.println("Vuoi continuare a rimuovere elementi? (S/N)");
	                String scelta = sc.next().trim().toLowerCase();
		     	       if (scelta.equals("n")) {
		   	            continueSearch = false;
		   	            Opzioni();
		   	        }
	            } else {
	            	System.out.println("Elemento da rimuovere non presente nel Catalogo!");
	            	 System.out.println("Vuoi continuare a rimuovere elementi? (S/N)");
	     	        String scelta = sc.next().trim().toLowerCase();
	     	       if (scelta.equals("n")) {
	   	            continueSearch = false;
	   	            Opzioni();
	   	        }
	            }
	        } else {
	            System.out.println("ISBN non valido! Inserisci un ISBN valido.");
	        }

	    }
	}

	private static boolean isValidIsbn(String input) {
	    return input.matches("\\d+[LR]");
	}
	
	private static boolean isValidRivistaIsbn(String input) {
		return input.matches("\\d+[R]");
	}
	
	private static boolean isValidLibroIsbn(String input) {
		return input.matches("\\d+[L]");
	}
	
	public static void findByIsbn() throws Exception {
	    boolean validIsbn = false;
	    boolean continueSearch = true;
	    
	    do {
	        System.out.println("Inserisci un codice ISBN valido -> es. '1R' - per le Riviste oppure '1L' per i Libri");
	        String input = sc.next();
	        
	        if (isValidIsbn(input)) {
	            validIsbn = true;
	            List<Catalogo> ricercaPerIsbn = catalogo.stream()
			            .filter(e -> e.getCodiceISBN().equals(input))
			            .collect(Collectors.toList());
	            String ricerca = ricercaPerIsbn.toString();
	    	    System.out.println("Elemento ricercato per codice ISBN -> " + ricerca);
	        } else {
	            throw new Exception("ISBN non valido!");
	        }
	        
	        System.out.println("Vuoi continuare la ricerca? (S/N)");
	        String scelta = sc.nextLine().trim().toLowerCase();

	        if (scelta.equals("n")) {
	        	continueSearch = false;
	            Opzioni();
	        }
	    } while (continueSearch);
	    
	}

	
	public static void findByPubYear() throws Exception {
	    boolean continueSearch = true;

	    do {
	        System.out.println("Inserisci un anno per fare la ricerca: ");
	        
	        String input = sc.next();
	        try {
	            
	            int year = Integer.parseInt(input);
	            List<Catalogo> ricercaPerAnnoPub = catalogo.stream()
	                    .filter(e -> e.getAnnoPublicazione() == year)
	                    .collect(Collectors.toList());

	            if (ricercaPerAnnoPub.isEmpty()) {
	                System.out.println("Nessun elemento trovato per l'anno di pubblicazione " + year);
	            } else {
	                String ricerca = ricercaPerAnnoPub.toString();
	                System.out.println("Elementi trovati per l'anno di pubblicazione " + year + ": " + ricerca);
	            }

	         
	        } catch (NumberFormatException e) {
	            System.out.println("Inserisci un anno valido!");
	            input = sc.nextLine();
	        }
	        
	        System.out.println("Vuoi continuare la ricerca? (S/N)");
	        String scelta = sc.nextLine().trim().toLowerCase();
	        if(scelta.equals("s")){
		        continueSearch = true;
	        }
	        
	        
	       if (scelta.equals("n")) {
	           continueSearch = false;
	           Opzioni();
	       }

	    } while (continueSearch);
	}

	
	public static void findByAuthor() throws Exception {
		boolean continueSearch = true;
		do {
			System.out.println("Inserisci un autore per fare la ricerca oppure no per tornare al menu: ");
	        String input = sc.next().toLowerCase();

	        if (input.trim().toLowerCase().equals("no")) {
	            continueSearch = false;
	            Opzioni();
	        }
			
         List<Catalogo> ricercaPerAutore = catalogo.stream()
        		 .filter(e -> e instanceof Libro && ((Libro)e).getAutore().toLowerCase().contains(input))
        		 .collect(Collectors.toList());
		
		 if(ricercaPerAutore.isEmpty()) {
			 System.out.println("Nessun elemento trovato con l'autore inserito " + input);
		 }else {
			 String ricerca = ricercaPerAutore.toString();
			 System.out.println("Libri trovati con l'autore " + input + ": " + ricerca);
		 }
		 
		}while(continueSearch);
		
		
	}
	
	public static void writeToFile() throws Exception {
		System.out.println("Scrivi ok per salvare dati su File oppure abort per tornare al menu: ");
		String input = sc.next().toLowerCase();
		if(input.equals("ok")) {
			StringBuilder sb = new StringBuilder();
		    catalogo.forEach(e -> sb.append(e.toFileString()).append("@"));
			FileUtils.writeStringToFile(file, sb.toString(), "UTF-8", true);
			System.out.println("Salvato con successo!");
			TimeUnit.SECONDS.sleep(2);
			Opzioni();
		}else if(input.equals("abort")){
			Opzioni();
		}else {
			throw new Exception("Non valido! ok per salvare oppure abort per menu!");
		}
		
		
	}
	
	public static void readFromFile() throws Exception{
		System.out.println("Scrivi import per vedere i dati da File oppure abort per tornare al menu: ");
		String input = sc.next().toLowerCase();
		if(input.equals("import")) {
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
			System.out.println("I dati presenti sul File:  ");
			catalogoFile.forEach(e -> System.out.println(e));
			System.out.println("Fine");
			System.out.println("Scrivi menu per tornare al menu pricipale!");
			String input1 = sc.next().toLowerCase();
			if(input1.equals("menu")) {
				Opzioni();
			}else {
				System.out.println("Scrivi menu per tornare al menu pricipale!");
			}
		}else if(input.equals("abort")) {
			Opzioni();
		}else {
			throw new Exception("Non valido! import per vedere i dati oppure abort per menu!");
		}
		
	}
	
	public static void showCatalogo() {
		System.out.println("Catalogo attuale ->");
		 catalogo.forEach(e -> System.out.println(e));
		 System.out.println("Fine catalogo!");
		 Opzioni();
	}
	

	public static void Opzioni() {
	
			System.out.println("Bentornato!");
			System.out.println("--- Opzioni Aggiungi/Rimuovi ---");
			System.out.println("[1] Aggiungi una Rivista");
			System.out.println("[2] Aggiungi una Libro");
			System.out.println("[3] Rimuovi un Libro oppure una Rivista");
			System.out.println("--- Opzioni Ricerca ---");
			System.out.println("[4] Ricerca un Libro oppure una Rivista con il codice ISBN");
			System.out.println("[5] Ricerca l'anno di publicazione di un Libro oppure di una Rivista");
			System.out.println("[6] Ricerca un Libro con il nome dell'autore");
			System.out.println("--- Opzioni Scrittura/Lettura  ---");
			System.out.println("[7] Scrivi intero catalogo su File");
			System.out.println("[8] Leggi intero catalogo da File");
			System.out.println("[9] Leggi catalogo attuale");
					
			int scelta = sc.nextInt();
		try {	
		switch(scelta) {
		case 1: addRivista();break;
		case 2: addLibro();break;
		case 3: removeElement();break;
		case 4: findByIsbn();break;
		case 5: findByPubYear();break;
		case 6: findByAuthor();break;
		case 7: writeToFile();break;
		case 8: readFromFile();break;
		case 9: showCatalogo();break;
		default: System.out.println("Inserisci un numero tra 1 e 9 inclusi per accedere alle funzionalità del menu!"); Opzioni();
		}
		}catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
}
	
	


