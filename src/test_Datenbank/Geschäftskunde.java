package test_Datenbank;

import java.util.*;

import javax.swing.JOptionPane;

public class Geschäftskunde extends Kunde{
	private String KDNr;
	private String Firmenname;
	private String RechtsformID;
	
	public Geschäftskunde(String kDNr, String firmenname, String rechtsformID) {
		super(null, null, null, null, null, null);
		Kunde k=überprüfeObKundeBereitsVorhanden(kDNr);
		if(k!=null){
			//this.setVorname(k.getNr());
			this.setVorname(k.getVorname());
			this.setNachname(k.getNachname());
			this.setTelefonNr(k.getTelefonNr());
			this.setEmail(k.getEmail());
			this.KDNr=kDNr;
			this.Firmenname=firmenname;
			this.RechtsformID=rechtsformID;
		}else
			JOptionPane.showMessageDialog(null, "Kundennummer existiert noch nicht!", "Fehler", JOptionPane.ERROR_MESSAGE);
			//Instanz auf NULL setzen wenn KNDR fehlerhaft oder nicht vorhanden
			//this=null;
	}
	public String getKDNr() {
		return KDNr;
	}

	public void setKDNr(String kDNr) {
		KDNr = kDNr;
	}

	public String getFirmenname() {
		return Firmenname;
	}

	public void setFirmenname(String firmenname) {
		Firmenname = firmenname;
	}

	public String getRechtsformID() {
		return RechtsformID;
	}

	public void setRechtsformID(String rechtsformID) {
		RechtsformID = rechtsformID;
	}
	
	private static Kunde überprüfeObKundeBereitsVorhanden(String nr){
		Kunde k=null;
		Iterator<Kunde> it=KundenListe.getkundenListe().getkListe().iterator();
		while(it.hasNext()){
			k=it.next();
			if(k.getNr().equals(nr))
				return k;
		}
		return null;
	}
	@Override
	public String toString(){
		return "{ KDNr= "+getKDNr()+", Firmenname= "+getFirmenname()+", RechtsformID= "+getRechtsformID()+" };";
	}
	
	

}
