package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class �berweisungListe {
	//Singleton-Pattern
	private static �berweisungListe �berweisungListe=null;
	private ArrayList<�berweisung> uewListe=null;
	
	private �berweisungListe(){
		uewListe=new ArrayList<�berweisung>();
	}
	public void �berweisungHinzuf�gen(�berweisung u){
		uewListe.add(u);
	}
	public boolean enth�lt�berweisung(�berweisung u){
		return uewListe.contains(u);
	}
	public void l�sche�berweisung(�berweisung u){
		uewListe.remove(u);
	}
	public static �berweisungListe get�berweisungListe(){
		if(�berweisungListe==null)
			�berweisungListe=new �berweisungListe();
		return �berweisungListe;
	}
	public ArrayList<�berweisung> getuewListe(){
		return uewListe;
	}
	public void leereListe(){
		uewListe.clear();
	}
	public void f�ge�berweisungEin(DB db, �berweisung u) throws SQLException{
		String sql="INSERT INTO �berweisung(TransID, erhalten) VALUES(?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, u.getTransNr());
		db.getPs().setString(2, u.getErhalten());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		get�berweisungListe().�berweisungHinzuf�gen(u);
	}
	public void l�sche�berweisung(DB db, �berweisung u) throws SQLException{
		String sql="DELETE FROM �berweisung WHERE TransID=? AND erhalten=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, u.getTransNr());
		db.getPs().setString(2, u.getErhalten());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		get�berweisungListe().l�sche�berweisung(u);
	}
	public void �ndere�berweisung(DB db, �berweisung uNeu, �berweisung uAlt) throws SQLException{
		String sql="UPDATE �berweisung SET TransID=?, erhalten=? WHERE TransID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, uNeu.getTransNr());
		db.getPs().setString(2, uNeu.getErhalten());
		db.getPs().setString(3, uAlt.getTransNr());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		get�berweisungListe().l�sche�berweisung(uAlt);
		get�berweisungListe().�berweisungHinzuf�gen(uNeu);
	}
	public void �berweisungListeAktualisieren(DB db) throws SQLException{
		get�berweisungListe().leereListe();
		String sql="SELECT * FROM �berweisung;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			�berweisung u=new �berweisung(datensatz.get("TransID"), datensatz.get("erhalten"));
			this.�berweisungHinzuf�gen(u);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(�berweisung u:uewListe){
				erg+=u+"<br>";
			}
			return erg+="</HTML>";
	}

}
