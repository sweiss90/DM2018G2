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
@Table(name="Anschrift")
public class Anschrift {
	
	@Id 
	@GeneratedValue
	private Integer id;
	private String strasse;
	private Integer hausNr;
	private String plZ;
	private String ort;
	
	@ManyToOne
	@JoinColumn(name="land", nullable=false)
	private Land land;
	
	@OneToMany(mappedBy="anschrift")
	private Set<Kunde> kunden;
	
	public Anschrift(Integer id,String strasse, Integer hausNr, String plZ, String ort, Land land) {
		this.id=id;
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.plZ = plZ;
		this.ort = ort;
		this.land = land;
	}
	
	public Anschrift(){
		//notwendig wegen JPA
	}
	public String getStrasse() {
		return strasse;
	}

	public Integer getHausNr() {
		return hausNr;
	}

	public String getPlZ() {
		return plZ;
	}

	public String getOrt() {
		return ort;
	}

	public Land getLand() {
		return land;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString(){
		return "{ "+ this.getId()+", "+this.getStrasse()+", "+this.getHausNr()+
				", "+this.getPlZ()+", "+this.getOrt()+", "+this.getLand()+" }";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setHausNr(Integer hausNr) {
		this.hausNr = hausNr;
	}

	
}
