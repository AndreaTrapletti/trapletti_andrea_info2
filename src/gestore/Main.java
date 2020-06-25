package gestore;


/**
 * @author Andrea_trapletti
 * @version 1.1
 * @category examProject
 * 
 */

import prog.utili.Data;
import referti.Dottore;
import referti.EsamiMultipliReferto;
import referti.FormatoCodiceFiscaleException;
import referti.LegatoAImmagineReferto;
import referti.Paziente;
import referti.Referto;
import referti.RisultatoReferto;
import referti.Sesso;
import referti.SingoloReferto;

public class Main {

	public static void main(String[] args) {
		
		GestoreReferti g = new GestoreReferti();
		
		g.inserisciRefertiDaFile("referti.txt");
		for(int i =0; i<g.referti.size(); i++) {
			if(g.referti.get(i) instanceof EsamiMultipliReferto) {
				EsamiMultipliReferto r = (EsamiMultipliReferto) g.referti.get(i);
				aggiungiCoppiaStringaEValore(r);
			}
				
		}
		Referto r1 = new SingoloReferto(new Data("22.11.2011"), new Paziente("Mario", "Giordano", new Data("22.12.1967"), Sesso.MASCHIO), RisultatoReferto.DUBBIO);
		g.inserisciReferto(r1);
		
		Paziente paz1 = new Paziente("Mattia", "Giudici", new Data("21.12.2000"), Sesso.MASCHIO);
		Referto r3 = new LegatoAImmagineReferto(new Data("18.06.2020"), paz1, "img2311", "critico", new Dottore("Alessandro", "Rispoli") );
		g.inserisciReferto(r3);
		
		try {
			Referto referto2 = new EsamiMultipliReferto(new Data("24.06.2020"), new Paziente("Andrea", "Trapletti", new Data("12.10.1998"), Sesso.MASCHIO, "codiceFiscale.txt"));
			EsamiMultipliReferto r2 = (EsamiMultipliReferto) referto2;
			r2.aggiungiCoppia("emoglobina", 2);
			r2.aggiungiCoppia("Globuli bianchu", 1);
			r2.aggiungiCoppia("piastrine", 10);
			r2.aggiungiCoppia("Globuli rossi", 15);
			g.inserisciReferto(r2);
			
		} catch (FormatoCodiceFiscaleException e) {
			System.out.println("ERRORE: "+ e);
		}
		
		g.stampaInOrdineDiData();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		g.stampaPerCriticità();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        g.stampaPerPaziente();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		
	

	}
	private static void aggiungiCoppiaStringaEValore(EsamiMultipliReferto e) {
		int r = (int)Math.random()*2;
		if(r==0) {
			e.aggiungiCoppia("emoglobina", 14);
			e.aggiungiCoppia("Globuli bianchu", 7);
			e.aggiungiCoppia("piastrine", 7);
			e.aggiungiCoppia("Globuli rossi", 7);
		}
		if(r==1) {
			e.aggiungiCoppia("emoglobina", 20);
			e.aggiungiCoppia("Globuli bianchu", 5);
			e.aggiungiCoppia("piastrine", 9);
			e.aggiungiCoppia("Globuli rossi", 7);
		}
		if(r==2) {
			e.aggiungiCoppia("emoglobina", 2);
			e.aggiungiCoppia("Globuli bianchu", 1);
			e.aggiungiCoppia("piastrine", 10);
			e.aggiungiCoppia("Globuli rossi", 15);
		}
	}

}
