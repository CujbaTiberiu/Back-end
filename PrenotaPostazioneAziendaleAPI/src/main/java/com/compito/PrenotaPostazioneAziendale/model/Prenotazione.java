package com.compito.PrenotaPostazioneAziendale.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.compito.PrenotaPostazioneAziendale.repository.PostazioneDAORepository;
import com.compito.PrenotaPostazioneAziendale.service.PostazioneService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	//@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postazione_id")
	private Postazione postazione;
	
	//@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "utente_id")
	private Utente utente;

    @Column(name = "inizio_prenotazione")
    @Temporal(TemporalType.DATE)
	private LocalDate inizioPrenotazione;
	
    @Column(name = "fine_prenotazione")
    @Temporal(TemporalType.DATE)
	private LocalDate finePrenotazione;


    public Prenotazione(Postazione postazione, Utente utente) {
        this.utente = utente;
    }

    @PrePersist
    public void setPrenotazioneDates() {
        this.inizioPrenotazione = LocalDate.now();
        this.finePrenotazione = inizioPrenotazione.plusDays(1);
    }
    
    public void setPostazione(Postazione postazione) throws Exception {
        if (postazione != null) {
            if (!postazione.getPrenotato()) {
                this.postazione = postazione;
                this.postazione.setPrenotato(true);
            } else {
                throw new Exception("Postazione già prenotata!");
            }
        } else {
            throw new Exception("Postazione non esistente!");
        }
    }

    
}
