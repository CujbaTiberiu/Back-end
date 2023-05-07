package w1.compito;

public class eImage extends ElementoMultimediale implements gestisciLuminosita{
	private int luminosita = 0;

	public eImage(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	public void Mostra() {
	    System.out.println("Immagine in mostra");
	    System.out.println("Titolo immagine: " + this.getTitolo() + " - " + "Luminosità immagine: " + "*".repeat(this.luminosita));
	}

	@Override
	public void aumLum(int numb) {
		this.luminosita += numb;
		
	}

	@Override
	public void dimLum(int numb) {
		this.luminosita -= numb;
		
	}
	
	

}
