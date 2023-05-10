package com.Esercizio1;

public class MainProjectE1 {

	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1("Thread*", '*');
		Thread1 t2 = new Thread1("Thread#", '#');
		//Thread1 t2 = new Thread1("Thread#");
		//Thread2 t1 = new Thread2("Thread#");
		
		t1.start();
		t2.start();
	}

}
