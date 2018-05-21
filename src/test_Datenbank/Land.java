package test_Datenbank;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Land")
public class Land {
	@Id
	@GeneratedValue
	private String id;
	private String land;
	
	@OneToMany(mappedBy="land")
	private Set<Anschrift> anschriften;
	
	public Land(String id, String land){
		this.id=id;
		this.land=land;
	}

	public Land(){}
	public String getId() {
		return id;
	}

	public String getLand() {
		return land;
	}
	@Override
	public String toString(){
		return "{ ID= "+getId()+", Land= "+getLand()+" }";
	
	}
	

}
