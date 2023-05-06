package w1.compito;

public class eAudio extends ElementoMultimediale implements VolRipro{
	private int volume = 0;
	private int durata = 0;

	public eAudio(String titolo, int volume,int durata) {
		super(titolo);
		this.volume = volume;
		this.durata = durata;
	}

	@Override
	public void aumVol(int numb) {
		this.volume += numb;
		
	}

	@Override
	public void dimVol(int numb) {
		this.volume -= numb;
		
	}

	@Override
	public void Riproduci() {
		for(int i = 0; i< this.durata; i++ ) {
			System.out.println(super.getTitolo());
		}
		for(int j = 0; j< this.volume; j++ ) {
			System.out.println("!");
		}
		
	}

}
