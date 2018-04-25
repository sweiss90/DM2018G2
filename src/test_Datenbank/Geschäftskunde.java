package test_Datenbank;

public class Geschäftskunde extends Kunde{
	private String KDNr;
	private String Firmenname;
	private String RechtsformID;
	
	public Geschäftskunde(String kDNr, String firmenname, String rechtsformID) {
		super(null, null, null, null, null);
		this.KDNr=kDNr;
		this.Firmenname=firmenname;
		this.RechtsformID=rechtsformID;
	}

	public String getKDNr() {
		return KDNr;
	}

	public void setKDNr(String kDNr) {
		KDNr = kDNr;
	}

	public String getFirmenname() {
		return Firmenname;
	}

	public void setFirmenname(String firmenname) {
		Firmenname = firmenname;
	}

	public String getRechtsformID() {
		return RechtsformID;
	}

	public void setRechtsformID(String rechtsformID) {
		RechtsformID = rechtsformID;
	}
	
	
	
	

}
