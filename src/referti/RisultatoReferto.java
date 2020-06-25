package referti;

public enum RisultatoReferto {
	POSITIVO(20), NEGATIVO(0), DUBBIO(10);
	
	protected int risultatoValore;
	
	private RisultatoReferto(int risultato) {
		this.risultatoValore=risultato;
	}
}
