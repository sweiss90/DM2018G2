package test_Datenbank;

import java.util.Iterator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.swing.JOptionPane;

@Entity
@DiscriminatorValue("3")
public class Überweisung extends Zahlungsart {
	private String erhalten;
	
	public Überweisung(String transNr, String erhalten){
		super(null, null, null);
		Zahlungsart za=überprüfeObZahlungsobjektBereitsVorhanden(transNr);
		if(za!=null){
			this.setTransNr(za.getTransNr());
			this.setZahlungsartNummer(za.getZahlungsartNummer());
			this.setKundennummer(za.getKundennummer());
			this.setErhalten(erhalten);
		}else
			JOptionPane.showMessageDialog(null, "ZahlungsartNummer existiert noch nicht!", "Fehler", JOptionPane.ERROR_MESSAGE);
			//Instanz auf NULL setzen wenn KNDR fehlerhaft oder nicht vorhanden
			//this=null;
	}
	public Überweisung(){}
	
	public String getErhalten() {
		return erhalten;
	}

	public void setErhalten(String erhalten) {
		this.erhalten = erhalten;
	}

	@Override
	public String toString(){
		return "{ TransNr= "+getTransNr()+", erhalten= "+getErhalten()+" }";
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



