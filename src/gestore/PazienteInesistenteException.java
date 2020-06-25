package gestore;

public class PazienteInesistenteException extends Exception {
	public PazienteInesistenteException() {
		super("Il paziente che si voleva rimuovere non è in lista....");
	}
}
