package referti;

import prog.utili.Data;

public abstract class Referto implements Comparable<Referto> {
	private Data data;
	private Paziente paziente;
	private int ID;
	private static int numeroDeiReferti = 0;
	public Referto(Data data, Paziente paziente) {
		this.data = data;
		this.paziente = paziente;
		numeroDeiReferti++;
		this.ID = numeroDeiReferti;
	}
	public Data getData() {
		return data;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public int getID() {
		return ID;
	}
	public static int getNumeroDeiReferti() {
		return numeroDeiReferti;
	}
	
	public abstract int criticity();
	public abstract boolean validity();
	
	@Override
	public int compareTo(Referto altro) {
		int a = this.criticity();
		int b = altro.criticity();
		return a - b;
	}
	public String toString() {
		return "DATA REFERTO: "+this.data.toString()+" PAZIENTE "+this.paziente.getCognome()+" "+this.paziente.getNome()
		            +this.paziente.getCodiceFiscale()+"  ID REFERTO:  "+this.ID;
	}
	
}
