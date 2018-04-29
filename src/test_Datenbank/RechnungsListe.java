package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RechnungsListe {
	//Singleton-Pattern
	private static RechnungsListe rechnungsListe;
	private ArrayList<Rechnung> rListe;
	
	public RechnungsListe(){
		rListe=new ArrayList<>();
	}
	
	public void fügeRechnungHinzu(Rechnung r){
		rListe.add(r);
	}
	
	public void entferneRechnung(Rechnung r){
		rListe.remove(r);
	}
	
	public boolean enthältRechnung(Rechnung r){
		return rListe.contains(r);
	}

	public static RechnungsListe getRechnungsListe() {
		if(rechnungsListe==null){
			rechnungsListe=new RechnungsListe();
		}
		return rechnungsListe;
	}
	
	public ArrayList<Rechnung> getRListe(){
		return rListe;
	}
	public void leereRechnungsListe(){
		rListe.clear();
	}
	public void fügeRechnungEin(DB db, Rechnung r) throws SQLException{
		String sql="INSERT INTO rechnung(Datum, Bezahlt, Zahlungsziel, KdNr, TransNr) VALUES (?,?,?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, r.getDatum());
		db.getPs().setString(2, r.getBezahlt());
		db.getPs().setString(3, r.getZahlungsziel());
		db.getPs().setString(4, r.getKdNr());
		db.getPs().setString(5, r.getTransNr());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechnungsListe().fügeRechnungHinzu(r);
	}
	public void löscheRechnung(DB db, Rechnung r) throws SQLException{
		String sql="DELETE FROM rechnung WHERE Datum=? AND bezahlt=? AND Zahlungsziel=? AND KdNr=? AND TransNr=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, r.getDatum());
		db.getPs().setString(2, r.getBezahlt());
		db.getPs().setString(3, r.getZahlungsziel());
		db.getPs().setString(4, r.getKdNr());
		db.getPs().setString(5, r.getTransNr());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechnungsListe().entferneRechnung(r);
	}
	public void rechnungsListeAktualisieren(DB db) throws SQLException{
		this.leereRechnungsListe();//suboptimal, da wenig performant 
		getRechnungsListe().leereRechnungsListe();
		String sql="SELECT * FROM rechnung;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Rechnung r=new Rechnung(datensatz.get("Nr"), datensatz.get("Datum"), datensatz.get("Bezahlt"), 
						datensatz.get("Zahlungsziel"), datensatz.get("KdNr"), datensatz.get("TransNr"));
			this.fügeRechnungHinzu(r);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Rechnung r:rListe){
			erg+=r.toString()+"<br>";
		}
		return (erg+="</HTML>");
	}

	
	

}
