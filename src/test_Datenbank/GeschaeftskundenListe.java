package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GeschaeftskundenListe {
	//Singleton-Pattern
	private static GeschaeftskundenListe geschaeftskundenListe;
	private ArrayList<Geschäftskunde> gkListe;
	
	private GeschaeftskundenListe(){
		gkListe=new ArrayList<>();
	}
	public void fügeGeschaeftskundeEin(Geschäftskunde gk){
		//NULL-Prüfungen notwendig?
		gkListe.add(gk);
	}
	public void entferneGeschaeftskunde(Geschäftskunde gk){
		gkListe.remove(gk);
	}
	public boolean enthaeltGeschaeftskunde(Geschäftskunde gk){
		return  gkListe.contains(gk);
	}
	public static GeschaeftskundenListe getGeschaeftskundenListe() {
		if(geschaeftskundenListe==null){
			geschaeftskundenListe=new GeschaeftskundenListe();
		}
		return geschaeftskundenListe;
	}
	public ArrayList<Geschäftskunde> getGkListe(){
		return gkListe;
	}
	public void leereListe(){
		gkListe.clear();
	}
	public void fügeGeschäftskundeEin(DB db, Geschäftskunde gk) throws SQLException{
		String sql="INSERT INTO geschäftskunde(KDNr, Firmenname, RechtsformID) VALUES (?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, gk.getKDNr());
		db.getPs().setString(2, gk.getFirmenname());
		db.getPs().setString(3, gk.getRechtsformID());
	
		//SQL-Befehl absetzen
		db.getPs().execute();
		getGeschaeftskundenListe().fügeGeschaeftskundeEin(gk);
	}
	public void löscheGeschäftskunde(DB db, Geschäftskunde gk) throws SQLException{
		String sql="DELETE FROM geschäftskunde WHERE KDNr=? AND Firmenname=? AND RechtsformID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, gk.getKDNr());
		db.getPs().setString(2, gk.getFirmenname());
		db.getPs().setString(3, gk.getRechtsformID());
	
		//SQL-Befehl absetzen
		db.getPs().execute();
		getGeschaeftskundenListe().entferneGeschaeftskunde(gk);
	}
	public void geschaeftskundenListeAktualisieren(DB db) throws SQLException{
		geschaeftskundenListe.leereListe();
		String sql="SELECT * FROM geschäftskunde;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Geschäftskunde gk=new Geschäftskunde(datensatz.get("KDNr"), datensatz.get("Firmenname"), datensatz.get("RechtsformID")); 
			this.fügeGeschaeftskundeEin(gk);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Geschäftskunde gk:gkListe){
				erg+=gk+"<br>";
			}
		return erg+="</HTML>";
	}
	
	

	
	

}
