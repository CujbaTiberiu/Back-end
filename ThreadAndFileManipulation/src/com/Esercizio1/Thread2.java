package com.Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread2 extends Thread{

	private Logger log = LoggerFactory.getLogger(Thread1.class);
	private String message;
	
	public Thread2(String message) {
		super(message);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				log.info("N: " + (i+1) + " #");
				Thread.sleep(1000);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}
