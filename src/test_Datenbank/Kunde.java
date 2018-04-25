package test_Datenbank;

public class Kunde {
	private int nr;
	private String vorname;
	private String nachname;
	private String telefonNr;
	private String email;
	private String anID;
	
	public Kunde(String vorname, String nachname, String telefonNr, String email, String anID) {
		//this.nr = nr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonNr = telefonNr;
		this.email = email;
		this.anID = anID;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAnID() {
		return anID;
	}

	public void setAnID(String anID) {
		this.anID = anID;
	}
	
	
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	@Override
	public boolean equals(Object kd){
		if(kd==null) return false;;
		if(kd==this) return true;
		Kunde kneu=(Kunde) kd;
		if(this.getNr()==kneu.getNr())
			return true;
		else 
			return false;
	}
	
	

}
