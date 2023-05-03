package ep.classExpl.ex;

public class CartaSim {
    public int numCell;
    public double credito;
    public Chiamata[] ultimeCinqueChiamate = new Chiamata[5];

    public static class Chiamata {
        public int numero;
        public int tempo;
        
        public Chiamata(int numero, int tempo) {
            this.numero = numero;
            this.tempo = tempo;
        }
        
        
    }
    public CartaSim(int numCell, double credito, Chiamata[] ultimeCinqueChiamate) {
    	this.numCell = numCell;
    	this.credito = credito;
    	this.ultimeCinqueChiamate = ultimeCinqueChiamate;
    }
    
    public void printDataSim() {
    	System.out.println("The number is: " + this.numCell + '|' + "The credit is: " + this.credito+'€');
    	for(int i = 0; i < ultimeCinqueChiamate.length; i++) {
    		System.out.println((i+1) + ".Number called: " + this.ultimeCinqueChiamate[i].numero + " - " + "Time " + this.ultimeCinqueChiamate[i].tempo + " minutes" );
    	}
    }
}
