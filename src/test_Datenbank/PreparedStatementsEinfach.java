package test_Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PreparedStatementsEinfach {
	
	//DB ersetzen durch testGUI-Attribut
	private DB db=null;
	private PreparedStatement psEinfach = null;
	private Connection conStatement = null;
	
	
	
	public PreparedStatementsEinfach(DB db) {
		setDB(db);
	}

	
	//Getter- und Setter-Methoden
	public DB getDB() {
		return db;
	}

	public void setDB(DB db) {
		this.db = db;
		setConStatement(db.getCon());
	}
	

	public Connection getConStatement() {
		return conStatement;
	}


	public void setConStatement(Connection conStatement) {
		this.conStatement = conStatement;
	}


	public PreparedStatement getPs() {
		return psEinfach;
	}

	public void setPs(PreparedStatement ps) {
		this.psEinfach = ps;
	}
	
	//PreparedStatements
	public ArrayList<LinkedHashMap<String, String>> erstesStatement(int i) throws SQLException {
		String sql ="SELECT* FROM rechnung WHERE bezahlt = ?;";
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setInt(1, i);
		setPs(psEinfach);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zweitesStatement(double rechnungsBetrag) throws SQLException{
		String sql = "SELECT r.Nr, r.KdNr, rb.RechnungsBetrag FROM "
				+ "(SELECT r.Nr, SUM(Rechnungspositions_Preis) AS RechnungsBetrag FROM rechnung r INNER JOIN (SELECT rp.RechnungsID, rp.PositionsNr,"
				+ "(a.Preis*rp.Menge) AS Rechnungspositions_Preis "
				+ "FROM Artikel a INNER JOIN rechnungsposition rp ON a.ID=rp.ArtikelID ORDER BY rp.RechnungsID ASC, rp.PositionsNr ASC) AS rppTable "
				+ "ON (r.Nr=rppTable.RechnungsID) GROUP BY r.Nr) AS rb INNER JOIN rechnung r ON rb.Nr=r.Nr WHERE rb.RechnungsBetrag>=?;";
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setDouble(1, rechnungsBetrag);
		setPs(psEinfach);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> drittesStatement(java.util.Date rechnungsDatumJava) throws SQLException{
		String sql = "SELECT* FROM rechnung WHERE Datum=?;";
		psEinfach = conStatement.prepareStatement(sql);
		
		//Hier bei der Umwandlung bin ich mir nicht sicher ob das so funktioniert
		//könntest du das bei gelegenheit Testen?
		java.sql.Date rechnungsDatumSQL = new java.sql.Date(rechnungsDatumJava.getTime());
		psEinfach.setDate(1, rechnungsDatumSQL);
		setPs(psEinfach);
		psEinfach = conStatement.prepareStatement(sql);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> viertesStatement(String wohnOrt) throws SQLException{
		String sql = "SELECT* FROM kunde INNER JOIN anschrift WHERE kunde.AnID=anschrift.ID AND anschrift.Ort=?;";
		
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setString(1, wohnOrt);		
		setPs(psEinfach);
		
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> fuenftesStatement(int bezahlt) throws SQLException{
		String sql = "SELECT k.Nr, k.Vorname, k.Nachname FROM kunde k INNER JOIN rechnung ON k.Nr=rechnung.KdNr AND Bezahlt=? GROUP BY k.Nr";
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setInt(1, bezahlt);		
		setPs(psEinfach);
		
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> sechstesStatement(int bezahlt, int kleinerAls) throws SQLException{
		String sql ="SELECT k.Nr, k.Vorname, k.Nachname FROM (SELECT k.Vorname, k.Nachname, k.TelefonNr, k.Nr "
				+ "FROM kunde k INNER JOIN geschäftskunde gk ON k.Nr=gk.KDNr) k INNER JOIN rechnung r ON k.Nr=r.KdNr "
				+ "GROUP BY k.Nr HAVING sum(Bezahlt=?)<?";
		
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setInt(1, bezahlt);	
		psEinfach.setInt(2, kleinerAls);
		
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> siebtesStatement(double artikelPreis) throws SQLException{
		String sql ="SELECT artikel.Bezeichnung, artikel.Preis FROM artikel WHERE Preis>=?";
		
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setDouble(1, artikelPreis);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> achtesStatement(String rechtsform) throws SQLException{
		String sql = "SELECT gk.KDNr, gk.Firmenname, uf.Rechtsform FROM "
				+ "geschäftskunde gk INNER JOIN unternehmensform uf ON gk.RechtsformID=uf.ID AND Rechtsform=\"?\"";
		
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setString(1, rechtsform);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> neuntesStatement(String vorname) throws SQLException{
		String sql = "SELECT kunde.Nr, kunde.Vorname, kunde.Nachname FROM kunde WHERE Nr "
				+ "NOT IN (SELECT gk.KDNr AS Nummer FROM kunde k INNER JOIN geschäftskunde gk ON k.Nr=gk.KDNr) AND vorname=\"?\";";
		
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setString(1, vorname);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zehntestatement(String rechtsform) throws SQLException{
		String sql = "SELECT * FROM geschäftskunde INNER JOIN unternehmensform ON geschäftskunde.RechtsformID = unternehmensform.ID AND NOT Rechtsform=\"?\"";
		
		psEinfach = conStatement.prepareStatement(sql);
		psEinfach.setString(1, rechtsform);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
}
