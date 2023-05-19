package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import dao.PrestitoDAO;

@Entity
@NamedQuery(name = "mostraTuttiPrestiti" , query = "SELECT p FROM Prestito p")
@NamedQuery(name = "cercaAttualmenteInPrestito" , query = "SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :tessera")
@NamedQuery(name = "mostraPrestitiScaduti" , query = "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :dataOggi AND p.dataRestituzioneEffettiva IS NULL")
public class Prestito extends PrestitoDAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Utente utente;
	
	@OneToOne
	private Catalogo elementoPrestato;
	
	@Column(name = "data_inizio_prestito")
	private LocalDate dataInizioPrestito;
	
	@Column(name = "data_restituzione_prevista")
	private LocalDate dataRestituzionePrevista;
	
	@Column(name = "data_restituzione_effettiva")
	private LocalDate dataRestituzioneEffettiva;

	public Prestito() {
		super();
	}

	public Prestito(Utente utente, Catalogo elementoPrestato, LocalDate dataInizioPrestito) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = null;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Catalogo getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(Catalogo elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}

	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", dataInizioPrestito="
				+ dataInizioPrestito + ", dataRestituzionePrevista=" + dataRestituzionePrevista
				+ ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}


}
