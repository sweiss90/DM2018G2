package test_Datenbank;

import java.util.ArrayList;

public class RechnungspositionsListe {
	private ArrayList<Rechnung.Rechnungsposition> positionsListe;
	
	public RechnungspositionsListe(){
		positionsListe=new ArrayList<>();
	}
	
	public void f�gePositionEin(Rechnung.Rechnungsposition rp){
		//NULL-Pr�fungen notwendig?
		positionsListe.add(rp);
	}
	
	public void entfernePosition(Rechnung.Rechnungsposition rp){
		positionsListe.remove(rp);
	}
	
	public boolean enthaeltPosition(Rechnung.Rechnungsposition rp){
		return  positionsListe.contains(rp);
	}

	public ArrayList<Rechnung.Rechnungsposition> getPositionsListe() {
		return positionsListe;
	}

	

}
