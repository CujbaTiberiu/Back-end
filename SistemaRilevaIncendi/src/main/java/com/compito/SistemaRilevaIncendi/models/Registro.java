package com.compito.SistemaRilevaIncendi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registri")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_centro_controllo")
	private CentroDiControllo centroDiControllo;

    @ManyToOne
	@JoinColumn(name = "id_sonda")
	private Sonda sonda;

    @Column(name = "corpo_messaggio")
	private String corpoMessaggio;

}
