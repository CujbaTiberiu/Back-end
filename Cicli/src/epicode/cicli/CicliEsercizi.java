package epicode.cicli;

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
	
	/*//Esercizio #3
	System.out.println("Esercizo 3 ->");
	System.out.println("----------------");
	System.out.print("Insert a letter or word:");
	sc.nextLine();
	String str1 = sc.nextLine();*/
	untilReachQ();
	
	
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
			System.out.println(true);
		}else if(anno % 100 == 0 && anno % 400 == 0) {
					System.out.println(true);
			}
		else System.out.println(false);
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
	/*public static void untilReachQ(String str) {
		int i = 0;
		char[] charArr = str.toCharArray();
	    String arrStr = Arrays.toString(charArr);
		do {
			System.out.println(arrStr);
			i++;
		}while (i < charArr.length && charArr[i] != 'q');
		
	}
	*/
	public static void untilReachQ() {
		Scanner sc = new Scanner(System.in);
		 String str;
		 while (true) {
	            System.out.print("Insert a string :q to exit: ");
	            str = sc.nextLine();

	            if (str.equals(":q")) {
	                break;
	            }
	            for (int i = 0; i < str.length(); i++) {
	                System.out.print(str.charAt(i));
	                if (i != str.length() - 1) {
	                    System.out.print(", ");
	                }
	            }

	            System.out.println();
	        }
	      
	}
	
	//Esercizio #4
	public static void countBackwards(int numero) {
		for(int i = numero; i >= 0; i--) {
			System.out.println(i);
		}
	}

}
