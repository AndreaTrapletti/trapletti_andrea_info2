package referti;

import java.util.Vector;

import prog.utili.Data;

public class Paziente {
	public String codiceFiscale;
	private String nome, cognome;
	private Data dataDiNascita;
	private Sesso sesso;
	protected static Vector<String> codiciFiscaliClienti = new Vector<>();
	public Paziente(String nome, String cognome, Data dataDiNascita, Sesso sesso) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.codiceFiscale = calcoloCodiceFiscale();
		codiciFiscaliClienti.add(this.codiceFiscale);
	}
	private String calcoloCodiceFiscale() {
		String codice = "";
		if(this.nome.length() >= 3 && this.cognome.length() >=3)
		   codice = codice + this.nome.substring(0, 2) + this.cognome.substring(0, 2);
		else if(this.cognome.length()<3)
			codice = codice + this.nome.substring(0, 2);
		else 
			codice = codice + this.cognome.substring(0, 2);
		if(this.sesso == Sesso.MASCHIO)
			codice = codice + "M";
		else 
			codice = codice + "F";
		
		return codice + this.dataDiNascita.getAnno() + this.dataDiNascita.getMese()+this.dataDiNascita.getGiorno();
	}
	
	
}
