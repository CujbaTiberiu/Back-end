package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class PartitaDiCalcio extends Evento{
	

	private String SquadraDiCasa;
	private String SquadraOspite;
	
	@Column(nullable = true)
	private String SquadraVincente = null;
	private Integer GolSquadraDiCasa;
	private Integer GolSquadraOspite;
	
	public PartitaDiCalcio() {
		super();
	}

	public PartitaDiCalcio(String squadraDiCasa, String squadraOspite, String squadraVincente, Integer golSquadraDiCasa,
			Integer golSquadraOspite) {
		super();
		SquadraDiCasa = squadraDiCasa;
		SquadraOspite = squadraOspite;
		SquadraVincente = squadraVincente;
		GolSquadraDiCasa = golSquadraDiCasa;
		GolSquadraOspite = golSquadraOspite;
	}

	public String getSquadraDiCasa() {
		return SquadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		SquadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return SquadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		SquadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return SquadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		SquadraVincente = squadraVincente;
	}

	public Integer getGolSquadraDiCasa() {
		return GolSquadraDiCasa;
	}

	public void setGolSquadraDiCasa(Integer golSquadraDiCasa) {
		GolSquadraDiCasa = golSquadraDiCasa;
	}

	public Integer getGolSquadraOspite() {
		return GolSquadraOspite;
	}

	public void setGolSquadraOspite(Integer golSquadraOspite) {
		GolSquadraOspite = golSquadraOspite;
	}

	@Override
	public String toString() {
		return "PartitaDiCalcio [SquadraDiCasa=" + SquadraDiCasa + ", SquadraOspite=" + SquadraOspite
				+ ", SquadraVincente=" + SquadraVincente + ", GolSquadraDiCasa=" + GolSquadraDiCasa
				+ ", GolSquadraOspite=" + GolSquadraOspite + "]";
	}

	
}
