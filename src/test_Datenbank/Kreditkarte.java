package test_Datenbank;

import java.util.Iterator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.swing.JOptionPane;

@Entity
@DiscriminatorValue("2")
public class Kreditkarte extends Zahlungsart {
	private String kaNr=null;
	private String ablaufdatum=null;
	
	public Kreditkarte(String kaNr, String ablaufdatum){
		setKaNr(kaNr);
		setAblaufdatum(ablaufdatum);
	}
	public Kreditkarte(){}
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
	
	

}
