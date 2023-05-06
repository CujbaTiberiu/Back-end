package w1.compito;

public class eImage extends ElementoMultimediale implements gestisciLuminosita{
	private int luminosita = 0;

	public eImage(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	public void Mostra() {
		System.out.println("Audio in esecuzione");
		for(int i = 0; i< this.luminosita; i++ ) {
			System.out.println(super.getTitolo());
		}
		for(int j = 0; j< this.luminosita; j++ ) {
			System.out.println("*");
		}
		
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
