package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GeschaeftskundenListe {
	//Singleton-Pattern
	private static GeschaeftskundenListe geschaeftskundenListe;
	private ArrayList<Gesch�ftskunde> gkListe;
	
	private GeschaeftskundenListe(){
		gkListe=new ArrayList<>();
	}
	public void f�geGeschaeftskundeEin(Gesch�ftskunde gk){
		gkListe.add(gk);
	}
	public void entferneGeschaeftskunde(Gesch�ftskunde gk){
		gkListe.remove(gk);
	}
	public boolean enthaeltGeschaeftskunde(Gesch�ftskunde gk){
		return  gkListe.contains(gk);
	}
	public static GeschaeftskundenListe getGeschaeftskundenListe() {
		if(geschaeftskundenListe==null){
			geschaeftskundenListe=new GeschaeftskundenListe();
		}
		return geschaeftskundenListe;
	}
	public ArrayList<Gesch�ftskunde> getGkListe(){
		return gkListe;
	}
	public void leereListe(){
		gkListe.clear();
	}
	public void f�geGesch�ftskundeEin(DB db, Gesch�ftskunde gk) throws SQLException{
		String sql="INSERT INTO gesch�ftskunde(KDNr, Firmenname, RechtsformID) VALUES (?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, gk.getKDNr());
		db.getPs().setString(2, gk.getFirmenname());
		//db.getPs().setString(3, gk.getRechtsformID());
	
		//SQL-Befehl absetzen
		db.getPs().execute();
		getGeschaeftskundenListe().f�geGeschaeftskundeEin(gk);
	}
	public void l�scheGesch�ftskunde(DB db, Gesch�ftskunde gk) throws SQLException{
		String sql="DELETE FROM gesch�ftskunde WHERE KDNr=? AND Firmenname=? AND RechtsformID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, gk.getKDNr());
		db.getPs().setString(2, gk.getFirmenname());
		//db.getPs().setString(3, gk.getRechtsformID());
	
		//SQL-Befehl absetzen
		db.getPs().execute();
		getGeschaeftskundenListe().entferneGeschaeftskunde(gk);
	}
	public void �ndereGesch�ftskunde(DB db, Gesch�ftskunde gkNeu, Gesch�ftskunde gkAlt) throws SQLException{
		String sql="UPDATE gesch�ftskunde SET KDNr=?, Firmenname=?, RechtsformID=? WHERE KDNr=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, gkNeu.getKDNr());
		db.getPs().setString(2, gkNeu.getFirmenname());
		//db.getPs().setString(3, gkNeu.getRechtsformID());
		//db.getPs().setString(4, gkNeu.getKDNr());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getGeschaeftskundenListe().entferneGeschaeftskunde(gkAlt);
		getGeschaeftskundenListe().f�geGeschaeftskundeEin(gkNeu);
	
	}
	public void geschaeftskundenListeAktualisieren(DB db) throws SQLException{
		geschaeftskundenListe.leereListe();
		String sql="SELECT * FROM (SELECT * FROM (SELECT * FROM gesch�ftskunde INNER JOIN unternehmensform ON "
				+ "gesch�ftskunde.RechtsformID=unternehmensform.ID) s INNER JOIN kunde ON s.KDNr=kunde.nr) t "
				+ "INNER JOIN anschrift ON t.AnID=anschrift.ID;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String id=datensatz.get("ID"); 
			String anID=datensatz.get("AnID");
			for(Rechtsform rf:RechtsformListe.getRechtsformListe().getRfListe()){
				if(String.valueOf(rf.getId()).equals(id)){
					for(Anschrift an:AnschriftenListe.getAnschriftenListe().getaListe()){
						if(String.valueOf(an.getId()).equals(anID)){
							Gesch�ftskunde gk=new Gesch�ftskunde(Integer.parseInt(datensatz.get("Nr")), datensatz.get("Vorname"),
									datensatz.get("Nachname"), datensatz.get("TelefonNr"), datensatz.get("Email"),
									an, datensatz.get("Firmenname"), rf);
							this.f�geGeschaeftskundeEin(gk);
						}
					}
					
				}
			}
			
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Gesch�ftskunde gk:gkListe){
				erg+=gk+"<br>";
			}
		return erg+="</HTML>";
	}
	
	

	
	

}
