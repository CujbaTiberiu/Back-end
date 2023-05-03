package it.epicode.be;

import java.util.Arrays;
import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		int n1 = 5;
		int n2 = 5;
		int numbMolt = moltiplica(n1, n2);
		System.out.println(numbMolt);
		
		concatena("tizio", 20);
		inserisciInArray(arr,"sei");
		perimetroRettangolo(5.3,10.6);
		pariDispari(7);
		perimetroTriangolo(15,12);
		areaTriangolo(2,5,6);

		//Esercizio #3
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci qualcosa uno:");
		String stringaUno = sc.nextLine();
		System.out.print("Inserisci qualcosa due:");
		String stringaDue = sc.nextLine();
		System.out.print("Inserisci qualcosa tre:");
		String stringaTre = sc.nextLine();
		System.out.println(stringaUno + ' ' + stringaDue + ' ' + stringaTre);
		System.out.println(stringaTre + ' ' + stringaDue + ' ' + stringaUno);
		}
		/*logica es.->
		 * 	Scanner sc = new Scanner(System.in);
			String[] arrStr = new String[3];
			int i = 0;
		 * while(i < arrStr.length) {
		 * System.out.print("Inserisci qualcosa uno:");
		   String stringaUno = sc.nextLine();
		   arrStr[i] = s1;
		  i++;
		 * 
		 * }
		 * }
		 * stampaStringhe(arrStr);
		}*/

//Esercizio #2
public static int moltiplica (int n1, int n2) {
	 return (n1 * n2);
}

public static void concatena (String name, int number) {
	 System.out.println(name + " is " + number + " years old");
}

static String arr[] = {"uno","due","tre","quattro","cinque"};



public static void inserisciInArray(String arr[], String n) {
	String newArr[] = {arr[0], arr[1], n, arr[2], arr[3], arr[4]};
	System.out.println(Arrays.toString(newArr));
	//omeglio
	//for(int i = 0; i < newArr.length; i++){
	//System.out.println(i + ':' + newArr[i]);
//}
}


//Esercizio #4
public static void perimetroRettangolo(double l1, double l2) {
	System.out.println((l1 + l2)* 2);
}


public static void pariDispari(int number) {
	System.out.println((number % 2));
	
}

public static void perimetroTriangolo(double base, double altezza) {
	System.out.println((base * altezza)/2);
	
}

public static void areaTriangolo(double latoA, double latoB, double latoC) {
        double semiPerimetro = (latoA + latoB + latoC) / 2;
        double area = Math.sqrt(semiPerimetro * (semiPerimetro - latoA) * (semiPerimetro - latoB) * (semiPerimetro - latoC));
        System.out.println("Area Triangolo: " + area);
    
}

}





