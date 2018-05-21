package test_Datenbank;

import java.sql.SQLException;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rechtsform")
public class Rechtsform {
	@Id
	@GeneratedValue
	private Integer id;
	private String rechtsform;
	
	@OneToMany(mappedBy="rechtsform")
	private Set<Geschäftskunde> geschäftskunden;
	
	public Rechtsform(Integer id, String rechtsform) {
		this(rechtsform);
		this.id = id;
	}
	public Rechtsform(String rechtsform){
		this.rechtsform=rechtsform;
	}
	public Rechtsform(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRechtsform() {
		return rechtsform;
	}
	public void setRechtsform(String rechtsform) {
		this.rechtsform = rechtsform;
	}
	@Override
	public String toString(){
		return "{ ID= "+getId()+", Rechtsform= "+getRechtsform()+" }";
	}
	
	public void persistiere(DB db) throws SQLException{
		String sql="INSERT INTO unternehmensform(ID, Rechtsform) VALUES(?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setInt(1, this.getId());
		db.getPs().setString(2, this.getRechtsform());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
	}
	public void lösche(DB db) throws SQLException{
		String sql="DELETE FROM unternehmensform WHERE ID=? AND Rechtsform=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setInt(1, this.getId());
		db.getPs().setString(2, this.getRechtsform());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
	}
	public void ändere(DB db) throws SQLException{
		String sql="UPDATE unternehmensform SET Rechtsform=? WHERE ID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, this.getRechtsform());
		db.getPs().setInt(2, this.getId());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
	}
	
	
	

}
