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
		Set<String> arrStr = new HashSet<String>();
		Set<String> duplicates = new HashSet<String>();
		System.out.println("Inserisci un numero: ");
		int quanteVolte = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < quanteVolte; i++) {
			System.out.println("Inserisci una parola " + (i+1) + " : ");
			String str = sc.nextLine();
			if(!arrStr.add(str)) {
				duplicates.add(str);
			}
		}
		duplicates.forEach(e -> log.info("Duplicati: " + e));
		int size = arrStr.size();
		log.info("Numero parole: " + size);
		arrStr.forEach(e -> log.info("Array: " + e));
		
	}
	
	
	

}
