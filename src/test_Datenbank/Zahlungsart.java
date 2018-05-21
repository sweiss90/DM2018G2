package test_Datenbank;
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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Zahlungsart", discriminatorType=DiscriminatorType.STRING)
public class Zahlungsart {
	@Id
	@GeneratedValue
	private String transNr;
	private String zahlungsartNummer;
	private String kundennummer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="kunde", nullable=false, referencedColumnName="nr")
	private Kunde kunde;
	
	@OneToOne(mappedBy="zahlungsart")
	private Rechnung rechnung;
	
	public Zahlungsart(String zahlungsartNummer, String kundennummer) {
		this.zahlungsartNummer = zahlungsartNummer;
		this.kundennummer = kundennummer;
	}
	public Zahlungsart(String transNr, String zahlungsartNummer, String kundennummer){
		this(zahlungsartNummer, kundennummer);
		this.transNr=transNr;
	}
	public Zahlungsart(){
		
	}

	public String getTransNr() {
		return transNr;
	}
	public void setTransNr(String transNr) {
		this.transNr = transNr;
	}
	public String getZahlungsartNummer() {
		return zahlungsartNummer;
	}
	public void setZahlungsartNummer(String zahlungsartNummer) {
		this.zahlungsartNummer = zahlungsartNummer;
	}
	public String getKundennummer() {
		return kundennummer;
	}
	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}
	@Override
	public String toString(){
		return "{ TransNr = "+getTransNr()+", ZahlungsartNr= "+getZahlungsartNummer()+", Kundennummer= "+getKundennummer()+" }";
	}
	


}
