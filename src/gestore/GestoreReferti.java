package gestore;

import java.nio.channels.NonReadableChannelException;
import java.util.Collections;
import java.util.Vector;
import prog.io.FileInputManager;
import prog.io.FileNonPresenteException;
import prog.utili.Data;
import referti.Dottore;
import referti.EsamiMultipliReferto;
import referti.LegatoAImmagineReferto;
import referti.Paziente;
import referti.Referto;
import referti.RisultatoReferto;
import referti.Sesso;
import referti.SingoloReferto;

public class GestoreReferti {
	public Vector<Referto> referti = new Vector<>();
	
	public Vector<Paziente> listaPazienti = new Vector<>();
	
	public GestoreReferti() {}
	
	public void inserisciReferto(Referto r) {
		referti.add(r);
		Paziente paziente = r.getPaziente();
		aggiungiPazienteAllaLista(paziente);
	}
	
	public void aggiungiPazienteAllaLista(Paziente paziente) {
		boolean trovato = false;
		for(int i =0; i< listaPazienti.size(); i++) {
			if(listaPazienti.get(i).equals(paziente)) {
				trovato = true;
				break;
			}
		}
		if (trovato == false) listaPazienti.add(paziente);
		else System.out.println("Il paziente è già presente in lista...");
	}
	
	public void inserisciRefertiDaFile(String nomeFile) {
		if(FileInputManager.exists(nomeFile)) {
			FileInputManager file = new FileInputManager(nomeFile);
			String riga;
			while((riga = file.readLine()) != null) {
				
				String[] data = riga.split("-");
				switch(data[0]) {
				case "S":
					generaEAggiungiRefertoSingolo(data);
					break;
				case "M":
					generaEAggiungiRefertoEsameMultiplo(data);
					break;
				case "I":
					generaeAggiungiRefertoConImmagine(data);
					break;
				default:
						break;
				}
				
			}
			
			file.close();
		}else throw new FileNonPresenteException("il file non è stato trovato");
	}
	private void generaeAggiungiRefertoConImmagine(String[] data){
		Sesso sesso;
		if (data[5].equals("M"))
			sesso = Sesso.MASCHIO;
		else {
			sesso= Sesso.FEMMINA;
		}
		
		referti.add(new LegatoAImmagineReferto(new Data(data[1]), new Paziente(data[2], data[3], new Data(data[4]), sesso), data[6], data[7], new Dottore(data[8], data[9])));
		Paziente paziente = new Paziente(data[2], data[3], new Data(data[4]), sesso);
		aggiungiPazienteAllaLista(paziente);
		
	}
	private void generaEAggiungiRefertoSingolo(String[] data) {
		Sesso sesso;
		if (data[5].equals("M"))
			sesso = Sesso.MASCHIO;
		else {
			sesso= Sesso.FEMMINA;
		}
		RisultatoReferto risultato;
		if(data[6].equals("P"))
			risultato = RisultatoReferto.POSITIVO;
		else if(data[6].equals("N"))
			risultato = RisultatoReferto.NEGATIVO;
		else 
			risultato = RisultatoReferto.DUBBIO;
		
		referti.add(new SingoloReferto(new Data(data[1]), new Paziente(data[2], data[3], new Data(data[4]), sesso), risultato ));
		Paziente paziente = new Paziente(data[2], data[3], new Data(data[4]), sesso);
		aggiungiPazienteAllaLista(paziente);
	}
	
	private void generaEAggiungiRefertoEsameMultiplo(String[] data) {
		Sesso sesso;
		if (data[5].equals("M"))
			sesso = Sesso.MASCHIO;
		else {
			sesso= Sesso.FEMMINA;
		}
		referti.add(new EsamiMultipliReferto(new Data(data[1]), new Paziente(data[2], data[3], new Data(data[4]), sesso)));
		Paziente paziente = new Paziente(data[2], data[3], new Data(data[4]), sesso);
		aggiungiPazienteAllaLista(paziente);
	}
	
	public void cancellaRefertiDiUnPaziente(Paziente p) {
		
	}
	public void stampaInOrdineDiData() {
		Referto[] r = new Referto[referti.size()];
		for (int i = 0; i < referti.size(); i++) {
			r[i] = referti.get(i);
		}
		boolean trovato;
		do{
			trovato = false;
			Referto temp;
			for (int i=1; i<r.length; i++) {
				if(r[i].getData().compareTo(r[i-1].getData()) < 0 ) {
					temp = r[i];
					r[i] = r[i-1];
					r[i-1] = temp;
					trovato = true;
				}
			}
			
		}while(trovato);
		
		for(int i = 0; i < r.length; i++) {
			if(r[i].validity())
				System.out.println(r[i].toString());
		}
	}
	public void stampaPerPaziente() {
		for(int i = 0; i<listaPazienti.size(); i++) {
			System.out.println("ECCO LA LISTA DEI REFERTI DEL PAZIENTE: "+listaPazienti.get(i).getCognome()+"  "+listaPazienti.get(i).getNome());
			for(int j =0; j<referti.size(); j++) {
				
				if(listaPazienti.get(i).equals(referti.get(j).getPaziente()))
						System.out.println(listaPazienti.get(i).toString());
					
			}	
		}
	}
	public void stampaPerCriticità() {
		Collections.sort(referti);
		
		for(int i = 0; i < referti.size(); i++) {
			if(referti.get(i).validity())
				System.out.println(referti.get(i).toString());
		}
		
	}
	
}
