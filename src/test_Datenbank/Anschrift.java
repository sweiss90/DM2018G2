package test_Datenbank;

public class Anschrift {
	private String id;
	private String strasse;
	private String hausNr;
	private String plZ;
	private String ort;
	private String laID;
	
	public Anschrift(String id,String strasse, String hausNr, String plZ, String ort, String laID) {
		this.id=id;
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.plZ = plZ;
		this.ort = ort;
		this.laID = laID;
	}
	public String getStrasse() {
		return strasse;
	}

	public String getHausNr() {
		return hausNr;
	}

	public String getPlZ() {
		return plZ;
	}

	public String getOrt() {
		return ort;
	}

	public String getLaID() {
		return laID;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString(){
		return "{ "+ this.getId()+", "+this.getStrasse()+", "+this.getHausNr()+
				", "+this.getPlZ()+", "+this.getOrt()+", "+this.getLaID()+" }";
	}

	
}
