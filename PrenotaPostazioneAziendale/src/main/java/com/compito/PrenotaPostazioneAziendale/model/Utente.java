package com.compito.PrenotaPostazioneAziendale.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utenti")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, name = "user_name", unique = true)
	private String userName;
	

	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;

	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioni;

	public Utente(String userName, String nomeCompleto, String email) {
		super();
		this.userName = userName;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}
	
	
}
