package test_Datenbank;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class Kreditkarte extends Zahlungsart {
	private String kaNr=null;
	private String ablaufdatum=null;
	
	public Kreditkarte(String transNr, String kaNr, String ablaufdatum){
		super(null, null, null);
		Zahlungsart za=überprüfeObZahlungsobjektBereitsVorhanden(transNr);
		if(za!=null){
			this.setTransNr(za.getTransNr());
			this.setZahlungsartNummer(za.getZahlungsartNummer());
			this.setKundennummer(za.getKundennummer());
			this.setKaNr(kaNr);
			this.setAblaufdatum(ablaufdatum);
		}else
			JOptionPane.showMessageDialog(null, "ZahlungsartNummer existiert noch nicht!", "Fehler", JOptionPane.ERROR_MESSAGE);
			//Instanz auf NULL setzen wenn KNDR fehlerhaft oder nicht vorhanden
			//this=null;
	}
	public String getKaNr() {
		return kaNr;
	}
	public void setKaNr(String kaNr) {
		this.kaNr = kaNr;
	}
	public String getAblaufdatum() {
		return ablaufdatum;
	}
	public void setAblaufdatum(String ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}
	@Override
	public String toString(){
		return "{ TransNr= "+super.getTransNr()+", KartenNr= "+getKaNr()+", Ablaufdatum= "+getAblaufdatum()+" }";
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
