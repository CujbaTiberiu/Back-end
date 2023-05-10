package com.Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread1 extends Thread{

	private Logger log = LoggerFactory.getLogger(Thread1.class);
	private String message;
	private char simbolo;
	
	public Thread1(String message, char simbolo) {
		super(message);
		this.simbolo = simbolo;
		
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				log.info("N: " + (i+1) + ' ' + this.simbolo);
				Thread.sleep(1000);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	
	
	
}
