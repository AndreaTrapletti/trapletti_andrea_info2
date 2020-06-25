package gestore;

import java.util.Vector;

import prog.io.FileInputManager;
import prog.io.FileNonPresenteException;
import referti.Referto;

public class GestoreReferti {
	public Vector<Referto> referti = new Vector<>();
	public GestoreReferti() {}
	
	public void inserisciReferto(Referto r) {
		referti.add(r);
	}
	
	public void inserisciRefertiDaFile(String nomeFile) {
		if(FileInputManager.exists(nomeFile)) {
			FileInputManager file = new FileInputManager(nomeFile);
			String riga;
			while((riga = file.readLine()) != null) {
				
			}
			
			file.close();
		}else throw new FileNonPresenteException("il file non è stato trovato");
	}
	
}
