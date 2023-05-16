import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBconnection {

	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "EsercizioDay1";
	String user = "postgres";
	String pass = "post2023";
	Connection conn;
	Statement st;
	
	public DBconnection() throws SQLException {
	 conn = DriverManager.getConnection(url+dbName, user, pass);
	 st = conn.createStatement();
	 System.out.println("DB connesso!");
	}
	
	/*INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES ('Giuseppe', 'Verdi', '01-02-1990'), 'Toscana');*/
	
	public void InserisciCliente(Cliente c) throws SQLException {
		String sql = "INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)"
				+ "VALUES ('"+c.getNome()+"', '"+c.getCognome()+"', '"+c.getDataNascita()+"', '"+c.getRegioneResidenza()+"')";
		st.executeUpdate(sql);
		System.out.println(c.getNome() + " " + c.getCognome() + " salvato nel DB!");
	}
	
	public Cliente leggiCliente(int id) throws SQLException {
		String sql = "SELECT * FROM Clienti WHERE NumeroCliente = " + id;
		ResultSet rs = st.executeQuery(sql);
		Cliente c = null;
		if(rs.next()) {
			int NumeroCliente = rs.getInt("NumeroCliente");
			String Nome = rs.getString("Nome");
			String Cognome = rs.getString("Cognome");
			String DataNascita = rs.getString("DataNascita");
			String RegioneResidenza = rs.getString("RegioneResidenza");
		 c = new Cliente (NumeroCliente, Nome, Cognome, LocalDate.parse(DataNascita), RegioneResidenza);
			
		}
		return c;
	}
	
	public void modificaCliente(Cliente c) throws SQLException {
		String sql = "UPDATE Clienti SET" 
				+ "Nome = '"+c.getNome()+"', "
				+ "Cognome = '"+c.getCognome()+"', "
				+ "DataNascita = '"+c.getDataNascita()+"', "
				+ "RegioneResidenza = '"+c.getRegioneResidenza()+"'"
				+ "WHERE NumeroCliente = " + c.getNumeroCliente();
		st.executeUpdate(sql);
		
	}
	
	public void cancellaCliente(Cliente c) throws SQLException {
		String sql = "DELETE FROM Clienti SET WHERE NumeroCliente =" + c.getNumeroCliente();
		st.executeUpdate(sql);
	}
	
	public List<Cliente> leggiTuttiClienti() throws SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM Clienti";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			int NumeroCliente = rs.getInt("NumeroCliente");
			String Nome = rs.getString("Nome");
			String Cognome = rs.getString("Cognome");
			String DataNascita = rs.getString("DataNascita");
			String RegioneResidenza = rs.getString("RegioneResidenza");
			Cliente c = new Cliente (NumeroCliente, Nome, Cognome, LocalDate.parse(DataNascita), RegioneResidenza);
			lista.add(c);
		}
		return lista;
	}
}




