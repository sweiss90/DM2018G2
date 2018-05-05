package test_Datenbank;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public void fügeRechtsformEin(DB db, Rechtsform rf) throws SQLException{
		String sql="INSERT INTO rechtsform(ID, Rechtsform) VALUES(?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, rf.getId());
		db.getPs().setString(2, rf.getRechtsform());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechtsformListe().fügeRechtsformHinzu(rf);
	}
	public void löscheRechtsform(DB db, Rechtsform rf) throws SQLException{
		String sql="DELETE FROM unternehmensform WHERE ID=? AND Rechtsform=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, rf.getId());
		db.getPs().setString(2, rf.getRechtsform());
		
		//SQL-Befehl absetzen
		db.getPs().execute();
		getRechtsformListe().entferneRechtsform(rf);
	}
	public void ändereRechtsform(DB db, Rechtsform rfNeu, Rechtsform rfAlt) throws SQLException{
		String sql="UPDATE unternehmensform SET Rechtsform=? WHERE ID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, rfNeu.getRechtsform());
		db.getPs().setString(2, rfNeu.getId());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getRechtsformListe().entferneRechtsform(rfAlt);
		getRechtsformListe().fügeRechtsformHinzu(rfNeu);
	}
	public void rechtsformListeAktualisieren(DB db) throws SQLException{
		getRechtsformListe().leereListe();//suboptimal, da wenig performant 
		String sql="SELECT * FROM unternehmensform;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Rechtsform rf=new Rechtsform(datensatz.get("ID"), datensatz.get("Rechtsform"));
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
