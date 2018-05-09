package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ÜberweisungListe {
	//Singleton-Pattern
	private static ÜberweisungListe überweisungListe=null;
	private ArrayList<Überweisung> uewListe=null;
	
	private ÜberweisungListe(){
		uewListe=new ArrayList<Überweisung>();
	}
	public void ÜberweisungHinzufügen(Überweisung u){
		uewListe.add(u);
	}
	public boolean enthältÜberweisung(Überweisung u){
		return uewListe.contains(u);
	}
	public void löscheÜberweisung(Überweisung u){
		uewListe.remove(u);
	}
	public static ÜberweisungListe getÜberweisungListe(){
		if(überweisungListe==null)
			überweisungListe=new ÜberweisungListe();
		return überweisungListe;
	}
	public ArrayList<Überweisung> getuewListe(){
		return uewListe;
	}
	public void leereListe(){
		uewListe.clear();
	}
	public void fügeÜberweisungEin(DB db, Überweisung u) throws SQLException{
		String sql="INSERT INTO überweisung(TransID, erhalten) VALUES(?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, u.getTransNr());
		db.getPs().setString(2, u.getErhalten());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getÜberweisungListe().ÜberweisungHinzufügen(u);
	}
	public void löscheÜberweisung(DB db, Überweisung u) throws SQLException{
		String sql="DELETE FROM überweisung WHERE TransID=? AND erhalten=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, u.getTransNr());
		db.getPs().setString(2, u.getErhalten());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getÜberweisungListe().löscheÜberweisung(u);
	}
	public void ändereÜberweisung(DB db, Überweisung uNeu, Überweisung uAlt) throws SQLException{
		String sql="UPDATE überweisung SET TransID=?, erhalten=? WHERE TransID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, uNeu.getTransNr());
		db.getPs().setString(2, uNeu.getErhalten());
		db.getPs().setString(3, uAlt.getTransNr());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getÜberweisungListe().löscheÜberweisung(uAlt);
		getÜberweisungListe().ÜberweisungHinzufügen(uNeu);
	}
	public void überweisungListeAktualisieren(DB db) throws SQLException{
		getÜberweisungListe().leereListe();
		String sql="SELECT * FROM überweisung;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Überweisung u=new Überweisung(datensatz.get("TransID"), datensatz.get("erhalten"));
			this.ÜberweisungHinzufügen(u);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Überweisung u:uewListe){
				erg+=u+"<br>";
			}
			return erg+="</HTML>";
	}

}
