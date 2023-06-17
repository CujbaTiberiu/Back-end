package com.compito.SistemaRilevaIncendi.models;

import java.util.ArrayList;
import java.util.List;

public class Rillevamento {

	private List<SondaObserver> sondaObservers;

    public Rillevamento() {
    	sondaObservers = new ArrayList<>();
    }
    
	public void aggiungi(SondaObserver observer) {
		sondaObservers.add(observer);
    }

    public void rimuovi(SondaObserver observer) {
    	sondaObservers.remove(observer);
    }

    public void inviaRilevamentoIncendio(Sonda sonda) {
        for (SondaObserver observer : sondaObservers) {
        	observer.update(sonda);
        }
}
}
