package referti;

import java.util.Vector;

import prog.utili.Data;
import prog.utili.Sequenza;

public class EsamiMultipliReferto extends Referto {
	
	private Coppia<String, Integer> coppia;
	private Vector<Coppia<String, Integer>> sequenza = new Vector<>();
	
	
	public EsamiMultipliReferto(Data data, Paziente paziente) {
		super(data, paziente);
		this.coppia = coppia;
	}
	
	public void aggiungiCoppia(String s, Integer i) {
		this.sequenza.add(new Coppia<String, Integer>(s, i));
	}
	

	public Vector<Coppia<String, Integer>> getSequenza() {
		return sequenza;
	}
	


	@Override
	public int criticity() {
		int i = calcolaMediaValori();
		int s = trovaValorePiùAlto();
	}
	
	public int calcolaMediaValori() {
		
		int totale=0;
		
		for(int i = 0; i<this.sequenza.size(); i++) {
			
			totale = totale + this.sequenza.get(i).getDx();
		}
		return totale/sequenza.size();
	}
	
	public int trovaValorePiùAlto() {
		Integer valore = new Integer(sequenza.size());
		
	}

	@Override
	public boolean validity() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
