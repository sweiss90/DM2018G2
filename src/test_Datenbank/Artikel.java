package test_Datenbank;

public class Artikel {
	private String id;
	private String bezeichnung;
	private String preis;
	
	public Artikel(String id, String bezeichnung, String preis) {
		this(bezeichnung, preis);
		this.id = id;
	}
	public Artikel(String bezeichnung, String preis){
		this.bezeichnung=bezeichnung;
		this.preis=preis;
	}
	public String getId() {
		return id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public String getPreis() {
		return preis;
	}
	@Override
	public String toString() {
		return "{ ID= "+this.getId()+", Bezeichnung= "+this.getBezeichnung()+", Preis= "+this.getPreis()+" }";
	}
	
	
	

}
