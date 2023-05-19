package entity;

import javax.persistence.Entity;

@Entity
public class Libro extends Catalogo{

	private String autore;
	
	private String genere;
	
	public Libro() {
		super();
	}
	
	public Libro(String titolo, int annoPublicazione, int numeroPagine, String autore, String genere) {
		super(titolo, annoPublicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return super.toString() + " - Libro " + " - [autore = " + autore + ", genere = " + genere + "]";
	}
	
}
