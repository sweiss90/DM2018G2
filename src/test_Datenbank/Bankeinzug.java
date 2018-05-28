package test_Datenbank;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.JOptionPane;

@Entity
@DiscriminatorValue("1")
public class Bankeinzug extends Zahlungsart{
	
	private String iban;
	private String bic;
	
	public Bankeinzug(){
		//notwendig wegen JPA
	}
	public Bankeinzug(Integer transNr, Kunde kunde, String iban, String bic){
		super(transNr, kunde);
		this.iban=iban;
		this.bic=bic;
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
}
