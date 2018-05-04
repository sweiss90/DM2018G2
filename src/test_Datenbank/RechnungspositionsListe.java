package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RechnungspositionsListe {
	//Singleton-Pattern
	private static RechnungspositionsListe rechnungspositionsListe;
	private ArrayList<Rechnung.Rechnungsposition> rpListe;
	
	private RechnungspositionsListe(){
		rpListe=new ArrayList<>();
	}
	public void fügePositionEin(Rechnung.Rechnungsposition rp){
		//NULL-Prüfungen notwendig?
		rpListe.add(rp);
	}
	public void entfernePosition(Rechnung.Rechnungsposition rp){
		rpListe.remove(rp);
	}
	public boolean enthaeltPosition(Rechnung.Rechnungsposition rp){
		return rpListe.contains(rp);
	}
	public static RechnungspositionsListe getRechnungspositionsListe(){
		if(rechnungspositionsListe==null)
			rechnungspositionsListe=new RechnungspositionsListe();
		return rechnungspositionsListe;
	}
	public ArrayList<Rechnung.Rechnungsposition> getRpListe() {
		return rpListe;
	}
	public void leereListe(){
		rpListe.clear();
	}
	public void fügeRechnungspositionEin(DB db, Rechnung.Rechnungsposition rp) throws SQLException{
		String sql="INSERT INTO rechnungsposition(RechnungsID, PositionsNr, ArtikelID, Menge) VALUES(?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, rp.getNr());
		db.getPs().setString(2, rp.getPositionsNr());
		db.getPs().setString(3, rp.getArtikelID());
		db.getPs().setString(4, rp.getMenge());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechnungspositionsListe().fügePositionEin(rp);
		
	}
	public void löscheRechnungsposition(DB db, Rechnung.Rechnungsposition rp) throws SQLException{
		String sql="DELETE FROM rechnungsposition WHERE RechnungsID=? AND PositionsNr=? AND ArtikelID=? AND Menge=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, rp.getNr());
		db.getPs().setString(2, rp.getPositionsNr());
		db.getPs().setString(3, rp.getArtikelID());
		db.getPs().setString(4, rp.getMenge());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechnungspositionsListe().entfernePosition(rp);
	}
	public void rechnungsPositionsListeAktualisieren(DB db) throws SQLException{
		getRechnungspositionsListe().leereListe();
		String sql="SELECT * FROM rechnungsposition;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Rechnung r=new Rechnung(datensatz.get("RechnungsID"), null, null, null, null, null);
			Rechnung.Rechnungsposition rp=r.new Rechnungsposition(datensatz.get("PositionsNr"), datensatz.get("ArtikelID"), datensatz.get("Menge"));
			this.fügePositionEin(rp);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Rechnung.Rechnungsposition rp:rpListe){
			erg+=rp+"<br>";
		}
		return erg+="</HTML>";
	}

	

}
