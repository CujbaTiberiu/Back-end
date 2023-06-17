package com.compito.SistemaRilevaIncendi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sonde")
public class Sonda {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String latitudine;
	 private String longitudine;
	 @Column(name = "livello_fumo")
	 private int livelloFumo = 0;
	 @Transient
	 private Rillevamento rillevamento;
	 
	public Sonda(String latitudine, String longitudine, int livelloFumo) {
		super();
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = livelloFumo;
	}
	 
	public void rilevaIncendio(int livelloFumo) {
        this.livelloFumo = livelloFumo;
        rillevamento.inviaRilevamentoIncendio(this);
    }
	 
}
