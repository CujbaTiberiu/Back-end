package ep.classExpl.ex;

public class Articolo {
	public String codice;
	public String descrizione;
	public double prezzo;
	public int totInMag;
	
	public Articolo(String codice, String descrizione, double prezzo, int totInMag) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.totInMag = totInMag;
	}
}
