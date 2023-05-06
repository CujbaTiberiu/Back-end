package w1.compito;

public class eVideo extends ElementoMultimediale implements VolRipro,gestisciLuminosita{
	private int durata = 0;
	private int volume = 0;
	private int luminosita = 0;

	public eVideo(String titolo,int durata,int volume,int luminosita) {
		super(titolo);
		this.durata = durata;
		this.luminosita = luminosita;
		this.volume = volume;
	}

	@Override
	public void aumLum(int numb) {
		this.luminosita += numb;
		
	}

	@Override
	public void dimLum(int numb) {
		this.luminosita -= numb;
		
	}

	@Override
	public void Riproduci() {
		for(int i = 0; i< this.durata; i++ ) {
			System.out.println(super.getTitolo());
		}
		for(int j = 0; j< this.volume; j++ ) {
			System.out.println("!");
		}
		for(int k = 0; k< this.luminosita; k++ ) {
			System.out.println("*");
		}
		
	}

	@Override
	public void aumVol(int numb) {
		this.volume += numb;
		
	}

	@Override
	public void dimVol(int numb) {
		this.volume -= numb;
		
	}

}
