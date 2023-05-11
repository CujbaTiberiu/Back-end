package day4.Esercizio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {
	
	static List<Product> prodotti = new ArrayList<Product>();
	static List<Order> ordini = new ArrayList<Order>();

	public static void main(String[] args) {
		

		
		//Esercizio #1
		
		prodotti.add(new Product(2651486, "Trono di Spade", "Books", 23));
		prodotti.add(new Product(2662286, "Il Signore degli Anelli", "Books", 40));
		prodotti.add(new Product(2650021, "Arte della guerra", "Books", 36));
		prodotti.add(new Product(2651478, "La vita di Chuck Norris", "Books", 200));
		prodotti.add(new Product(2650102, "Come diventare ricco? boh.", "Books", 150));
		
		List<Product> booksOverOneHundred = filtraPrezzo(prodotti, "Books");
		System.out.println("--- Esercizio 1 ---");
		booksOverOneHundred.forEach(p -> System.out.println(p));
		
		//Esercizio #2
		
		prodotti.add(new Product(2703332, "Culla", "Baby", 600));
		prodotti.add(new Product(2703320, "Seggiolone", "Baby", 100));
		prodotti.add(new Product(2703321, "Passeggino", "Baby", 900));
		prodotti.add(new Product(2703331, "Triciclo", "Baby", 250));
		
		
		ordini.add(new Order(1, "In preparazione", null, filtraPrezzo(prodotti, "Baby"), new Customer(1, "Emma Stone", 2)));
		System.out.println("--- Esercizio 2 ---");
		ordini.forEach(o -> System.out.println(o));
		
		
		
	}
	//Esercizio #1
	public static List<Product> filtraPrezzo(List<Product> prodotti, String categoria){
		
		return prodotti.stream().filter(p -> p.getPrice() > 100).filter(p -> p.getCategory().equals(categoria)).collect(Collectors.toList());
		
	}
	
	//Esercizio #2
	

}
