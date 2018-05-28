package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RechnungspositionsListe {
	//Singleton-Pattern
	private static RechnungspositionsListe rechnungspositionsListe;
	private ArrayList<Rechnungsposition> rpListe;
	
	private RechnungspositionsListe(){
		rpListe=new ArrayList<>();
	}
	public void fügePositionEin(Rechnungsposition rp){
		rpListe.add(rp);
	}
	public void entfernePosition(Rechnungsposition rp){
		rpListe.remove(rp);
	}
	public boolean enthaeltPosition(Rechnungsposition rp){
		return rpListe.contains(rp);
	}
	public static RechnungspositionsListe getRechnungspositionsListe(){
		if(rechnungspositionsListe==null)
			rechnungspositionsListe=new RechnungspositionsListe();
		return rechnungspositionsListe;
	}
	public ArrayList<Rechnungsposition> getRpListe() {
		return rpListe;
	}
	public void leereListe(){
		rpListe.clear();
	}
	public void fügeRechnungspositionEin(DB db, Rechnungsposition rp) throws SQLException{
		String sql="INSERT INTO rechnungsposition(RechnungsID, PositionsNr, ArtikelID, Menge) VALUES(?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, rp.getNr());
		//db.getPs().setString(2, rp.getPositionsNr());
		//db.getPs().setString(3, rp.getArtikelID());
		//db.getPs().setString(4, rp.getMenge());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechnungspositionsListe().fügePositionEin(rp);
		
	}
	public void löscheRechnungsposition(DB db, Rechnungsposition rp) throws SQLException{
		String sql="DELETE FROM rechnungsposition WHERE RechnungsID=? AND PositionsNr=? AND ArtikelID=? AND Menge=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, rp.getNr());
		//db.getPs().setString(2, rp.getPositionsNr());
		//db.getPs().setString(3, rp.getArtikelID());
		//db.getPs().setString(4, rp.getMenge());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechnungspositionsListe().entfernePosition(rp);
	}
	public void ändereRechnungsposition(DB db, Rechnungsposition rpNeu, Rechnungsposition rpAlt ) throws SQLException{
		String sql="UPDATE rechnungsposition SET PositionsNr=?, ArtikelID=?, Menge=? WHERE RechnungsID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, rpNeu.getPositionsNr());
		//db.getPs().setString(2, rpNeu.getArtikelID());
		//db.getPs().setString(3, rpNeu.getMenge());
		//db.getPs().setString(4, rpNeu.getNr());
		
		//SQL-Befehl absetzen
		db.getPs().executeUpdate();
		getRechnungspositionsListe().entfernePosition(rpAlt);
		getRechnungspositionsListe().fügePositionEin(rpNeu);
	}
	public void rechnungsPositionsListeAktualisieren(DB db) throws SQLException{
		getRechnungspositionsListe().leereListe();
		String sql="SELECT * FROM rechnungsposition;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String rId=datensatz.get("RechnungsID");
			String aId=datensatz.get("ArtikelID");
			for(Rechnung r:RechnungsListe.getRechnungsListe().getRListe()){
				if(String.valueOf(r.getNr()).equals(rId)){
					for(Artikel a:ArtikelListe.getArtikelListe().getaListe()){
						if(String.valueOf(a.getId()).equals(aId)){
							Rechnungsposition rp=new Rechnungsposition(Integer.parseInt(datensatz.get("PositionsNr")),  
									Integer.parseInt(datensatz.get("Menge")), r, a);
							this.fügePositionEin(rp);
						}
					}
				}
			}
			
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Rechnungsposition rp:rpListe){
			erg+=rp+"<br>";
		}
		return erg+="</HTML>";
	}

	

}
