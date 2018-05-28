package test_Datenbank;

import java.util.Iterator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JOptionPane;

@Entity
@DiscriminatorValue("3")
public class �berweisung extends Zahlungsart {
	private String erhalten;
	
	public �berweisung(Integer transNr, Kunde kunde, String erhalten){
		super(transNr, kunde);
		this.erhalten=erhalten;
	}
	public �berweisung(){}
	
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
}



