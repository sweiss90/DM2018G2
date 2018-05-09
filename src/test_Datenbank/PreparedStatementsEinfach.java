package test_Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PreparedStatementsEinfach {
	
private testGUI gui;
	private PreparedStatement psEinfach = null;
	private Connection conStatement = null;
	
	
	
	public PreparedStatementsEinfach(testGUI gui) {
		this.gui=gui;
	}

	
	//Getter- und Setter-Methoden

	

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
	public ArrayList<LinkedHashMap<String, String>> erstesStatement(String i) throws SQLException {
		String sql ="SELECT * FROM rechnung WHERE bezahlt = ?;";
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, i);
	//	setPs(psEinfach);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zweitesStatement(String rechnungsBetrag) throws SQLException{
		String sql = "SELECT r.Nr, r.KdNr, rb.RechnungsBetrag FROM "
				+ "(SELECT r.Nr, SUM(Rechnungspositions_Preis) AS RechnungsBetrag FROM rechnung r INNER JOIN (SELECT rp.RechnungsID, rp.PositionsNr,"
				+ "(a.Preis*rp.Menge) AS Rechnungspositions_Preis "
				+ "FROM Artikel a INNER JOIN rechnungsposition rp ON a.ID=rp.ArtikelID ORDER BY rp.RechnungsID ASC, rp.PositionsNr ASC) AS rppTable "
				+ "ON (r.Nr=rppTable.RechnungsID) GROUP BY r.Nr) AS rb INNER JOIN rechnung r ON rb.Nr=r.Nr WHERE rb.RechnungsBetrag>=?;";
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, rechnungsBetrag);
	//	setPs(psEinfach);
		ArrayList<LinkedHashMap<String, String>> querry =gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> drittesStatement(String rechnungsDatumJava) throws SQLException{
		String sql = "SELECT* FROM rechnung WHERE Datum=?;";
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		
		//Hier bei der Umwandlung bin ich mir nicht sicher ob das so funktioniert
		//könntest du das bei gelegenheit Testen?
		//String rechnungsDatumSQL = new String
		psEinfach.setString(1, rechnungsDatumJava);
	//	setPs(psEinfach);
	//	psEinfach = conStatement.prepareStatement(sql);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> viertesStatement(String wohnOrt) throws SQLException{
		String sql = "SELECT* FROM kunde INNER JOIN anschrift WHERE kunde.AnID=anschrift.ID AND anschrift.Ort=?;";
		
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, wohnOrt);		
	//	setPs(psEinfach);
		
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> fuenftesStatement(String bezahlt) throws SQLException{
		String sql = "SELECT k.Nr, k.Vorname, k.Nachname FROM kunde k INNER JOIN rechnung ON k.Nr=rechnung.KdNr AND Bezahlt=? GROUP BY k.Nr";
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, bezahlt);		
	//	setPs(psEinfach);
		
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	//enthält Fehler
	public ArrayList<LinkedHashMap<String, String>> sechstesStatement(String kleinerAls, String bezahlt) throws SQLException{
		String sql ="SELECT k.Nr, k.Vorname, k.Nachname, sum(Bezahlt=?) AS Anzahl FROM (SELECT k.Vorname, k.Nachname, k.TelefonNr, k.Nr "
				+ "FROM kunde k INNER JOIN geschäftskunde gk ON k.Nr=gk.KDNr) k INNER JOIN rechnung r ON k.Nr=r.KdNr "
				+ "GROUP BY k.Nr HAVING sum(Bezahlt=?)<?";
		
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, bezahlt);
		psEinfach.setString(2, bezahlt);	
		psEinfach.setString(3, kleinerAls);
		
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> siebtesStatement(String artikelPreis) throws SQLException{
		String sql ="SELECT artikel.Bezeichnung, artikel.Preis FROM artikel WHERE Preis>=?";
		
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, artikelPreis);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> achtesStatement(String rechtsform) throws SQLException{
		String sql = "SELECT gk.KDNr, gk.Firmenname, uf.Rechtsform FROM "
				+ "geschäftskunde gk INNER JOIN unternehmensform uf ON gk.RechtsformID=uf.ID AND Rechtsform=?";
		
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, rechtsform);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> neuntesStatement(String vorname) throws SQLException{
		String sql = "SELECT kunde.Nr, kunde.Vorname, kunde.Nachname FROM kunde WHERE Nr "
				+ "NOT IN (SELECT gk.KDNr AS Nummer FROM kunde k INNER JOIN geschäftskunde gk ON k.Nr=gk.KDNr) AND vorname=?;";
		
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, vorname);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zehntestatement(String rechtsform) throws SQLException{
		String sql = "SELECT * FROM geschäftskunde INNER JOIN unternehmensform ON geschäftskunde.RechtsformID = unternehmensform.ID AND NOT Rechtsform=?;";
		
		psEinfach = gui.getVb().getCon().prepareStatement(sql);
		psEinfach.setString(1, rechtsform);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psEinfach.executeQuery());
		return querry;
	}
	
}
