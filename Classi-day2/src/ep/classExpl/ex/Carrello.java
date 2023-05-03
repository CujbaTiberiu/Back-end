package ep.classExpl.ex;


public class Carrello {
	public Cliente[] clienteAss;
	public Articolo[] listaArticoli;
	
	public Carrello(Cliente[] clienteAss, Articolo[] listaArticoli) {
		this.clienteAss = clienteAss;
		this.listaArticoli = listaArticoli;
	}
	
	public void totCarrello() {
		double totCosto = 0;
		for(int i = 0; i < listaArticoli.length; i++) {
			 totCosto += listaArticoli[i].prezzo;
		}
		System.out.println("Total cost: " + totCosto);
	}
}
