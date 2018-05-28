package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public Rechnung gibRechnung(Rechnung r){
		Iterator<Rechnung> it=rListe.iterator();
		while(it.hasNext()){
			Rechnung rk=it.next();
			if(rk.equals(r))
				return rk;
			}
		return null;
	}
	
	public ArrayList<Rechnung> getRListe(){
		return rListe;
	}
	public void leereRechnungsListe(){
		rListe.clear();
	}
	public void fügeRechnungEin(DB db, Rechnung r) throws SQLException{
		getRechnungsListe().fügeRechnungHinzu(r);
		getRechnungsListe().gibRechnung(r).persistiere(db);
	}
	public void löscheRechnung(DB db, Rechnung r) throws SQLException{
		getRechnungsListe().gibRechnung(r).lösche(db);
		getRechnungsListe().entferneRechnung(r);
	}
	public void ändereRechnung(DB db, Rechnung rechnungNeu, Rechnung rechnungAlt) throws SQLException{
		getRechnungsListe().entferneRechnung(rechnungAlt);
		getRechnungsListe().fügeRechnungHinzu(rechnungNeu);
		getRechnungsListe().gibRechnung(rechnungNeu).ändere(db);
		
	}
	
	public void rechnungsListeAktualisieren(DB db) throws SQLException{
		this.leereRechnungsListe();//suboptimal, da wenig performant 
		getRechnungsListe().leereRechnungsListe();
		String sql="SELECT * FROM rechnung;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String kdnr=datensatz.get("KdNr");
			String zaNr=datensatz.get("TransNr");
			for(Kunde k:KundenListe.getkundenListe().getkListe()){
				if(String.valueOf(k.getNr()).equals(kdnr)){
					Rechnung r=new Rechnung(Integer.parseInt(datensatz.get("Nr")), datensatz.get("Datum"), datensatz.get("Bezahlt"), 
						datensatz.get("Zahlungsziel"), k );
			this.fügeRechnungHinzu(r);
					
				}
			}
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
