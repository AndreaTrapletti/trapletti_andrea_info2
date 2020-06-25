package referti;

import java.util.Vector;
import prog.utili.Data;
import prog.utili.Sequenza;

public class EsamiMultipliReferto extends Referto {
	
	private Vector<Coppia<String, Integer>> sequenza = new Vector<>();
	
	
	public EsamiMultipliReferto(Data data, Paziente paziente) {
		super(data, paziente);
		
	}
	
	public void aggiungiCoppia(String s, Integer i) {
		this.sequenza.add(new Coppia<String, Integer>(s, i));
	}
	

	public Vector<Coppia<String, Integer>> getSequenza() {
		return sequenza;
	}
	


	@Override
	public int criticity() {
		int i = 0;
		try {
			i = calcolaMediaValori();
		} catch (EsameMultiploException e) {
			
			e.printStackTrace();
		}
		int s; 
		s = trovaValorePiùAlto();
		return (s - i)*10;
	}
	
	private int calcolaMediaValori() throws EsameMultiploException{
		
		int totale=0;
		
		for(int j = 0; j<this.sequenza.size(); j++) {
			
			totale = totale + this.sequenza.get(j).getDx();
		}
		int r = sequenza.size();
		if(totale == 0) throw new EsameMultiploException();
		return totale/r;
	}
	
	private int trovaValorePiùAlto() {
		Integer[] valori = new Integer[sequenza.size()];
		boolean trovato;
		do {
			Integer temp;
			trovato = false;
			for(int i=1; i<valori.length; i++) {
				if(valori[i]>valori[i-1]) {
					trovato = true;
					temp = valori[i];
					valori[i] = valori[i-1];
					valori[i-1] = temp;
				}
			}
		}while(trovato);
		return valori[0];
	}

	@Override
	public boolean validity() {
		
		int c;
		c = criticity();
		Data oggi = new Data();
		if((c/super.getData().quantoManca(oggi)) > 2) return true;
		else return false;
		
	}
	
	@Override
	public String toString() {
		return "ESAMI MULTIPLI   " + super.toString();
	}
	
}
