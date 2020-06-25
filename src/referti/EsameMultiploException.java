package referti;

public class EsameMultiploException extends Exception {
	public EsameMultiploException() {
		super("Non son state inserite coppie di valore nel Esame Multiplo referto");
	}
}
