package test_Datenbank;

public class Land {
	private String id;
	private String land;
	
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
