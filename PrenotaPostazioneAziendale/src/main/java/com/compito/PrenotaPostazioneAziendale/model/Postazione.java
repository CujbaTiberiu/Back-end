package com.compito.PrenotaPostazioneAziendale.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false, name = "numero_max_occuppanti")
	private int numeroMaxOccupanti;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
    private Edificio edificio;
	
	private boolean prenotato;

	public Postazione(String descrizione, int numeroMaxOccupanti, TipoPostazione tipo, Edificio edificio) {
		super();
		this.descrizione = descrizione;
		this.numeroMaxOccupanti = numeroMaxOccupanti;
		this.tipo = tipo;
		this.edificio = edificio;
		this.prenotato = false;
	}
	
	
	
}
