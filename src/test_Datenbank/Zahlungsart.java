package test_Datenbank;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Zahlungsart", discriminatorType=DiscriminatorType.INTEGER)
public class Zahlungsart {
	@Id
	private Integer transNr;
	@ManyToOne()
	@JoinColumn(name="kunde", referencedColumnName="NR")
	private Kunde kunde;
	
	public Zahlungsart(Kunde kunde) {
		this.kunde = Objects.requireNonNull(kunde);
	}
	public Zahlungsart(Integer transNr, Kunde kunde){
		this(kunde);
		this.transNr=transNr;
	}
	public Zahlungsart(){
		//notwendig wegen JPA
	}

	public Integer getTransNr() {
		return transNr;
	}
	public void setTransNr(Integer transNr) {
		this.transNr = transNr;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	@Override
	public String toString(){
		return "{ TransNr = "+getTransNr()+", Kundennummer= "+getKunde()+" }";
	}
	


}
