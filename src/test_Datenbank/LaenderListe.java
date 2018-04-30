package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LaenderListe {
	//Singleton-Pattern
	private static LaenderListe laenderListe;
	private ArrayList<Land> laListe;
	
	private LaenderListe(){
		laListe=new ArrayList<>();
	}
	public void f�geLandEin(Land la){
		//NULL-Pr�fungen notwendig?
		laListe.add(la);
	}
	public void entferneLand(Land la){
		laListe.remove(la);
	}
	
	public boolean enthaeltLand(Land la){
		return  laListe.contains(la);
	}
	public ArrayList<Land> getLaListe() {
		return laListe;
	}
	public static LaenderListe getLaenderListe(){
		if(laenderListe==null)
			laenderListe=new LaenderListe();
		return laenderListe;
	}
	public void leereLaenderListe(){
		laListe.clear();
	}
	public void f�geLandEin(DB db, Land la) throws SQLException{
		String sql="INSERT INTO land(ID, Land) VALUES(?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, la.getId());
		db.getPs().setString(2, la.getLand());
	
		//SQL-Befehl ausf�hren
		db.getPs().execute();
		getLaenderListe().f�geLandEin(la);
	}
	public void l�scheLand(DB db, Land la) throws SQLException{
		String sql="DELETE FROM land WHERE ID=? AND LAND=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, la.getId());
		db.getPs().setString(2, la.getLand());
	
		//SQL-Befehl ausf�hren
		db.getPs().execute();
		getLaenderListe().entferneLand(la);
	}
	public void laenderListeAktualisieren(DB db) throws SQLException{
		laenderListe.leereLaenderListe();
		String sql="SELECT * FROM land;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Land la=new Land(datensatz.get("ID"), datensatz.get("Land"));
			this.f�geLandEin(la);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Land la:laListe){
			erg+=la+"<br>";
		}
		return erg+="</HTML>";
	}
	

	
	

	
	
	
	

}
