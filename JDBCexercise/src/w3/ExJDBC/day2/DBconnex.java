package w3.ExJDBC.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import w3.ExJDBC.day2.Studente.Gender;

public class DBconnex {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "JBDCex";
	String user = "postgres";
	String pass = "post2023";
	Connection conn;
	Statement st;
	
	public DBconnex() throws SQLException {
		 conn = DriverManager.getConnection(url+dbName, user, pass);
		 st = conn.createStatement();
		 System.out.println("DB connesso!");
		}
	
	public void inserisciStudente(Studente s) throws SQLException {
		String sql = "INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote)"
				+ "VALUES ('"+s.getName()+"', '"+s.getLastname()+"', '"+s.getGender()+"', "
						+ "'"+s.getBirthdate()+"', '"+s.getAvg()+"' , '"+s.getMin_vote()+"', '"+s.getMax_vote()+"')";
		st.executeUpdate(sql);
		System.out.println(s.getName() + " " + s.getLastname() + " salvato nel DB!");
	}
	

	public void modificaStudente(Studente s) throws SQLException {
		String sql = "UPDATE school_students SET " 
				+ "name = '"+s.getName()+"', "
				+ "lastname = '"+s.getLastname()+"', "
				+ "gender = '"+s.getGender()+"', "
				+ "birthdate = '"+s.getBirthdate()+"', "
				+ "avg = '"+s.getAvg()+"', "
				+ "min_vote = '"+s.getMin_vote()+"', "
				+ "max_vote = '"+s.getMax_vote()+"'"
				+ "WHERE id = " + s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getId() + " modificato con successo!");
	}
	
	public void cancellaStudente(int id) throws SQLException {
		String sql = "DELETE FROM school_students SET WHERE id =" + id;
		st.executeUpdate(sql);
	}
	
	public Studente leggiStudente(int id) throws SQLException {
		String sql = "SELECT * FROM school_students WHERE id = " + id;
		ResultSet rs = st.executeQuery(sql);
		Studente s = null;
		if(rs.next()) {
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String genderStr = rs.getString("gender");
			Gender gender = Gender.valueOf(genderStr);
			String birthdate = rs.getString("birthdate");
			int avg = rs.getInt("avg");
			int min_vote = rs.getInt("min_vote");
			int max_vote = rs.getInt("max_vote");
			s = new Studente (id1, name, lastname, gender, LocalDate.parse(birthdate), avg, min_vote, max_vote);
			
		}
		return s;
	}
	
	public String getBest() throws SQLException {
		String sql = "SELECT name, lastname max_vote FROM school_students WHERE school_students.max_vote =10";
		ResultSet rs = st.executeQuery(sql);
		return rs.toString();
	}

}
