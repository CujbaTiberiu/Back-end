package w1.compito;

public abstract class ElementoMultimediale {
	private String titolo;
	
	public ElementoMultimediale(String titolo) {
		this.setTitolo(titolo);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
