package epicode.cicli;

import java.util.Arrays;
import java.util.Scanner;

public class CicliEsercizi {

	public static void main(String[] args) {
		
		//Esercizio #1
		System.out.println("Esercizo 1 ->");
		System.out.println("----------------");
		
	stringaPariDispari("hi");
	stringaPariDispari("hey");
	 System.out.println("----------------");
	annoBisestile(2000);
	annoBisestile(2023);
	
	//Esercizio #2
	System.out.println("Esercizo 2 ->");
	System.out.println("----------------");
	stampaInLettere(0);
	stampaInLettere(4);
	
	Scanner  sc = new Scanner(System.in);
	System.out.print("Insert a number between 0 and 3 included:");
	int numero = sc.nextInt();
	stampaInLettere(numero);
	
	//Esercizio #3
	System.out.println("Esercizo 3 ->");
	System.out.println("----------------");
	System.out.print("Insert a letter or word:");
	sc.nextLine();
	String str1 = sc.nextLine();
	untilReachQ(str1);
	
	
	//Esercizio #4
	System.out.println("Esercizo 4 ->");
	System.out.println("----------------");
	System.out.print("Insert a number:");
	int numb1 = sc.nextInt();
	countBackwards(numb1);
	
	}
	//Esercizio #1
	public static void  stringaPariDispari(String str) {
		if(str.length() % 2 == 0) {
			 System.out.println(true);
		} else  System.out.println(false);
	}
	
	public static void annoBisestile(int anno) {
		if(anno % 4 == 0) {
			if(anno % 100 == 0) {
				if(anno % 400 == 0) {
					System.out.println(true);
				}
			}
		}else System.out.println(false);
	}
	
	//Esercizio #2
	public static void stampaInLettere(int numero) {
		switch(numero) {
		case 0: System.out.println("zero");break;
		case 1: System.out.println("uno");break;
		case 2: System.out.println("due");break;
		case 3: System.out.println("tre");break;
		default: System.out.println("Not a valid number! Insert a number between 0 and 3 included :)");
		}
	}
	
	//Esercizio #3
	public static void untilReachQ(String str) {
		int i = 0;
		char[] charArr = str.toCharArray();
		String arrStr = Arrays.toString(charArr);
		while (charArr[i] != 'q'){
			System.out.println(arrStr);
			i++;
		};
		
	}
	
	//Esercizio #4
	public static void countBackwards(int numero) {
		for(int i = numero; i >= 0; i--) {
			System.out.println(i);
		}
	}

}
