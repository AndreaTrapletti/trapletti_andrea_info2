package referti;

import prog.utili.Data;

public class SingoloReferto extends Referto {
	private RisultatoReferto risultato;

	public SingoloReferto(Data data, Paziente paziente, RisultatoReferto risultato) {
		super(data, paziente);
		this.risultato = risultato;
	}

	public RisultatoReferto getRisultato() {
		return risultato;
	}

	@Override
	public int criticity() {
		return this.risultato.risultatoValore;
	}

	@Override
	public boolean validity() {
		Data oggi = new Data();
		if(oggi.quantoManca(super.getData()) >= 5 ) return true;
		else return false;
		
	}
	@Override
	public String toString() {
		return "SINGOLO   " + super.toString()+ "Risultato " + this.risultato;
	}
}
