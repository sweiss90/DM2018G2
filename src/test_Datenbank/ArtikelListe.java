package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ArtikelListe {
	//Singleton-Pattern
	private static ArtikelListe artikelListe;
	private ArrayList<Artikel> aListe;
	
	private ArtikelListe(){
		aListe=new ArrayList<>();
	}
	public void fügeArtikelEin(Artikel a){
		aListe.add(a);
	}
	public void entferneArtikel(Artikel a){
		aListe.remove(a);
	}
	public boolean enthältArtikel(Artikel a){
		return aListe.contains(a);
	}
	public static ArtikelListe getArtikelListe(){
		if(artikelListe==null)
			artikelListe=new ArtikelListe();
		return artikelListe;
	}
	public ArrayList<Artikel> getaListe() {
		return aListe;
	}
	public void leereListe(){
		aListe.clear();
	}
	public void fügeArtikelEin(DB db, Artikel ar) throws SQLException{
		String sql="INSERT INTO artikel(Id, Bezeichnung, Preis) VALUES(?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, ar.getId());
		db.getPs().setString(2, ar.getBezeichnung());
		db.getPs().setString(3, ar.getPreis());
		
		//SQL-Befehl ausführen
		db.getPs().execute();
		getArtikelListe().fügeArtikelEin(ar);
	}
	public void löscheArtikel(DB db, Artikel ar) throws SQLException{
		String sql="DELETE FROM artikel WHERE Id=? AND Bezeichnung=? AND Preis=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, ar.getId());
		db.getPs().setString(2, ar.getBezeichnung());
		db.getPs().setString(3, ar.getPreis());
		
		//SQL-Befehl ausführen
		db.getPs().execute();
		getArtikelListe().entferneArtikel(ar);
	}
	public void ändereArtikel(DB db, Artikel arNeu, Artikel arAlt) throws SQLException{
		String sql="UPDATE artikel SET Bezeichnung=?, Preis=? WHERE ID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, arNeu.getBezeichnung());
		db.getPs().setString(2, arNeu.getPreis());
		db.getPs().setString(3, arNeu.getId());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getArtikelListe().entferneArtikel(arAlt);
		getArtikelListe().fügeArtikelEin(arNeu);
	}
	
	public void artikelListeAktualisieren(DB db) throws SQLException{
		artikelListe.leereListe();
		String sql="SELECT * FROM artikel;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Artikel a=new Artikel(datensatz.get("ID"), datensatz.get("Bezeichnung"), datensatz.get("Preis"));
			this.fügeArtikelEin(a);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Artikel ar:aListe){
				erg+=ar+"<br>";
			}
			return erg+="</HTML>";
		}
	

}
