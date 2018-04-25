package test_Datenbank;

public class Anschrift {
	private int id;
	private String strasse;
	private String hausNr;
	private String plZ;
	private String ort;
	private String laID;
	
	public Anschrift(String strasse, String hausNr, String plZ, String ort, String laID) {
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

	
}
