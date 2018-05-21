package test_Datenbank;

import java.sql.SQLException;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
@Table(name="Kunde")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Typ")
public class Kunde {
	@Id 
	@GeneratedValue
	private int nr;
	private String vorname;
	private String nachname;
	private String telefonNr;
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="anschrift_Id", nullable=false, referencedColumnName="id")
	private Anschrift anschrift;
	
	@OneToMany(mappedBy="kunde")
	private Set<Rechnung> rechnungen;
	
	@OneToMany(mappedBy="kunde")
	private Set<Zahlungsart> zahlungsarten;
	
	public Kunde(){
		//notwendig wegen JPA
	}
	public Kunde(int nr, String vorname, String nachname, String telefonNr, String email, Anschrift anID) {
		this.nr = nr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonNr = telefonNr;
		this.email = email;
		this.anschrift = anID;
	}
	
	public void persistiere(DB db) throws SQLException{
		String sql="INSERT INTO kunde(Vorname, Nachname, Email, TelefonNr, AnID) VALUES (?,?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getVorname());
		db.getPs().setString(2, this.getNachname());
		db.getPs().setString(3, this.getEmail());
		db.getPs().setString(4, this.getTelefonNr());
		db.getPs().setString(5, this.getAnID().getId().toString());
		
		//SQL-Befehl absenden
		db.getPs().execute();
	}
	public void lösche(DB db) throws SQLException{
		String sql="DELETE FROM kunde WHERE Vorname=? AND Nachname=? AND Email=? AND TelefonNr=? AND AnID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getVorname());
		db.getPs().setString(2, this.getNachname());
		db.getPs().setString(3, this.getEmail());
		db.getPs().setString(4, this.getTelefonNr());
		db.getPs().setString(5, this.getAnID().getId().toString());
		
		//SQL-Befehl absenden
		db.getPs().execute();
	}
	public void ändere(DB db) throws SQLException{
		String sql="UPDATE kunde SET Vorname=?, Nachname=?, TelefonNr=?, Email=?, AnID=? WHERE Nr=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getVorname());
		db.getPs().setString(2, this.getNachname());
		db.getPs().setString(3, this.getTelefonNr());
		db.getPs().setString(4, this.getEmail());
		db.getPs().setString(5, this.getAnID().getId().toString());
		db.getPs().setString(6, new Integer(this.getNr()).toString());
		
		//SQL-Befehl absenden
		db.getPs().executeUpdate();
	}
	
	
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Anschrift getAnID() {
		return anschrift;
	}

	public void setAnID(Anschrift anID) {
		this.anschrift = anID;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	
	@Override
	public int hashCode(){
		return nr;
	}
	
	@Override
	public boolean equals(Object kd){
		if(kd==null) return false;;
		if(kd==this) return true;
		Kunde kneu=(Kunde) kd;
		if(this.getNr()==kneu.getNr())
			return true;
		else 
			return false;
	}
	@Override
	public String toString(){
		return ("{ "+this.getNr()+", "+this.getVorname()+", "+this.getNachname()+
				", "+this.getTelefonNr()+", "+this.getEmail()+", "+getAnID()+" }");
	}
	
	

}
