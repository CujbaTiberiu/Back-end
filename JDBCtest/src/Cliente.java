import java.time.LocalDate;

public class Cliente {
	
	private Integer NumeroCliente;
	private String Nome;
	private String Cognome;
	private LocalDate DataNascita;
	private String RegioneResidenza;
	
	public Cliente(Integer numeroCliente, String nome, String cognome, LocalDate dataNascita, String regioneResidenza) {
		NumeroCliente = numeroCliente;
		Nome = nome;
		Cognome = cognome;
		DataNascita = dataNascita;
		RegioneResidenza = regioneResidenza;
	}
	
	public Cliente(String nome, String cognome, LocalDate dataNascita, String regioneResidenza) {
		Nome = nome;
		Cognome = cognome;
		DataNascita = dataNascita;
		RegioneResidenza = regioneResidenza;
	}

	@Override
	public String toString() {
		return "Cliente [NumeroCliente=" + NumeroCliente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", DataNascita="
				+ DataNascita + ", RegioneResidenza=" + RegioneResidenza + "]";
	}

	public Integer getNumeroCliente() {
		return NumeroCliente;
	}

	public void setNumeroCliente(Integer numeroCliente) {
		NumeroCliente = numeroCliente;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return DataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		DataNascita = dataNascita;
	}

	public String getRegioneResidenza() {
		return RegioneResidenza;
	}

	public void setRegioneResidenza(String regioneResidenza) {
		RegioneResidenza = regioneResidenza;
	}
	
	
	

}
