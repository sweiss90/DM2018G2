package test_Datenbank;

public class Rechnung {
	private String nr;
	private String datum;
	private String bezahlt;
	private String zahlungsziel;
	private String kdNr;
	private String transNr;
	
	public Rechnung(String Datum, String bezahlt, String Zahlungsziel, String KdNr, String TransNr){
		this.datum=Datum;
		this.bezahlt=bezahlt;
		this.zahlungsziel=Zahlungsziel;
		this.kdNr=KdNr;
		this.transNr=TransNr;
	}
	public Rechnung(String nr, String Datum, String bezahlt, String Zahlungsziel, String KdNr, String TransNr){
		this(Datum, bezahlt, Zahlungsziel, KdNr, TransNr);
		this.nr=nr;
	}
	
	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(String bezahlt) {
		this.bezahlt = bezahlt;
	}

	public String getZahlungsziel() {
		return zahlungsziel;
	}

	public void setZahlungsziel(String zahlungsziel) {
		this.zahlungsziel = zahlungsziel;
	}

	public String getKdNr() {
		return kdNr;
	}

	public void setKdNr(String kdNr) {
		this.kdNr = kdNr;
	}

	public String getTransNr() {
		return transNr;
	}

	public void setTransNr(String transNr) {
		this.transNr = transNr;
	}
	
	   class Rechnungsposition{
		 
		private String positionsNr;
		private String artikelID;
		private String menge;
		
		public Rechnungsposition(String positionsNr, String artikelID, String menge) {
			
			this.positionsNr = positionsNr;
			this.artikelID = artikelID;
			this.menge = menge;
		}
		public String getNr(){
			return nr;
		}

		public String getPositionsNr() {
			return positionsNr;
		}

		public void setPositionsNr(String positionsNr) {
			this.positionsNr = positionsNr;
		}

		public String getArtikelID() {
			return artikelID;
		}

		public void setArtikelID(String artikelID) {
			this.artikelID = artikelID;
		}

		public String getMenge() {
			return menge;
		}

		public void setMenge(String menge) {
			this.menge = menge;
		}
		
	}
	@Override
	public String toString(){
		return ("{ "+this.getNr()+", "+this.getDatum()+", "+this.getBezahlt()+
				", "+this.getZahlungsziel()+", "+this.getKdNr()+", "+getTransNr()+" }");
	}
	   

}
