package test_Datenbank;

import java.sql.SQLException;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private Set<Rechnungsposition> rechnungspositionen;
	
	@OneToOne
	@JoinColumn(name="TransNr")
	private Zahlungsart zahlungsart;
	
	public Rechnung(){
		//notwendig wegen JPA
	}
	
	public Rechnung(String Datum, String bezahlt, String Zahlungsziel, Kunde kunde, Zahlungsart zArt){
		this.datum=Datum;
		this.bezahlt=bezahlt;
		this.zahlungsziel=Zahlungsziel;
		this.kunde=kunde;
		this.zahlungsart=zArt;
	}
	public Rechnung(Integer nr, String Datum, String bezahlt, String Zahlungsziel, Kunde kunde, Zahlungsart zArt){
		this(Datum, bezahlt, Zahlungsziel, kunde, zArt);
		this.nr=nr;
	}
	public void persistiere(DB db) throws SQLException{
		String sql="INSERT INTO rechnung(Datum, Bezahlt, Zahlungsziel, KdNr, TransNr) VALUES (?,?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getDatum());
		db.getPs().setString(2, this.getBezahlt());
		db.getPs().setString(3, this.getZahlungsziel());
		db.getPs().setInt(4, this.getKdNr().getNr());
		db.getPs().setString(5, this.getZahlungsart().getTransNr());
		
		
		//SQL-Befehl absenden
		db.getPs().execute();
	}
	public void lösche(DB db) throws SQLException{
		String sql="DELETE FROM rechnung WHERE Datum=? AND Bezahlt=? AND Zahlungsziel=? AND KdNr=? AND TransNr=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getDatum());
		db.getPs().setString(2, this.getBezahlt());
		db.getPs().setString(3, this.getZahlungsziel());
		db.getPs().setInt(4, this.getKdNr().getNr());
		db.getPs().setString(5, this.getZahlungsart().getTransNr());
		
		//SQL-Befehl absenden
		db.getPs().execute();
	}
	public void ändere(DB db) throws SQLException{
		String sql="UPDATE rechnung SET Datum=?, Bezahlt=?, Zahlungsziel=?, KdNr=?, TransNr=? WHERE Nr=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getDatum());
		db.getPs().setString(2, this.getBezahlt());
		db.getPs().setString(3, this.getZahlungsziel());
		db.getPs().setInt(4, this.getKdNr().getNr());
		db.getPs().setString(5, this.getZahlungsart().getTransNr());
		db.getPs().setInt(6, this.getNr());

		
		//SQL-Befehl absenden
		db.getPs().executeUpdate();
	}
	
	public Integer getNr() {
		return nr;
	}

	public Zahlungsart getZahlungsart() {
		return zahlungsart;
	}

	public void setZahlungsart(Zahlungsart zahlungsart) {
		this.zahlungsart = zahlungsart;
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

	  
	@Override
	public String toString(){
		return "{ "+this.getNr()+", "+this.getDatum()+", "+this.getBezahlt()+
				", "+this.getZahlungsziel()+", "+this.getKdNr()+", "+zahlungsart.getTransNr().toString()+" }";
	}
	   

}
