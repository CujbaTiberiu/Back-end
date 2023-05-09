package esercizio2;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import esericizio1.MainProjectE1;

public class MainProjectE2 {
	
	static Scanner sc = new Scanner(System.in);
	static Logger log = LoggerFactory.getLogger(MainProjectE1.class);
	static List<Integer> arrNumCas = new ArrayList<Integer>();

	public static void main(String[] args) {
		numCas(5);
		arrNumCas.forEach(e -> log.info(e.toString()));
		
		doubleReverseArr(arrNumCas);
		
		stampaPariDispari(arrNumCas, true);
		stampaPariDispari(arrNumCas, false);
	}
	
	public static void numCas(int num) {
		 Random random = new Random();
		for(int i = 0; i < num; i++) {
			int randomNumber = random.nextInt(101);
			arrNumCas.add(randomNumber);
		}
	}
	
	public static void doubleReverseArr(List<Integer> arr) {
		 List<Integer> listToReverse = new ArrayList<>(arr);
		 Collections.reverse(listToReverse);
		 List<Integer> totalList = new ArrayList<>();
		 totalList.addAll(arr);
		 totalList.addAll(listToReverse);
		 System.out.println("Combined list: " + totalList);
	}
	
	public static void stampaPariDispari(List<Integer> arr, boolean b) {
			if(b) {//si poteva usare il ternary - ?
				for(int i = 0; i < arr.size(); i += 2) {
					int val = arr.get(i);
					 System.out.println("Valore a indice pari " + i + ": " + val);
				}
			}else {
				for(int i = 1; i < arr.size(); i += 2) {
					int val = arr.get(i);
					System.out.println("Valore a indice dispari " + i + ": " + val);
				}
			}
				
		
	}
	
	

}
