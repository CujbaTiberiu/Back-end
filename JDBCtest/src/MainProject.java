import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class MainProject {

	public static void main(String[] args) {
		
		try {
			DBconnection db = new DBconnection();
			//Cliente c = new Cliente("Marco", "Verdi", LocalDate.of(1980, 10, 10), "Toscana");
			//db.InserisciCliente(c);
			
			//Cliente c = db.leggiCliente(1);
			//System.out.println(c);
			
			//c.setRegioneResidenza("Friuli");
			//db.modificaCliente(c);
			
			//db.cancellaCliente(c);
			
			//List<Cliente> listaClienti = db.leggiTuttiClienti();	
			//listaClienti.forEach(c -> System.out.println(c));
			//db.leggiTuttiClienti().forEach(c -> System.out.println(c));
			
			//Cliente giallino = listaClienti.get(2);//richiamo utente per id
			//giallino.setCognome("Giallino");//cambio valore di una proprietà
			//db.modificaCliente(giallino);//apporto modifica su db
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

}
