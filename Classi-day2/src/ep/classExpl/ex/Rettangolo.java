package ep.classExpl.ex;

public class Rettangolo {
	public int altezza;
	public int larghezza;
	public int perimetro;
	public int area;
	
	public Rettangolo(int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public int printPerimetro() {
		this.perimetro =  (this.altezza + this.larghezza)* 2;
		//return this.perimetro;
		return this.perimetro;
	}
	
	public int printArea() {
		this.area =  ((this.altezza * this.larghezza));
		return this.area;
	}


}
