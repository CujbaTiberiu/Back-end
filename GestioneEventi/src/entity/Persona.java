package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import enums.Sesso;

@Entity
@Table(name = "persone")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(unique = true)
	private String email;
	
	@Column(name = "data_nascita", nullable = false)
	private LocalDate dataNascita;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sesso sesso;
	
	@Column(name = "lista_partecipazioni")
	@OrderBy("dataEvento ASC")
	@OneToMany(mappedBy = "persona")
	private List<Partecipazione> listaPartecipazioni;

	public Persona() {
		super();
	}

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getListaPartecipazioni() {
		return listaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataNascita="
				+ dataNascita + ", sesso=" + sesso + "]";
	}

}
