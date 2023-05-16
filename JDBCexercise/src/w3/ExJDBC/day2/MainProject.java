package w3.ExJDBC.day2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import w3.ExJDBC.day2.Studente.Gender;

public class MainProject {

	public static void main(String[] args) {
	
		Studente s = new Studente("John", "Smith", Gender.M, LocalDate.of(1987, 10, 11), 8, 8, 8);
		Studente s1 = new Studente("Aurora", "Verdi", Gender.F, LocalDate.of(1992, 01, 02), 9, 9, 9);
		//System.out.println(s1);
		try {
			DBconnex db = new DBconnex();
			//db.inserisciStudente(s);
			//db.inserisciStudente(s1);
			//System.out.println(s1);
			//Studente s2 = db.leggiStudente(2);
			//s2.setMax_vote(10);
			//System.out.println(s2);
			//db.modificaStudente(s2);
			//db.modificaStudente(s1);
			//System.out.println(s1);
			//db.cancellaStudente(s2);
			String bestStudent = db.getBest();
			System.out.println(bestStudent.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
