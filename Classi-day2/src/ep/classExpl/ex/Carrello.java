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
		 String cliente = "";
		for(int i = 0; i < listaArticoli.length; i++) {
			for(int j = 0; j < clienteAss.length; j++) {
			 totCosto += listaArticoli[i].prezzo;
			  cliente = clienteAss[j].nome + ' ' + clienteAss[j].cognome;
		}
		}
		
		
		System.out.println("Cliente: " + cliente + " - Number of articles: " + listaArticoli.length + " - Total cart cost: " + totCosto);
	}
	/*
	 * public void stampaCarrello(){
	 * System.out.prinln("---Carrello---");
	 * System.out.println(this.clienteAss);
	 * for(int i = 0; i < elencoArticoli.length; i++){
	 * if(elencoArticoli[i] != null){
	 * 
	 * }
	 * }
	 * }
	 * metodo per aggiungere articolo al carrello 
	 * 
	 * public void aggiungiArticoloCarrello(Articolo a){
	 * for (int = 0 ; i < elencoArticoli,length; i++){
	 * if(elencoArticoli =0 null){
	 * elencoArticoli[i] = a;
	 * break;
	 * }
	 * }
	 * }
	 * */
}
