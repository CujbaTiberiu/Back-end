package w2.esercizio.d1;

import java.util.Arrays;
import java.util.Scanner;

public class MainProject {

	//Esercizio #1
	static Scanner  sc = new Scanner(System.in);
	
	static int[] arrNumCas = new int[5];
	
	
	public static void main(String[] args) throws MyExcpetion {
		try {
			aggiungiArr();
			aggiornaArr();
		} catch (MyExcpetion e) {
			System.out.println(e.getMessage().toString());
		}catch(NumberFormatException e) {
			System.out.println("Formatto non accettato, inserire numeri!");
			aggiungiArr();
		}
		
		//Esercizio #2
		mediaConsumo();	
		}
	//Esercizio #1
	public static void aggiungiArr() throws MyExcpetion {
		
			System.out.println("Inserisci il primo numero: ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.println("Inserisci il secondo numero: ");
			int num2 = Integer.parseInt(sc.nextLine());
			System.out.println("Inserisci il terzo numero: ");
			int num3 = Integer.parseInt(sc.nextLine());
			System.out.println("Inserisci il quarto numero: ");
			int num4 = Integer.parseInt(sc.nextLine());
			System.out.println("Inserisci il quinto numero: ");
			int num5 = Integer.parseInt(sc.nextLine());
			if (num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0 || num5 == 0) {
		        throw new MyExcpetion("Operazione terminata!");
		    }else
		    arrNumCas = new int[] {num1, num2, num3, num4, num5};
		    System.out.println("Array attuale: " + Arrays.toString(arrNumCas));
	}
	
	
	public static void aggiornaArr(){
		
		for(int i = 0; i < arrNumCas.length; i++) {
			int num = Integer.parseInt(sc.nextLine());
			if( num != 0){
				try {
					System.out.println("Inserisci un numero per cambiare il numero alla posizione " + i);
					arrNumCas[i] = num;
				}catch (ArithmeticException  e){
				System.out.println(e.getMessage().toString());
			}
		}
		System.out.println("Array attuale: " + Arrays.toString(arrNumCas));
	}
	}
	
	
	
	
	//Esercizio #2
	
	public static void mediaConsumo(){
			System.out.println("Inserisci i km percorsi: ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.println("Inserisci la quantità di carburante consumata: ");
			int num2 = Integer.parseInt(sc.nextLine());
			try {
				System.out.println("Media km/lt carburante: " + (num1/num2) + "km con 1 litro");
				
			} catch (ArithmeticException e) {
				System.out.println("Non può essere divisibile per '0'");
			}
			
	
	}
	}
	
