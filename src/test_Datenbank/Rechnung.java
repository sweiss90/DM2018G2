package test_Datenbank;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rechnung")
public class Rechnung {
	@Id
	@GeneratedValue
	private Integer nr;
	private String datum;
	private String bezahlt;
	private String zahlungsziel;
	
	@ManyToOne
	@JoinColumn(name="kunde", nullable=false)
	private Kunde kunde;
	
	@OneToMany(mappedBy="rechnung")
	private Set<Rechnung.Rechnungsposition> rechnungspositionen;
	
	private String transNr;
	
	public Rechnung(){
		//notwendig wegen JPA
	}
	
	public Rechnung(String Datum, String bezahlt, String Zahlungsziel, Kunde kunde, String TransNr){
		this.datum=Datum;
		this.bezahlt=bezahlt;
		this.zahlungsziel=Zahlungsziel;
		this.kunde=kunde;
		this.transNr=TransNr;
	}
	public Rechnung(Integer nr, String Datum, String bezahlt, String Zahlungsziel, Kunde kunde, String TransNr){
		this(Datum, bezahlt, Zahlungsziel, kunde, TransNr);
		this.nr=nr;
	}
	
	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(String bezahlt) {
		this.bezahlt = bezahlt;
	}

	public String getZahlungsziel() {
		return zahlungsziel;
	}

	public void setZahlungsziel(String zahlungsziel) {
		this.zahlungsziel = zahlungsziel;
	}

	public Kunde getKdNr() {
		return kunde;
	}

	public void setKdNr(Kunde kdNr) {
		this.kunde = kdNr;
	}

	public String getTransNr() {
		return transNr;
	}

	public void setTransNr(String transNr) {
		this.transNr = transNr;
	}
	   @Entity
	   @Table(name="Rechnungsposition")
	   class Rechnungsposition{
		 
		private String positionsNr;
		private String artikelID;
		private String menge;
		
		@ManyToOne
		@JoinColumn(name="rechnung", nullable=false)
		private Rechnung rechnung;
		
		@ManyToOne
		@JoinColumn(name="artikel", nullable=false)
		private Artikel artikel;
		
		public Rechnungsposition(String positionsNr, String artikelID, String menge) {
			
			this.positionsNr = positionsNr;
			this.artikelID = artikelID;
			this.menge = menge;
		}
		public Integer getNr(){
			return nr;
		}

		public String getPositionsNr() {
			return positionsNr;
		}

		public void setPositionsNr(String positionsNr) {
			this.positionsNr = positionsNr;
		}

		public String getArtikelID() {
			return artikelID;
		}

		public void setArtikelID(String artikelID) {
			this.artikelID = artikelID;
		}

		public String getMenge() {
			return menge;
		}

		public void setMenge(String menge) {
			this.menge = menge;
		}
		@Override
		public String toString(){
			return "{ RechnungsID= "+getNr()+", PositionsNr= "+getPositionsNr()+", Artikel= "+getArtikelID()
					+", Menge= "+getMenge()+" }";
		}
	}
	@Override
	public String toString(){
		return "{ "+this.getNr()+", "+this.getDatum()+", "+this.getBezahlt()+
				", "+this.getZahlungsziel()+", "+this.getKdNr()+", "+getTransNr()+" }";
	}
	   

}
