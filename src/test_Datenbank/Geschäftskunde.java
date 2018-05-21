package test_Datenbank;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.JOptionPane;

@Entity
@Table(name="Geschäftskunde")
@DiscriminatorValue("G_Kunde")
public class Geschäftskunde extends Kunde{
	private String Firmenname;
	
	@ManyToOne
	@JoinColumn(name="Rechtsform", nullable=false)
	private Rechtsform rechtsform;
	
	public Geschäftskunde(){}
	
	public Geschäftskunde(String firmenname, Rechtsform rechtsform) {
		setFirmenname(firmenname);
		setRechtsform(rechtsform);
	}
	public String getFirmenname() {
		return Firmenname;
	}

	public void setFirmenname(String firmenname) {
		Firmenname = firmenname;
	}

	public Rechtsform getRechtsform() {
		return rechtsform;
	}

	public void setRechtsform(Rechtsform rechtsform) {
		rechtsform=rechtsform;
	}
	
	@Override
	public String toString(){
		return "{ Firmenname= "+getFirmenname()+", RechtsformID= "+getRechtsform()+" }";
	}
	
	

}
