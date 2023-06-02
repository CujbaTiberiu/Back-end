package com.compito.PrenotaPostazioneAziendale.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @ManyToOne
    @JoinColumn(name = "postazione_id")
	private Postazione postazione;
	
    @ManyToOne
    @JoinColumn(name = "utente_id")
	private Utente utente;

	private LocalDate giornoPrenotazione;
	
	private LocalDate finePrenotazione;

	public Prenotazione(Postazione postazione, Utente utente, LocalDate giornoPrenotazione) {
		super();
		this.postazione = postazione;
		this.utente = utente;
		this.giornoPrenotazione = giornoPrenotazione;
		this.finePrenotazione = giornoPrenotazione.plusDays(1);
	}
	
	
	
	
}
