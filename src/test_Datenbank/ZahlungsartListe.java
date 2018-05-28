package test_Datenbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ZahlungsartListe {
	
	private static ZahlungsartListe zahlungsartListe=null;
	private ArrayList<Zahlungsart> zaListe=null;
	
	private ZahlungsartListe(){
		zaListe=new ArrayList<Zahlungsart>();
	}
	public void zahlungsartHinzufügen(Zahlungsart z){
		zaListe.add(z);
	}
	public boolean enthältZahlungsart(Zahlungsart z){
		return zaListe.contains(z);
	}
	public void löscheZahlungsart(Zahlungsart z){
		zaListe.remove(z);
	}
	public static ZahlungsartListe getZahlungsartListe(){
		if(zahlungsartListe==null){
			zahlungsartListe=new ZahlungsartListe();
		}
		return zahlungsartListe;
	}
	public ArrayList<Zahlungsart> getZaListe(){
		return zaListe;
	}
	public void leereListe(){
		zaListe.clear();
	}
	public void fügeZahlungsartEin(DB db, Zahlungsart za) throws SQLException{
		String sql="INSERT INTO zahlungsart(ZANr, KDNr) VALUES(?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		//db.getPs().setString(1, za.getZahlungsartNummer());
		//db.getPs().setString(2, za.getKundennummer());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getZahlungsartListe().zahlungsartHinzufügen(za);
	}
	public void löscheZahlungsart(DB db, Zahlungsart za) throws SQLException{
		String sql="DELETE FROM zahlungsart WHERE ZANr=? AND KDNr=?;";
		db.setPs(db.getCon().prepareStatement(sql));
	//	db.getPs().setString(1, za.getZahlungsartNummer());
	//	db.getPs().setString(2, za.getKundennummer());;
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getZahlungsartListe().löscheZahlungsart(za);
	}
	public void ändereZahlungsart(DB db, Zahlungsart zaNeu, Zahlungsart zaAlt) throws SQLException{
		String sql="UPDATE zahlungsart SET ZANr=?, KDNr=? WHERE TransID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
	//	db.getPs().setString(1, zaNeu.getZahlungsartNummer());
	//	db.getPs().setString(2, zaNeu.getKundennummer());
	//	db.getPs().setString(3, zaNeu.getTransNr());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getZahlungsartListe().löscheZahlungsart(zaAlt);
		getZahlungsartListe().zahlungsartHinzufügen(zaNeu);
	}
	public void zahlungsartListeAktualisieren(DB db) throws SQLException{
		getZahlungsartListe().leereListe();
		String sql="SELECT * FROM zahlungsart;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String kdNr=datensatz.get("KDNr");
			for(Kunde kd:KundenListe.getkundenListe().getkListe()){
				if(kdNr.equals(String.valueOf(kd.getNr()))){
					Zahlungsart za=new Zahlungsart(Integer.parseInt(datensatz.get("TransID")), kd);
					this.zahlungsartHinzufügen(za);
		}
			
	}
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Zahlungsart za:zaListe){
				erg+=za+"<br>";
			}
			return erg+="</HTML>";
	}
}
