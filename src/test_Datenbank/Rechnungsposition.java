package test_Datenbank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Rechnungsposition")
public class Rechnungsposition{
	 
	@Id
	@GeneratedValue
	private String positionsNr;
	private String menge;
	
	@ManyToOne
	@JoinColumn(name="rechnung")
	private Rechnung rechnung;
	
	@ManyToOne
	@JoinColumn(name="artikel", nullable=false)
	private Artikel artikel;
	
	public Rechnungsposition(){
		
	}
	
	public Rechnungsposition(String positionsNr, String artikelID, String menge) {
		
		this.positionsNr = positionsNr;

		this.menge = menge;
	}


	public String getPositionsNr() {
		return positionsNr;
	}

	public void setPositionsNr(String positionsNr) {
		this.positionsNr = positionsNr;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public String getMenge() {
		return menge;
	}

	public void setMenge(String menge) {
		this.menge = menge;
	}
	@Override
	public String toString(){
		return "{ RechnungsID= "+getNr()+", PositionsNr= "+getPositionsNr()+", Artikel= "+getArtikel()
				+", Menge= "+getMenge()+" }";
	}
}