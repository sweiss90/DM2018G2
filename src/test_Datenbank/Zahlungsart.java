package test_Datenbank;

public class Zahlungsart {
	private String transNr;
	private String zahlungsartNummer;
	private String kundennummer;
	
	public Zahlungsart(String zahlungsartNummer, String kundennummer) {
		this.zahlungsartNummer = zahlungsartNummer;
		this.kundennummer = kundennummer;
	}
	public Zahlungsart(String transNr, String zahlungsartNummer, String kundennummer){
		this(zahlungsartNummer, kundennummer);
		this.transNr=transNr;
	}

	public String getTransNr() {
		return transNr;
	}
	public void setTransNr(String transNr) {
		this.transNr = transNr;
	}
	public String getZahlungsartNummer() {
		return zahlungsartNummer;
	}
	public void setZahlungsartNummer(String zahlungsartNummer) {
		this.zahlungsartNummer = zahlungsartNummer;
	}
	public String getKundennummer() {
		return kundennummer;
	}
	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}
	@Override
	public String toString(){
		return "{ TransNr = "+getTransNr()+", ZahlungsartNr= "+getZahlungsartNummer()+", Kundennummer= "+getKundennummer()+" }";
	}
	


}
