package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class KreditkarteListe {
	
	private static KreditkarteListe kreditkarteListe=null;
	private ArrayList<Kreditkarte> kkListe=null;
	
	private KreditkarteListe(){
		kkListe=new ArrayList<Kreditkarte>();
	}
	public void KreditkarteHinzuf�gen(Kreditkarte k){
		kkListe.add(k);
	}
	public boolean enth�ltKreditkarte(Kreditkarte k){
		return kkListe.contains(k);
	}
	public void l�scheKreditkarte(Kreditkarte k){
		kkListe.remove(k);
	}
	public static KreditkarteListe getKreditkarteListe(){
		if(kreditkarteListe==null){
			kreditkarteListe=new KreditkarteListe();
		}
		return kreditkarteListe;
	}
	public ArrayList<Kreditkarte> getkkListe(){
		return kkListe;
	}
	public void leereListe(){
		kkListe.clear();
	}
	public void f�geKreditkarteEin(DB db, Kreditkarte k) throws SQLException{
		String sql="INSERT INTO kreditkarte(TransID, KaNr, Ablaufdatum) VALUES(?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, k.getTransNr());
		db.getPs().setString(2, k.getKaNr());
		db.getPs().setString(3, k.getAblaufdatum());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getKreditkarteListe().KreditkarteHinzuf�gen(k);
	}
	public void l�scheKreditkarte(DB db, Kreditkarte k) throws SQLException{
		String sql="DELETE FROM kreditkarte WHERE TransID=? AND KaNr=? AND Ablaufdatum=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, k.getTransNr());
		db.getPs().setString(2, k.getKaNr());
		db.getPs().setString(3, k.getAblaufdatum());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getKreditkarteListe().l�scheKreditkarte(k);
	}
	public void �ndereKreditkarte(DB db, Kreditkarte kNeu, Kreditkarte kAlt) throws SQLException{
		String sql="UPDATE kreditkarte SET TransID=?, KaNr=?, Ablaufdatum=? WHERE TransID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, kNeu.getTransNr());
		db.getPs().setString(2, kNeu.getKaNr());
		db.getPs().setString(3, kNeu.getAblaufdatum());
		//db.getPs().setString(4, kAlt.getTransNr());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getKreditkarteListe().l�scheKreditkarte(kAlt);
		getKreditkarteListe().KreditkarteHinzuf�gen(kNeu);
	}
	public void kreditkarteListeAktualisieren(DB db) throws SQLException{
		getKreditkarteListe().leereListe();
		String sql="SELECT * FROM kreditkarte INNER JOIN zahlungsart ON kreditkarte.TransID=zahlungsart.TransID;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String kdnr=datensatz.get("KDNr");
			for(Kunde k:KundenListe.getkundenListe().getkListe()){
				if(kdnr.equals(String.valueOf(k.getNr()))){
					Kreditkarte kk=new Kreditkarte(Integer.parseInt(datensatz.get("TransID")), k, datensatz.get("KaNr"), datensatz.get("Ablaufdatum"));
					this.KreditkarteHinzuf�gen(kk);
				}
			}
			
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Kreditkarte k:kkListe){
				erg+=k+"<br>";
			}
			return erg+="</HTML>";
	}
}
