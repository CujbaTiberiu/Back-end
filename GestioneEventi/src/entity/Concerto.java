package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import enums.Genere;

@Entity
public class Concerto extends Evento{
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	@Column(name = "in_streaming")
	private boolean inStreaming = false;

	public Concerto() {
		super();
	}

	public Concerto(Genere genere, boolean inStreaming) {
		super();
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}
	
	
	
}
