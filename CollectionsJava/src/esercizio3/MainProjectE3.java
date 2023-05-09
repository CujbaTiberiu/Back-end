package esercizio3;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class MainProjectE3 {
	static  Map<String, String> elenco = new HashMap<String, String>();
	public static void main(String[] args) {
		
		contactsMap();
		returnKey(elenco, "3879663255");
		returnValue(elenco, "Joe Rogan");
		System.out.println(elenco);
	}
	
	public static void contactsMap() {
	
		
		elenco.put("Elon Musk", "3586996321");
		elenco.put("Jordan Petterson", "3213473662");
		elenco.put("Joe Rogan", "3203145620");
		elenco.put("Capitan Price", "3879663255");
		System.out.println(elenco);
		
		
		elenco.remove("Jordan Petterson");
		System.out.println(elenco);
		
		
		 
	}
	
	public static void returnKey(Map<String, String> e, String val) {
		for (Entry<String, String> entry : e.entrySet()) {
	        if (entry.getValue().equals(val)) {
	            System.out.println("Il nome è (key): " + entry.getKey());
	        }
	}
	}
	
	public static void returnValue(Map<String, String> e, String key) {
		for (Entry<String, String> entry : e.entrySet()) {
	        if (entry.getKey().equals(key)) {
	            System.out.println("Il numero è (value): " + entry.getValue());
	        }
	}
	}
	
	
	
}

