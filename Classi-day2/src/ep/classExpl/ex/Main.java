package ep.classExpl.ex;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Esercizio #1
		
		Rettangolo rett1 = new Rettangolo(5,10);
		stampaRettangolo(rett1);
		Rettangolo rett2 = new Rettangolo(6,12);
		Rettangolo rett3 = new Rettangolo(10,25);
		stampaDueRettangoli(rett2,rett3);
		
		//Esercizio End #1
	
		//Esercizio #2
		
		CartaSim sim1 = new CartaSim(324555666, 5,new CartaSim.Chiamata[5]);
		sim1.ultimeCinqueChiamate[0] = new CartaSim.Chiamata(659321659, 2);
		sim1.ultimeCinqueChiamate[1] = new CartaSim.Chiamata(318144700, 0);
		sim1.ultimeCinqueChiamate[2] = new CartaSim.Chiamata(325896314, 3);
		sim1.ultimeCinqueChiamate[3] = new CartaSim.Chiamata(325978465, 1);
		sim1.ultimeCinqueChiamate[4] = new CartaSim.Chiamata(326594841, 10);
		sim1.printDataSim();
		
		//Esercizio End #2
		

		//Esercizio #3
		Cliente cli1 = new Cliente("1C", "Mario", "Rossi", "mario.rossi@gmail.com", "03/05/2023");
		Articolo a1 = new Articolo("1A", "brick esta-thè pesca", 2, 200);
		Articolo a2 = new Articolo("2A", "brick esta-thè limone", 1.5, 100);
		Articolo a3 = new Articolo("3A", "brick esta-thè thè-verde", 1.8, 50);
		
		Carrello carrello1 = new Carrello(new Cliente[]{cli1},new Articolo[]{a1, a2, a3});
		carrello1.totCarrello();
		//Esercizio End #3
	}
	//Esercizio #1
	public static void stampaRettangolo(Rettangolo rettangolo) {
		int area = rettangolo.printArea();
		int perimetro = rettangolo.printPerimetro();
		System.out.println("The area is -> "+area + ' ' + "The perimeter is -> "+perimetro);
	}
	
	public static void stampaDueRettangoli(Rettangolo rettangolo1, Rettangolo rettangolo2) {
		int area1 = rettangolo1.printArea();
		int perimetro1 = rettangolo1.printPerimetro();
		int area2 = rettangolo2.printArea();
		int perimetro2 = rettangolo2.printPerimetro();
		System.out.println("The area is -> "+area1 + ' ' + "The perimeter is -> "+perimetro1);
		System.out.println("The area is -> "+area2 + ' ' + "The perimeter is -> "+perimetro2);
		System.out.println("The total area is -> "+ (area1 + area2) + ' ' + "The total perimeter is -> "+ (perimetro1 + perimetro2));
		
	}
	//Esercizio End #1
	
}
