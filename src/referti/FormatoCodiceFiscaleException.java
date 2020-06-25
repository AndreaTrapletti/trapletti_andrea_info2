package referti;


public class FormatoCodiceFiscaleException extends Exception {
	public FormatoCodiceFiscaleException() {
		super("Il formato del codice fiscale è inesatto");
	}
}
