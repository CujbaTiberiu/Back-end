package w3.ExJDBC.day2;

import java.time.LocalDate;

public class Studente {
	
	public enum Gender {
	    M, F
	}

	private int id;
	private String name;
	private String lastname;
	private Gender gender;
	private LocalDate birthdate;
	private int avg;
	private int min_vote;
	private int max_vote;
	
	public Studente(int id, String name, String lastname, Gender gender, LocalDate birthdate, int avg, int min_vote,
			int max_vote) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public Studente(String name, String lastname, Gender gender, LocalDate birthdate, int avg, int min_vote,
			int max_vote) {
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(int min_vote) {
		this.min_vote = min_vote;
	}

	public int getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(int max_vote) {
		this.max_vote = max_vote;
	}

	@Override
	public String toString() {
		return "Studente [id=" + id + ", name=" + name + ", lastname=" + lastname + ", gender=" + gender
				+ ", birthdate=" + birthdate + ", avg=" + avg + ", min_vote=" + min_vote + ", max_vote=" + max_vote
				+ "]";
	}
	
	
	
	
	
}
