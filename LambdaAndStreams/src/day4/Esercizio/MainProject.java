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
		
		
		Order o1 = new Order(0, null, null, null, null, null);
		o1.setId(1);
		o1.setStatus("Consegnato");
		o1.setOrderDate(1, 1, 2021);
		o1.setDeliveryDate(6, 4, 2021);
		o1.setProducts(filtraPrezzo(prodotti, "Baby"));
		o1.setCustomer(new Customer(1, "Emma Stone", 2));
		
		ordini.add(o1);
		
		System.out.println("--- Esercizio 2 ---");
		ordini.forEach(o -> System.out.println(o));
		
		
		//Esercizio #3
		prodotti.add(new Product(2909931, "Play Station 5", "Boys", 650));
		prodotti.add(new Product(2909932, "Shootgun", "Boys", 200));
		prodotti.add(new Product(2909933, "Beer", "Boys", 10));
		prodotti.add(new Product(2909934, "Snacks", "Boys", 5));
		prodotti.add(new Product(2909935, "More beer", "Boys", 20));
		
		List<Product> prodBoysScontati = applicaSconto(prodotti, "Boys");
		System.out.println("--- Esercizio 3 ---");
		prodBoysScontati.forEach(p -> System.out.println(p));
		
		
		List<Product> tier2Products = getProdottiTier(2, LocalDate.of(2021, 1, 1),LocalDate.of(2021, 4, 6) );
		tier2Products.forEach(p -> System.out.println(p));
	}
	
	
	//Esercizio #1
	public static List<Product> filtraPrezzo(List<Product> prodotti, String categoria){
		
		return prodotti.stream().filter(p -> p.getPrice() > 100).filter(p -> p.getCategory().equals(categoria)).collect(Collectors.toList());
		
	}
	
	//Esercizio #3
	public static List<Product> applicaSconto(List<Product> prodotti, String categoria) {
	    return prodotti.stream()
	            .filter(p -> p.getCategory().equals(categoria))
	            .map(p -> {
	                p.setPrice(p.getPrice() - (p.getPrice() * 10) / 100);
	                return p;
	            })
	            .collect(Collectors.toList());
	}
	
	//Esercizio #4
	public static List<Product> getProdottiTier(int tier, LocalDate start, LocalDate end){
		
		return ordini.stream()
				.filter(o -> o.getCustomer().getTier() == tier)
				.filter(c -> c.getOrderDate().compareTo(start) >= 0)
				.filter(d -> d.getDeliveryDate().compareTo(end) <= 0)
				.flatMap(x -> x.getProducts().stream())
				.collect(Collectors.toList());
		
	}

}



