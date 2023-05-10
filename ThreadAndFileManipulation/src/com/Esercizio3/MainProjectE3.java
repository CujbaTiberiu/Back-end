package com.Esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class MainProjectE3 {
	
	static File fileRegistro = new File("registro/RegistroPresenze.txt");
	static  Map<String, String> elenco = new HashMap<String, String>();
	

	public static void main(String[] args) {
	
		elenco.put("Mario Rossi@", "5#");
		elenco.put("Giorgio Bianchi@", "6#");
		elenco.put("Gianni Verdi@", "2#");
		
		try {
			scriviSuFile();
			String vediFile = leggiDaFile();
			System.out.print(vediFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void scriviSuFile() throws IOException {
		FileUtils.writeStringToFile(fileRegistro, elenco.toString(), "UTF-8", true);
		System.out.println("Testo scritto su file");
	}
	
	public static String leggiDaFile() throws IOException {
		return FileUtils.readFileToString(fileRegistro, "UTF-8");
	}
	
	

}
