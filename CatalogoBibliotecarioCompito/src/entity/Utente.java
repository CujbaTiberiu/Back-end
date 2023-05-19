package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import dao.UtenteDAO;

@Entity
@NamedQuery(name = "mostraTuttiUtenti", query = "SELECT u FROM Utente u")
public class Utente extends UtenteDAO{

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(name = "data_nscita", nullable = false)
	private LocalDate dataNascita;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroDiTessera;
	
	

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Integer getNumeroDiTessera() {
		return numeroDiTessera;
	}

	public void setNumeroDiTessera(Integer numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", numeroDiTessera="
				+ numeroDiTessera + "]";
	}
	
	
}
