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
		System.out.println("Audio in esecuzione");
		System.out.println("Titolo audio: " + super.getTitolo().repeat(this.durata) + " - " + "Volume audio: " + "!".repeat(this.volume));
	}

}
