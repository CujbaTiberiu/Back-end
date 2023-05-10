package com.Esercizio2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MultiThread extends Thread{
	
	private Logger log = LoggerFactory.getLogger(MultiThread.class);
	private String msg;
	private List<Integer> numeri;
	
	public  MultiThread(String msg, List<Integer> numeri){
		super(msg);
		this.numeri = numeri;
	}
	
	@Override
	public void run() {
		int somma = sommaArr(numeri);
		log.info("Sum: " + somma);
	}
	
	public int sommaArr(List<Integer> a) {
		int somma = 0;
		for(int num : a) {
			somma += num; 
		}
		return somma;
	}

}
