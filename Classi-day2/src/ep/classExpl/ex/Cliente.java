package ep.classExpl.ex;

public class Cliente {
	public String codice;
	public String nome;
	public String cognome;
	public String mail;
	public String dataIscrizione;
	
	public Cliente(String codice, String nome, String cognome, String mail, String dataIscrizione) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.dataIscrizione = dataIscrizione;
	}
}
