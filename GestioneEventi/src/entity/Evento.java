package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import DAO.EventoDAO;
import enums.tipoEvento;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "TipoEvento", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "findAllEventi", query = "SELECT ev FROM Evento ev")
public class Evento extends EventoDAO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(name = "data_evento", nullable = false)
	private LocalDate dataEvento;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_evento", nullable = false)
	private tipoEvento tipoEvento;
	
	@Column(name = "numero_max_partecipanti", nullable = false)
	private int numeroMassimoPartecipanti;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
	@Column(name = "totale_partecipanti")
	private List<Partecipazione> totPartecipazioni;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Location location;

	public Evento() {
		super();
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, enums.tipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
		this.totPartecipazioni = new ArrayList<Partecipazione>();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public tipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(tipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public List<Partecipazione> getTotPartecipazioni() {
		return totPartecipazioni;
	}

	public void setTotPartecipazioni(List<Partecipazione> totPartecipazioni) {
		this.totPartecipazioni = totPartecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}

}




