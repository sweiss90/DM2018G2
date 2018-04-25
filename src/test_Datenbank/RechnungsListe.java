package test_Datenbank;

import java.util.ArrayList;

public class RechnungsListe {
	private ArrayList<Rechnung> rechnungsListe;
	
	public RechnungsListe(){
		rechnungsListe=new ArrayList<>();
	}
	
	public void fügeRechnungHinzu(Rechnung r){
		rechnungsListe.add(r);
	}
	
	public void entferneRechnung(Rechnung r){
		rechnungsListe.remove(r);
	}
	
	public boolean enthältRechnung(Rechnung r){
		return rechnungsListe.contains(r);
	}

	public ArrayList<Rechnung> getRechnungsListe() {
		return rechnungsListe;
	}

	
	

}
