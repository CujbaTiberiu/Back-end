package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import dao.CatalogoDAO;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "TipoOggetto", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "mostraPerAnnoPub", query = "SELECT c From Catalogo c WHERE c.annoPublicazione = :anno")
@NamedQuery(name = "cercaPerAutore", query = "SELECT c From Catalogo c WHERE c.autore = :autore")
@NamedQuery(name = "cercaPerTitolo", query = "SELECT c From Catalogo c WHERE LOWER(c.titolo) LIKE :titolo")
public class Catalogo extends CatalogoDAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer isbn;
	
	@Column(nullable = false)
    private String titolo;
    
    @Column(name = "anno_publicazione", nullable = false)
    private int annoPublicazione;
    
    @Column(name = "numero_pagine", nullable = false)
    private int numeroPagine;
    
    
    
	public Catalogo() {
		super();
	}

	public Catalogo(String titolo, int annoPublicazione, int numeroPagine) {
		super();
		this.titolo = titolo;
		this.annoPublicazione = annoPublicazione;
		this.numeroPagine = numeroPagine;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPublicazione() {
		return annoPublicazione;
	}

	public void setAnnoPublicazione(int annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Catalogo [isbn = " + isbn + ", titolo = " + titolo + ", annoPublicazione = " + annoPublicazione
				+ ", numeroPagine = " + numeroPagine + "]";
	}
    
    
	

}
