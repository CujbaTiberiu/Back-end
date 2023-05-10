package com.Esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MainProjectE2 {
	
	static List<Integer> mainArr = new ArrayList<Integer>();
	

	public static void main(String[] args) throws InterruptedException {
		
		numCas();
		//System.out.println(mainArr.toString());
		
		
		
		List<Integer> arr1 = new ArrayList<>(mainArr.subList(0, 1000));
		List<Integer> arr2 = new ArrayList<>(mainArr.subList(1000, 2001));
		List<Integer> arr3 = new ArrayList<>(mainArr.subList(2001, 3001));
		
		MultiThread mt1 = new MultiThread("thread da 0 - 1000", arr1);
		MultiThread mt2 = new MultiThread("thread da 1000 - 2000", arr2);
		MultiThread mt3 = new MultiThread("thread da 2000 - 3000", arr3);

		//System.out.println(arr1.toString());
		//System.out.println(arr2.toString());
		//System.out.println(arr3.toString());
		
		mt1.start();
		mt1.join();
		mt2.start();
		mt2.join();
		mt3.start();
		mt3.join();
		
		MultiThread.mainSomma();
		
		
	}
	
	public static void numCas() {
		Random random = new Random();
		for(int i = 0; i < 3001; i++) {
			int randomNumber = random.nextInt(10);
			mainArr.add(randomNumber);
		}
		
	

}
	
	
	
	
}
