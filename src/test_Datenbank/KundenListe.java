package test_Datenbank;

import java.util.ArrayList.*;

import javax.swing.JOptionPane;

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
			Kunde kd=it.next();
			if(kd.equals(k)){
				kListe.remove(kd);
				return true;
			}
		}
		return false;
	}
	public void leereKundenListe(){
		kListe.clear();
	}
	public Kunde gibKunde(Kunde k){
		Iterator<Kunde> it=kListe.iterator();
		while(it.hasNext()){
			Kunde aK=it.next();
			if(aK.equals(k))
				return aK;
			}
		return null;
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
		getkundenListe().fügeKundeHinzu(k);
		getkundenListe().gibKunde(k).persistiere(db);
	}
	public void löscheKunde(DB db, Kunde k) throws SQLException{
		getkundenListe().gibKunde(k).lösche(db);
		getkundenListe().entferneKunde(k);
	}
	public void ändereKunde(DB db, Kunde kundeNeu, Kunde kundeAlt) throws SQLException{
		getkundenListe().entferneKunde(kundeAlt);
		getkundenListe().fügeKundeHinzu(kundeNeu);
		getkundenListe().gibKunde(kundeNeu).ändere(db);
		
	}
	public void kundenListeAktualisieren(DB db) throws SQLException{
		kundenListe.leereKundenListe();
		String sql="SELECT * FROM kunde;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			String anId=datensatz.get("AnID");
			for(Anschrift a:AnschriftenListe.getAnschriftenListe().getaListe()){
				if(a.getId().toString().equals(anId)){
					Kunde k=new Kunde(Integer.parseInt(datensatz.get("Nr")), datensatz.get("Vorname"), datensatz.get("Nachname"), 
							datensatz.get("TelefonNr"), datensatz.get("Email"), a);
					this.fügeKundeHinzu(k);
				}
					
			}
			
			
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
