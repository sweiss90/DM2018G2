package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class AnschriftenListe {
	//Singleton-Pattern
	private static AnschriftenListe anschriftenListe;
	private ArrayList<Anschrift> aListe;
	
	private AnschriftenListe(){
		aListe=new ArrayList<>();
	}
	public void fügeAnschriftEin(Anschrift an){
		//NULL-Prüfungen notwendig?
		aListe.add(an);
	}
	public void entferneAnschrift(Anschrift an){
		aListe.remove(an);
	}
	public boolean enthaeltAnschrift(Anschrift an){
		return  aListe.contains(an);
	}
	public static AnschriftenListe getAnschriftenListe() {
		if(anschriftenListe==null)
			anschriftenListe=new AnschriftenListe();
		return anschriftenListe;
	}
	public ArrayList<Anschrift> getaListe() {
		return aListe;
	}
	public void leereAnschriftenListe(){
		aListe.clear();
	}
	public void fügeAnschriftEin(DB db, Anschrift a) throws SQLException{
		String sql="INSERT INTO anschrift(Strasse, HausNr, PLZ, Ort, LaID) VALUES(?,?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, a.getStrasse());
		db.getPs().setString(2, a.getHausNr());
		db.getPs().setString(3, a.getPlZ());
		db.getPs().setString(4, a.getOrt());
		db.getPs().setString(5, a.getLaID());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getAnschriftenListe().fügeAnschriftEin(a);
	}
	public void löscheAnschrift(DB db, Anschrift a) throws SQLException{
		String sql="DELETE FROM anschrift WHERE Strasse=? AND HausNr=? AND PLZ=? AND Ort=? AND LaID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, a.getStrasse());
		db.getPs().setString(2, a.getHausNr());
		db.getPs().setString(3, a.getPlZ());
		db.getPs().setString(4, a.getOrt());
		db.getPs().setString(5, a.getLaID());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getAnschriftenListe().entferneAnschrift(a);
	}
	public void anschriftenListeAktualisieren(DB db) throws SQLException{
		anschriftenListe.leereAnschriftenListe();
		String sql="SELECT * FROM anschrift;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Anschrift a=new Anschrift(datensatz.get("ID"), datensatz.get("Strasse"), datensatz.get("HausNr"), datensatz.get("PLZ"), 
						datensatz.get("Ort"), datensatz.get("LaID"));
			this.fügeAnschriftEin(a);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Anschrift a:aListe){
				erg+=a+"<br>";
			}
			return (erg+="</HTML>");
		}
	

}
