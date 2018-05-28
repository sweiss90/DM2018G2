package test_Datenbank;

import java.util.Iterator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JOptionPane;

@Entity
@DiscriminatorValue("2")
public class Kreditkarte extends Zahlungsart {
	//@Id
	//private Integer transId;
	private String kaNr=null;
	private String ablaufdatum=null;
	
	public Kreditkarte(Integer transId, Kunde kunde, String kaNr, String ablaufdatum){
		super(transId, kunde);
		setKaNr(kaNr);
		setAblaufdatum(ablaufdatum);
	}
	public Kreditkarte(){
		
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
	
	

}
