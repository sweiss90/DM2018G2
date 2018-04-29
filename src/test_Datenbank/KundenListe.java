package test_Datenbank;

import java.util.ArrayList.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class KundenListe {
	//Singleton-Pattern
	private static KundenListe kundenListe;
	private ArrayList<Kunde> kListe;
	
	private KundenListe(){
		kListe=new ArrayList<>();
	}
	
	public void fügeKundeHinzu(Kunde k){
		kListe.add(k);
	}
	
	public boolean enthältKunde(Kunde k){
		Iterator<Kunde> it=kListe.iterator();
		while(it.hasNext()){
			if(it.next().equals(k))
				return true;
			}
		return false;
		//alternativ:
		// return kundenListe.contains(k);
	}
	public boolean entferneKunde(Kunde k){
		Iterator<Kunde> it= kListe.iterator();
		while(it.hasNext()){
			if(it.next().equals(k)){
				kListe.remove(it.next());
				return true;
			}
		}
		return false;
	}
	public void leereKundenListe(){
		kListe.clear();
	}
	public static KundenListe getkundenListe() {
		if(kundenListe==null)
			kundenListe=new KundenListe();
		return kundenListe;
	}
	public ArrayList<Kunde> getkListe(){
		return kListe;
	}
	
	public void fügeKundeEin(DB db, Kunde k) throws SQLException{
		String sql="INSERT INTO kunde(Vorname, Nachname, Email, TelefonNr, AnID) VALUES (?,?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, k.getVorname());
		db.getPs().setString(2, k.getNachname());
		db.getPs().setString(3, k.getEmail());
		db.getPs().setString(4, k.getTelefonNr());
		db.getPs().setString(5, k.getAnID());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getkundenListe().fügeKundeHinzu(k);
	}
	public void löscheKunde(DB db, Kunde k) throws SQLException{
		String sql="DELETE FROM kunde WHERE Vorname=? AND Nachname=? AND EMail=? AND TelefonNr=? AND AnID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, k.getVorname());
		db.getPs().setString(2, k.getNachname());
		db.getPs().setString(3, k.getEmail());
		db.getPs().setString(4, k.getTelefonNr());
		db.getPs().setString(5, k.getAnID());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getkundenListe().entferneKunde(k);
	}
	public void kundenListeAktualisieren(DB db) throws SQLException{
		kundenListe.leereKundenListe();
		String sql="SELECT * FROM kunde;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Kunde k=new Kunde(datensatz.get("Nr"), datensatz.get("Vorname"), datensatz.get("Nachname"), 
						datensatz.get("TelefonNr"), datensatz.get("Email"), datensatz.get("AnID"));
			this.fügeKundeHinzu(k);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Kunde k:kListe){
			erg+=k.toString()+"<br>";
		}
		return (erg+="</HTML>");
	}
	

	
	

}
