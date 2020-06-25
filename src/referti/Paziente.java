package referti;

import java.util.Vector;

import prog.io.FileInputManager;
import prog.io.FileNonPresenteException;
import prog.utili.Data;

public class Paziente {
	private String codiceFiscale;
	private String nome, cognome;
	private Data dataDiNascita;
	private Sesso sesso;
	public Paziente(String nome, String cognome, Data dataDiNascita, Sesso sesso) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.codiceFiscale = calcoloCodiceFiscale();
		
	}
	
	public Paziente(String nome, String cognome, Data dataDiNascita, Sesso sesso, String fileCodice)
	      throws FormatoCodiceFiscaleException {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		if(FileInputManager.exists(fileCodice)) {
			FileInputManager file = new FileInputManager(fileCodice);
			String rigaString = file.readLine();
			if(rigaString.length()<12 || rigaString.length()>15 )
				throw new FormatoCodiceFiscaleException();
			else
			    this.codiceFiscale = rigaString;
		}else throw new FileNonPresenteException("File non trovato");
		
		
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	
	public String getNome() {
		return nome;
	}

	

	public String getCognome() {
		return cognome;
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
