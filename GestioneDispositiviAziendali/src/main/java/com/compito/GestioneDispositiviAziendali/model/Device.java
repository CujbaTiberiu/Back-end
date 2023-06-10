package com.compito.GestioneDispositiviAziendali.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "devices")
public class Device {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type_device", nullable = false)
	private TypeDevice typeDevice;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type_status", nullable = false)
	private TypeStatus typeStatus;
	
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private User user;


}
