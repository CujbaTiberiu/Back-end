package entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.Periodicita;

@Entity
public class Rivista extends Catalogo{

	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista() {
		super();
	}

	public Rivista(String titolo, int annoPublicazione, int numeroPagine, Periodicita periodicita) {
		super(titolo, annoPublicazione, numeroPagine);
	this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return super.toString() + " - Rivista [periodicita = " + periodicita + "]";
	}

}
