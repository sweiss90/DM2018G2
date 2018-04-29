package test_Datenbank;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArtikelListe {
	//Singleton-Pattern
	private static ArtikelListe artikelListe;
	private ArrayList<Artikel> aListe;
	
	private ArtikelListe(){
		aListe=new ArrayList<>();
	}
	public void f�geArtikelEin(Artikel a){
		aListe.add(a);
	}
	public void entferneArtikel(Artikel a){
		aListe.remove(a);
	}
	public boolean enth�ltArtikel(Artikel a){
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
	public void f�geArtikelEin(DB db, Artikel ar) throws SQLException{
		String sql="INSERT INTO artikel(Id, Bezeichnung, Preis) VALUES(?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, ar.getId());
		db.getPs().setString(2, ar.getBezeichnung());
		db.getPs().setString(3, ar.getPreis());
		
		//SQL-Befehl ausf�hren
		db.getPs().execute();
		getArtikelListe().f�geArtikelEin(ar);
	}
	public void l�scheArtikel(DB db, Artikel ar) throws SQLException{
		String sql="DELETE FROM artikel WHERE Id=? AND Bezeichnung=? AND Preis=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, ar.getId());
		db.getPs().setString(2, ar.getBezeichnung());
		db.getPs().setString(3, ar.getPreis());
		
		//SQL-Befehl ausf�hren
		db.getPs().execute();
		getArtikelListe().entferneArtikel(ar);
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
