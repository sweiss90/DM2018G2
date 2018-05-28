package test_Datenbank;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Rechnungsposition")
@IdClass(RechnungspositionsId.class)
public class Rechnungsposition{
	 
	@Id private Integer positionsNr;
	private Integer menge;
	
	@ManyToOne
	@JoinColumn(name="rechnung")
	@Id private Rechnung rechnung;
	
	@ManyToOne
	@JoinColumn(name="artikel", nullable=false)
	private Artikel artikel;
	
	public Rechnungsposition(){
		//nötig wegen JPA
	}
	
	public Rechnungsposition(Integer positionsNr,  Integer menge, Rechnung r, Artikel a) {
		setPositionsNr(positionsNr);
		setMenge(menge);
		setRechnung(Objects.requireNonNull(r));
		setArtikel(Objects.requireNonNull(a));
	}
	
	public Rechnung getRechnung() {
		return rechnung;
	}

	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}

	public Integer getPositionsNr() {
		return positionsNr;
	}

	public void setPositionsNr(Integer positionsNr) {
		this.positionsNr = positionsNr;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public Integer getMenge() {
		return menge;
	}

	public void setMenge(Integer menge) {
		this.menge = menge;
	}
	@Override
	public String toString(){
		return "{ RechnungsID= "+getRechnung().getNr()+", PositionsNr= "+getPositionsNr()+", Artikel= "+getArtikel().getId()
				+", Menge= "+getMenge()+" }";
	}
}