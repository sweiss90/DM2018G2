package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class RechtsformListe {
	//Singleton-Pattern
	private static RechtsformListe rechtsformListe;
	private ArrayList<Rechtsform> rfListe;
	
	private RechtsformListe(){
		rfListe=new ArrayList<>();
	}
	public void fügeRechtsformHinzu(Rechtsform rf){
		rfListe.add(rf);
	}
	public void entferneRechtsform(Rechtsform rf){
		rfListe.remove(rf);
	}
	public boolean enthältRechtsform(Rechtsform rf){
		return rfListe.contains(rf);
	}
	public static RechtsformListe getRechtsformListe(){
		if(rechtsformListe==null)
			rechtsformListe=new RechtsformListe();
		return rechtsformListe;
	}
	public ArrayList<Rechtsform> getRfListe(){
		return rfListe;
	}
	public void leereListe(){
		rfListe.clear();
	}
	
	public Rechtsform gibRechtsform(Rechtsform rf){
		Iterator<Rechtsform> it=rfListe.iterator();
		while(it.hasNext()){
			Rechtsform r=it.next();
			if(r.equals(rf))
				return r;
			}
		return null;
	}
	
	public void fügeRechtsformEin(DB db, Rechtsform rf) throws SQLException{
		getRechtsformListe().fügeRechtsformHinzu(rf);
		getRechtsformListe().gibRechtsform(rf).persistiere(db);
	}
	public void löscheRechtsform(DB db, Rechtsform rf) throws SQLException{
		getRechtsformListe().gibRechtsform(rf).lösche(db);
		getRechtsformListe().entferneRechtsform(rf);
	}
	public void ändereRechtsform(DB db, Rechtsform rfNeu, Rechtsform rfAlt) throws SQLException{
		getRechtsformListe().entferneRechtsform(rfAlt);
		getRechtsformListe().fügeRechtsformHinzu(rfNeu);
		getRechtsformListe().gibRechtsform(rfNeu).ändere(db);
	}
	public void rechtsformListeAktualisieren(DB db) throws SQLException{
		getRechtsformListe().leereListe();//suboptimal, da wenig performant 
		String sql="SELECT * FROM unternehmensform;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Rechtsform rf=new Rechtsform(Integer.parseInt(datensatz.get("ID")), datensatz.get("Rechtsform"));
			this.fügeRechtsformHinzu(rf);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Rechtsform rf:rfListe){
			erg+=rf+"<br>";
		}
		return (erg+="</HTML>");
	}
}
