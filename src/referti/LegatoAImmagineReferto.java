package referti;

import prog.utili.Data;

public class LegatoAImmagineReferto extends Referto {
	private String nomeFile;
	private String testo;
	private Dottore dottoreCheHaFirmato;
	public LegatoAImmagineReferto(Data data, Paziente paziente, String nomeFile, String testo,
			Dottore dottoreCheHaFirmato) {
		super(data, paziente);
		this.nomeFile = nomeFile;
		this.testo = testo;
		this.dottoreCheHaFirmato = dottoreCheHaFirmato;
	}
	public String getNomeFile() {
		return nomeFile;
	}
	
	public String getTesto() {
		return testo;
	}

	public Dottore getDottoreCheHaFirmato() {
		return dottoreCheHaFirmato;
	}
	@Override
	public int criticity() {
		if(this.testo.equals("critico")) 
			return 9;
		else 
			return 0;
	}
	@Override
	public boolean validity() {
		
		if(criticity() == 9 ) return true;
		else {
			Data oggi = new Data();
			if(oggi.quantoManca(super.getData()) >= 2) return true;
			else return false;
		}
		
	}
	@Override
	public String toString() {
		return "LEGATO A IMMAGINE   " + super.toString()+ "HA FIRMATO IL DOTTOR: "+ this.dottoreCheHaFirmato.cognome
				+"  "+this.dottoreCheHaFirmato.nome;
	}
	
	
}
