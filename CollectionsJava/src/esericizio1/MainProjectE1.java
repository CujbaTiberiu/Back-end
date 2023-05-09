package esericizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MainProjectE1 {
	
	static Scanner sc = new Scanner(System.in);
	static Logger log = LoggerFactory.getLogger(MainProjectE1.class);

	public static void main(String[] args) {
		
		insertNumber();

	}
	
	public static void insertNumber() {
		boolean continua = true;
		Set<String> arrStr = new HashSet<String>();
		Set<String> duplicates = new HashSet<String>();
		do {
			
		System.out.println("Inserisci un numero di parole da inserire oppure '0' per terminare: ");
		int quanteVolte = Integer.parseInt(sc.nextLine());
		if(quanteVolte == 0) {
			//log.error("0 - non valido!");
			continua = false;
		}else {
			for(int i = 0; i < quanteVolte; i++) {
				System.out.println("Inserisci una parola " + (i+1) + " : ");
				String str = sc.nextLine();
				if(!arrStr.add(str)) {
					duplicates.add(str);
				}
			}
		}
		
		duplicates.forEach(e -> System.out.println("Duplicati: " + e));
		int size = arrStr.size();
		System.out.println("Numero parole: " + size);
		System.out.println("Elenco parole: ");
		arrStr.forEach(e ->  System.out.println(" - " + e));
		} while(continua);
	}
	
	
	

}
