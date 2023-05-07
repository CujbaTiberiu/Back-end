package w1.compito;

import java.util.Scanner;

public class MainClass {
	
	static Scanner  sc = new Scanner(System.in);
	
	static eImage[] listaImg = new eImage[5];
	static eAudio[] listaAudio = new eAudio[5];
	static eVideo[] listaVideo = new eVideo[5];
	
	public static void main(String[] args) {
		
		
		Menu();
		
	}
	
	static public void Menu() {
		System.out.println("Ciao!");
		System.out.println("--- Opzioni caricamento file ---");
		System.out.println("[1] Carica 5 file Audio");
		System.out.println("[2] Carica 5 file Video");
		System.out.println("[3] Carica 5 file Immagine");
		System.out.println("--- Opzioni riproduzione file ---");
		System.out.println("[4] Riproduci audio già caricati");
		System.out.println("[5] Riproduci video già caricati");
		System.out.println("[6] Mostra immagini già caricate");
				
		int scelta = sc.nextInt();
		AccediOpzioni(scelta);
	
	}
	
	public static void aggImg() {
		for(int i = 0; i < listaImg.length; i++) {
			System.out.print("Scrivi il titolo dell'immagine " + (i+1) + ": ");
			sc.nextLine();
			 String titolo = sc.nextLine();
			 System.out.print("Imposta la luminosità da 1 a 10 dell'immagine " + (i+1) + ": ");
			int numLum = sc.nextInt();
			 listaImg[i] = new eImage(titolo, numLum);
		}
		showImg();
	}
		
		public static void showImg() {
			
			String img = "immagine";
			ArrayVuoto(listaImg, img);
			
			System.out.print("Scegli un'immagine da visualizzare 1 a 5 oppure 0 per tornare al Menu: ");
			
			 int imgScelta = sc.nextInt();
			 if(imgScelta == 0) {
				 Menu();
			 }else {
				 for(int i = 0; i < listaImg.length; i++) {
						if(i == imgScelta - 1 && listaImg[i] instanceof eImage) {
							 eImage im = (eImage) listaImg[i];
								im.Mostra();
								System.out.print("Vuoi aumentare il volume, digita un numero altrimenti digita 0: ");
								 int volAum = sc.nextInt();
								im.aumLum(volAum);
								System.out.print("Vuoi diminuire il volume, digita un numero altrimenti digita 0: ");
								 int volDim = sc.nextInt();
								im.dimLum(volDim);
								im.Mostra();
								System.out.print("Inserisci 0 per tornare al menu! ");
								int scelto = sc.nextInt();
								if(scelto == 0) {
									Menu();
								}
					}
				
					}
			 }
	}
		
		public static void aggAudio() {
			for(int i = 0; i < listaAudio.length; i++) {
				System.out.print("Scrivi il titolo del file audio " + (i+1) + ": ");
				sc.nextLine();
				 String titolo = sc.nextLine();
				 System.out.print("Imposta il volume da 1 a 10 del file audio" + (i+1) + ": ");
				int numVol = sc.nextInt();
				System.out.print("Imposta la durata da 1 a 10 del file audio" + (i+1) + ": ");
				int numDur = sc.nextInt();
			
				listaAudio[i] = new eAudio(titolo, numVol, numDur);
			}
			 playAudio();
		}
		
		
		public static void playAudio() {
			
			String audio = "audio";
			ArrayVuoto(listaAudio, audio);
			
			System.out.print("Scegli un file audio da riprodurre 1 a 5 oppure 0 per tornare al Menu: ");
			int audioScelto = sc.nextInt();
			if(audioScelto == 0) {
				 Menu();
			 }else {
			for(int i = 0; i < listaAudio.length; i++) {
				if(i == audioScelto - 1 && listaAudio[i] instanceof eAudio) {
					eAudio a = (eAudio) listaAudio[i];
						a.Riproduci();
						System.out.print("Vuoi aumentare il volume, digita un numero altrimenti digita 0: ");
						 int volAum = sc.nextInt();
						a.aumVol(volAum);
						System.out.print("Vuoi diminuire il volume, digita un numero altrimenti digita 0: ");
						 int volDim = sc.nextInt();
						a.dimVol(volDim);
						a.Riproduci();
						System.out.print("Insrisci 0 per tornare al menu! ");
						int scelto = sc.nextInt();
						if(scelto == 0) {
							Menu();
						}
			}
		
			}
			 }
		
	}
		public static void aggVideo() {
			for(int i = 0; i < listaVideo.length; i++) {
				System.out.print("Scrivi il titolo del file video " + (i+1) + ": ");
				sc.nextLine();
				 String titolo = sc.nextLine();
				 System.out.print("Imposta il volume da 1 a 10 del file video" + (i+1) + ": ");
				int numVol = sc.nextInt();
				System.out.print("Imposta la luminosità da 1 a 10 del file video" + (i+1) + ": ");
				int numLum = sc.nextInt();
				System.out.print("Imposta la durata da 1 a 10 del file video" + (i+1) + ": ");
				int numDur = sc.nextInt();
			
				listaVideo[i] = new eVideo(titolo, numDur, numLum, numVol);
			}
			playVideo();
		}
		
		public static void playVideo() {
			String video = "video";
			ArrayVuoto(listaVideo, video);
			
			System.out.print("Scegli un file video da riprodurre 1 a 5 oppure 0 per tornare al Menu : ");
			 int videoScelto = sc.nextInt();
			 if(videoScelto == 0) {
				 Menu();
			 }else {
			for(int i = 0; i < listaVideo.length; i++) {
				if(i == videoScelto - 1 && listaVideo[i] instanceof eVideo) {
					eVideo v = (eVideo) listaVideo[i];
						v.Riproduci();
						System.out.print("Vuoi aumentare il volume, digita un numero altrimenti digita 0: ");
						 int volAum = sc.nextInt();
						v.aumVol(volAum);
						System.out.print("Vuoi diminuire il volume, digita un numero altrimenti digita 0: ");
						 int volDim = sc.nextInt();
						v.dimVol(volDim);
						System.out.print("Vuoi aumentare la luminosità, digita un numero altrimenti digita 0: ");
						 int lumAum = sc.nextInt();
						v.aumLum(lumAum);
						System.out.print("Vuoi diminuire la luminosità, digita un numero altrimenti digita 0: ");
						 int lumDim = sc.nextInt();
						v.dimLum(lumDim);
						v.Riproduci();
						System.out.print("Insrisci 0 per tornare al menu! ");
						int scelto = sc.nextInt();
						if(scelto == 0) {
							Menu();
						}
			}
			}
			 }
		}
		
			
		public static void ArrayVuoto(ElementoMultimediale[] arr, String nome ) {
		    for (int i = 0; i < arr.length; i++) {
		        if (arr[i] != null) {
		        	return;
		        }else{
			        System.out.println("Prima inserisci file " + nome);
			        Menu();
			    }
		    }
		    
		}
		
		
		
		
		public static void AccediOpzioni(int numero) {
			switch(numero) {
			case 1: aggAudio();break;
			case 2: aggVideo();break;
			case 3: aggImg();break;
			case 4: playAudio();break;
			case 5: playVideo();break;
			case 6: showImg();break;
			default: System.out.println("Inserisci un numero tra 1 e 6 inclusi per accedere alle funzionalità del menu!"); Menu();
			}
		}
	
	
		
}
