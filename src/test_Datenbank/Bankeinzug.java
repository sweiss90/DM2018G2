package test_Datenbank;

import java.util.*;

import javax.swing.JOptionPane;

public class Bankeinzug extends Zahlungsart{
	private String iban;
	private String bic;
	
	public Bankeinzug(String transNr, String iban, String bic){
		super(null, null, null);
		Zahlungsart za=überprüfeObZahlungsobjektBereitsVorhanden(transNr);
		if(za!=null){
			this.setTransNr(za.getTransNr());
			this.setZahlungsartNummer(za.getZahlungsartNummer());
			this.setKundennummer(za.getKundennummer());
			this.setIban(iban);
			this.setBic(bic);
		}else
			JOptionPane.showMessageDialog(null, "ZahlungsartNummer existiert noch nicht!", "Fehler", JOptionPane.ERROR_MESSAGE);
			//Instanz auf NULL setzen wenn KNDR fehlerhaft oder nicht vorhanden
			//this=null;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	
	@Override
	public String toString(){
		return "{ TransNr= "+super.getTransNr()+", IBAN= "+getIban()+", BIC= "+getBic()+" }";
	}
	
	public static Zahlungsart überprüfeObZahlungsobjektBereitsVorhanden(String TransNr){
		Zahlungsart za=null;
		Iterator<Zahlungsart> it=ZahlungsartListe.getZahlungsartListe().getZaListe().iterator();
		while(it.hasNext()){
			za=it.next();
			if(za.getTransNr().equals(TransNr))
				return za;
		}
		return null;
	}
	

}
