package test_Datenbank;

import java.util.Set;

import javax.persistence.OneToMany;

public class Land {
	private String id;
	private String land;
	
	@OneToMany(mappedBy="land")
	private Set<Anschrift> anschriften;
	
	public Land(String id, String land){
		this.id=id;
		this.land=land;
	}

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
