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
		db.getPs().setInt(2, a.getHausNr());
		db.getPs().setString(3, a.getPlZ());
		db.getPs().setString(4, a.getOrt());
		db.getPs().setString(5, a.getLand().getId());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getAnschriftenListe().fügeAnschriftEin(a);
	}
	public void löscheAnschrift(DB db, Anschrift a) throws SQLException{
		String sql="DELETE FROM anschrift WHERE Strasse=? AND HausNr=? AND PLZ=? AND Ort=? AND LaID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, a.getStrasse());
		db.getPs().setInt(2, a.getHausNr());
		db.getPs().setString(3, a.getPlZ());
		db.getPs().setString(4, a.getOrt());
		db.getPs().setString(5, a.getLand().getId());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getAnschriftenListe().entferneAnschrift(a);
	}
	public void ändereAnschrift(DB db, Anschrift anNeu, Anschrift anAlt) throws SQLException{
		String sql="UPDATE anschrift SET Strasse=?, HausNr=?, PLZ=?, Ort=?, LaID=? WHERE ID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, anNeu.getStrasse());
		db.getPs().setInt(2, anNeu.getHausNr());
		db.getPs().setString(3, anNeu.getPlZ());
		db.getPs().setString(4, anNeu.getOrt());
		db.getPs().setString(5, anNeu.getLand().getId());
		db.getPs().setInt(6, anNeu.getId());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getAnschriftenListe().entferneAnschrift(anAlt);
		getAnschriftenListe().fügeAnschriftEin(anNeu);
	}
	
	public void anschriftenListeAktualisieren(DB db) throws SQLException{
		anschriftenListe.leereAnschriftenListe();
		String sql="SELECT * FROM anschrift;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String laId=datensatz.get("LaID");
			for(Land la:LaenderListe.getLaenderListe().getLaListe()){
				if(la.getId().equals(laId)){
				Anschrift a=new Anschrift(Integer.parseInt(datensatz.get("ID")), datensatz.get("Strasse"), Integer.parseInt(datensatz.get("HausNr")), datensatz.get("PLZ"), 
						datensatz.get("Ort"), la);
				this.fügeAnschriftEin(a);
				}
			}
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
