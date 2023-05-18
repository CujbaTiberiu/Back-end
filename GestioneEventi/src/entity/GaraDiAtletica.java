package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class GaraDiAtletica extends Evento{
	
	
	
	@OneToMany
	private List<Persona> SetAtleti; 
	
	@OneToOne
	private  Persona Vincitore;
	
	

	public GaraDiAtletica() {
		super();
	}

	
	public GaraDiAtletica(List<Persona> setAtleti, Persona vincitore) {
		super();
		SetAtleti = setAtleti;
		Vincitore = vincitore;
	}


	public List<Persona> getSetAtleti() {
		return SetAtleti;
	}

	public void setSetAtleti(List<Persona> setAtleti) {
		SetAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return Vincitore;
	}

	public void setVincitore(Persona vincitore) {
		Vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [SetAtleti=" + SetAtleti + ", Vincitore=" + Vincitore + "]";
	}
	
	
}
