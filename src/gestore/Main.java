package gestore;

import prog.utili.Data;
import referti.EsamiMultipliReferto;
import referti.FormatoCodiceFiscaleException;
import referti.Paziente;
import referti.Referto;
import referti.RisultatoReferto;
import referti.Sesso;
import referti.SingoloReferto;

public class Main {

	public static void main(String[] args) {
		
		GestoreReferti g = new GestoreReferti();
		
		g.inserisciRefertiDaFile("referti.txt");
		Referto r1 = new SingoloReferto(new Data("22.11.2011"), new Paziente("Mario", "Giordano", new Data("22.12.1967"), Sesso.MASCHIO), RisultatoReferto.DUBBIO);
		g.inserisciReferto(r1);
		Referto r2;
		try {
			r2 = new EsamiMultipliReferto(new Data("24.06.2020"), new Paziente("Andrea", "Trapletti", new Data("12.10.1998"), Sesso.MASCHIO, "codiceFiscale.txt"));
			g.inserisciReferto(r2);
		} catch (FormatoCodiceFiscaleException e) {
			System.out.println("ERRORE: "+ e);
		}
		
		
		

	}

}
