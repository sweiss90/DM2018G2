package test_Datenbank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BankeinzugListe {
		
	private static BankeinzugListe bankeinzugListe=null;
	private ArrayList<Bankeinzug> beListe=null;
	
	private BankeinzugListe(){
		beListe=new ArrayList<Bankeinzug>();
	}
	public void BankeinzugHinzuf�gen(Bankeinzug z){
		beListe.add(z);
	}
	public boolean enth�ltBankeinzug(Bankeinzug z){
		return beListe.contains(z);
	}
	public void l�scheBankeinzug(Bankeinzug z){
		beListe.remove(z);
	}
	public static BankeinzugListe getBankeinzugListe(){
		if(bankeinzugListe==null){
			bankeinzugListe=new BankeinzugListe();
		}
		return bankeinzugListe;
	}
	public ArrayList<Bankeinzug> getbeListe(){
		return beListe;
	}
	public void leereListe(){
		beListe.clear();
	}
	public void f�geBankeinzugEin(DB db, Bankeinzug be) throws SQLException{
		String sql="INSERT INTO bankeinzug(TransID, IBAN, BIC) VALUES(?,?,?);";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, be.getTransNr());
		db.getPs().setString(2, be.getIban());
		db.getPs().setString(3, be.getBic());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getBankeinzugListe().BankeinzugHinzuf�gen(be);
	}
	public void l�scheBankeinzug(DB db, Bankeinzug be) throws SQLException{
		String sql="DELETE FROM bankeinzug WHERE TransID=? AND IBAN=? AND BIC=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, be.getTransNr());
		db.getPs().setString(2, be.getIban());
		db.getPs().setString(3, be.getBic());
		
		//SQL-Befehl absenden
		db.getPs().execute();
		getBankeinzugListe().l�scheBankeinzug(be);
	}
	public void �ndereBankeinzug(DB db, Bankeinzug beNeu, Bankeinzug beAlt) throws SQLException{
		String sql="UPDATE bankeinzug SET TransID=?, IBAN=?, BIC=? WHERE TransID=?;";
		db.setPs(db.getCon().prepareStatement(sql));
		db.getPs().setString(1, beNeu.getTransNr());
		db.getPs().setString(2, beNeu.getIban());
		db.getPs().setString(3, beNeu.getBic());
		db.getPs().setString(4, beAlt.getTransNr());

		//SQL-Befehl absenden
		db.getPs().executeUpdate();
		getBankeinzugListe().l�scheBankeinzug(beAlt);
		getBankeinzugListe().BankeinzugHinzuf�gen(beNeu);
	}
	public void bankeinzugListeAktualisieren(DB db) throws SQLException{
		getBankeinzugListe().leereListe();
		String sql="SELECT * FROM bankeinzug;";
		ResultSet rs=db.getCon().createStatement().executeQuery(sql);
		ArrayList<LinkedHashMap<String, String>> ergebnis= db.konvertiereJava(rs);
		for(LinkedHashMap<String, String> datensatz:ergebnis){
			Bankeinzug be=new Bankeinzug(datensatz.get("TransID"), datensatz.get("IBAN"), datensatz.get("BIC"));
			this.BankeinzugHinzuf�gen(be);
		}
	}
	@Override
	public String toString(){
		String erg=new String("<HTML>");
		for(Bankeinzug be:beListe){
				erg+=be+"<br>";
			}
			return erg+="</HTML>";
	}
}


				