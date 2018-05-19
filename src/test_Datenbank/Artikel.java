package test_Datenbank;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Artikel")
public class Artikel {
	@Id
	@GeneratedValue
	private Integer id;
	private String bezeichnung;
	private Double preis;
	
	@OneToMany(mappedBy="artikel")
	private Set<Rechnung.Rechnungsposition> rechnungspositionen;
	
	public Artikel(Integer id, String bezeichnung, Double preis) {
		this(bezeichnung, preis);
		this.id = id;
	}
	public Artikel(String bezeichnung, Double preis){
		this.bezeichnung=bezeichnung;
		this.preis=preis;
	}
	public Integer getId() {
		return id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public Double getPreis() {
		return preis;
	}
	@Override
	public String toString() {
		return "{ ID= "+this.getId()+", Bezeichnung= "+this.getBezeichnung()+", Preis= "+this.getPreis()+" }";
	}
	
	
	

}
