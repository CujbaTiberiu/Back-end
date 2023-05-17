package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.tipoEvento;

@Entity
@Table(name = "eventi")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	
	@Column(name = "data_evento")
	private LocalDate dataEvento;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_evento")
	private tipoEvento tipoEvento;
	
	@Column(name = "numero_max_partecipanti")
	private int numeroMassimoPartecipanti;

	public Evento() {
		super();
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, enums.tipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
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

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}
	
	
}




