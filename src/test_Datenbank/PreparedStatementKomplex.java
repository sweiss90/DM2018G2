package test_Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PreparedStatementKomplex {

	private DB db=null;
	private PreparedStatement psKomplex = null;
	private Connection conStatement = null;
	
	//Konstruktor
	public PreparedStatementKomplex(DB db) {
		setDB(db);
	}
	
	//Getter- und Setter
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
		return psKomplex;
	}
	
	public void setPs(PreparedStatement ps) {
		this.psKomplex = ps;
	}
	
	
	//PreparedStatements Komplex
	public ArrayList<LinkedHashMap<String, String>> erstesStatement(int maxMengeUnbezahlterRechnungen, String land) throws SQLException {
		
		String sql ="SELECT r.Nr AS Rechnungsnummer, r.KdNr AS Kundennummer, k.Nachname AS Kunden_Name, k.Vorname AS Kunden_Nachname, "
				+ "rechnungsbetrag.RechnungsBetrag AS Rechnungsbetrag FROM (SELECT r.Nr, SUM(Rechnungspositions_Preis) AS RechnungsBetrag FROM rechnung r "
				+ "INNER JOIN (SELECT rp.RechnungsID, rp.PositionsNr,(a.Preis*rp.Menge) AS Rechnungspositions_Preis FROM"
				+ " Artikel a INNER JOIN rechnungsposition rp ON a.ID=rp.ArtikelID ORDER BY rp.RechnungsID ASC, rp.PositionsNr ASC) AS rppTable"
				+ " ON (r.Nr=rppTable.RechnungsID) GROUP BY r.Nr) AS rechnungsbetrag INNER JOIN rechnung r ON rechnungsbetrag.Nr=r.Nr INNER Join kunde k "
				+ "On r.KdNr=k.Nr INNER JOIN(SELECT k.Nr AS Kunden_Nummer, l.ID AS LAND FROM kunde k INNER JOIN anschrift an ON k.AnID=an.ID "
				+ "INNER JOIN land l on an.LaID=l.ID) AS KundeLand ON r.KdNr=KundeLand.Kunden_Nummer INNER JOIN(SELECT r.NR AS Rechnungs_Nummer, r.KdNr AS Kunden_Nummer "
				+ "FROM rechnung r INNER JOIN kreditkarte ka ON r.TransNr=ka.TransID) AS GezahltMitKreditKarte ON r.Nr=GezahltMitKreditKarte.Rechnungs_Nummer INNER JOIN "
				+ "(SELECT COUNT(r.bezahlt) AS Anzahl_unbezahlter_Rechnungen, r.KdNr FROM rechnung r WHERE r.bezahlt='0') AS OffeneRechnungen"
				+ " On r.KdNr=OffeneRechnungen.KdNr WHERE Anzahl_unbezahlter_Rechnungen>=? AND KundeLand.LAND=?;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setInt(1, maxMengeUnbezahlterRechnungen);
		psKomplex.setString(2, land);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zweitesStatement(int unternehmensform, String land) throws SQLException{
		String sql="SELECT * FROM (SELECT * FROM (SELECT * FROM(SELECT Firmenname, geschäftskunde.KDNr FROM geschäftskunde, unternehmensform WHERE geschäftskunde.RechtsformID=unternehmensform.ID and unternehmensform.ID=?) m, kunde WHERE m.KDNr=kunde.Nr) k," + 
				"(SELECT anschrift.ID, anschrift.Strasse, land.Land FROM anschrift, land WHERE anschrift.LaID=land.ID AND LAND.ID=?) l WHERE k.AnID=l.ID) s," + 
				"(SELECT kunde.Nr, kunde.Vorname, kunde.Nachname, SUM(Betrag) AS Gesamtumsatz FROM kunde, "
				+ "(SELECT * FROM rechnung, (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition, artikel "
				+ "WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) h WHERE rechnung.Nr=h.RechnungsID) j WHERE kunde.Nr=j.KdNr GROUP BY kunde.Nr) t" + 
				"WHERE s.ID=t.Nr;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setInt(1, unternehmensform);
		psKomplex.setString(2, land);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> drittesStatement(int rechnungsPosMenge, int bezahlt) throws SQLException{
		String sql="SELECT a.Preis AS Einzelpreis FROM (SELECT rp.Menge, rp.ArtikelID, rp.RechnungsID FROM rechnungsposition rp) AS rechnungsposition "
				+ "INNER JOIN artikel a ON a.ID=rechnungsposition.ArtikelID INNER JOIN (SELECT r.Nr AS Rechnungsnummer, r.Bezahlt FROM rechnung r WHERE r.Bezahlt=?) AS rechnung "
				+ "ON rechnungsposition.RechnungsID=rechnung.Rechnungsnummer WHERE rechnungsposition.Menge>=? AND rechnung.Bezahlt=?;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setInt(1, bezahlt);
		psKomplex.setInt(2, rechnungsPosMenge);
		psKomplex.setInt(3, bezahlt);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> viertesStatement(int bezahlt, int rechtsformEins, int rechtsformZwei, double kundenUmsatz, int mengeUnbezahlteRechnungengroesserGleich) throws SQLException{
		String sql ="SELECT Kundenumsatz.RechnungsBetrag, OffeneRechnungen.RechnungsNummer, gk.Firmenname, k.Vorname AS Ansprechpartner_Vorname, k.Nachname Ansprechpartner_Nachname, "
				+ "k.Email AS EMail, k.TelefonNr AS Telefonnummer FROM (SELECT gk.KDNr, SUM(RechnungsBetrag) AS Kundenumsatz, RechnungsBetrag, KundenNummer"
				+ " FROM (SELECT r.Nr, r.KdNr AS KundenNummer, rb.RechnungsBetrag AS RechnungsBetrag FROM"
				+ " (SELECT r.Nr, SUM(Rechnungspositions_Preis) AS RechnungsBetrag FROM rechnung r INNER JOIN "
				+ "(SELECT rp.RechnungsID, rp.PositionsNr,(a.Preis*rp.Menge) AS Rechnungspositions_Preis FROM Artikel a INNER JOIN rechnungsposition rp "
				+ "ON a.ID=rp.ArtikelID ORDER BY rp.RechnungsID ASC, rp.PositionsNr ASC) AS rppTable ON (r.Nr=rppTable.RechnungsID) GROUP BY r.Nr) AS rb INNER JOIN rechnung r "
				+ "ON rb.Nr=r.Nr) AS Kundenumsatz INNER JOIN geschäftskunde gk ON Kundenumsatz.KundenNummer = gk.KDNr GROUP BY gk.KDNr) AS Kundenumsatz INNER JOIN geschäftskunde gk"
				+ " ON Kundenumsatz.KundenNummer=gk.KDNr INNER JOIN kunde k on gk.KDNr=k.Nr INNER JOIN (SELECT SUM(r.Bezahlt)AS Unbezahlte_Rechnungen, r.KdNr AS KundenNummer, "
				+ "r.Nr AS RechnungsNummer FROM rechnung r WHERE r.Bezahlt=?)AS OffeneRechnungen ON gk.KDNr=OffeneRechnungen.KundenNummer "
				+ "WHERE gk.RechtsformID<>? AND gk.RechtsformID<>2 AND Kundenumsatz.Kundenumsatz<? AND OffeneRechnungen.Unbezahlte_Rechnungen>=?";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setInt(1, bezahlt);
		psKomplex.setInt(2, rechtsformEins);
		psKomplex.setInt(3, rechtsformZwei);
		psKomplex.setDouble(4, kundenUmsatz);
		psKomplex.setInt(5, mengeUnbezahlteRechnungengroesserGleich);
		
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> fuenftesStatement(String land, double kundenUmsatz, int anzahlUnbezahlterRechnungen) throws SQLException{
		String sql ="SELECT gk.Firmenname, un.Rechtsform AS Rechtsform, GeschäftskundenAnschrift.Strasse, GeschäftskundenAnschrift.Haus_Nummer, "
				+ "GeschäftskundenAnschrift.Ort, GeschäftskundenAnschrift.PLZ FROM kunde k INNER JOIN geschäftskunde gk ON k.Nr=gk.KDNr"
				+ " INNER JOIN unternehmensform un ON gk.RechtsformID=un.ID INNER JOIN (SELECT k.Nr AS Kunden_Nummer, l.ID AS LAND,an.Strasse AS Strasse,"
				+ " an.HausNr AS Haus_Nummer, an.PLZ AS PLZ, an.Ort AS Ort FROM kunde k INNER JOIN anschrift an ON k.AnID=an.ID INNER JOIN land l on an.LaID=l.ID) "
				+ "AS GeschäftskundenAnschrift ON GeschäftskundenAnschrift.Kunden_Nummer=gk.KDNr INNER JOIN (SELECT gk.KDNr AS Kunden_Nummer, SUM(RechnungsBetrag) "
				+ "AS Kundenumsatz FROM (SELECT r.Nr, r.KdNr, rb.RechnungsBetrag FROM (SELECT r.Nr, SUM(Rechnungspositions_Preis) AS RechnungsBetrag FROM rechnung r "
				+ "INNER JOIN (SELECT rp.RechnungsID, rp.PositionsNr,(a.Preis*rp.Menge) AS Rechnungspositions_Preis FROM Artikel a INNER JOIN rechnungsposition rp "
				+ "ON a.ID=rp.ArtikelID ORDER BY rp.RechnungsID ASC, rp.PositionsNr ASC) AS rppTable ON (r.Nr=rppTable.RechnungsID) GROUP BY r.Nr) AS rb "
				+ "INNER JOIN rechnung r ON rb.Nr=r.Nr) AS Kundenumsatz INNER JOIN geschäftskunde gk ON Kundenumsatz.KdNr = gk.KDNr GROUP BY gk.KDNr)AS "
				+ "KundenUmsatz ON KundenUmsatz.Kunden_Nummer=gk.KDNr INNER JOIN (SELECT COUNT(r.bezahlt) AS Anzahl_unbezahlter_Rechnungen, r.KdNr AS Kunde_Nummer"
				+ " FROM rechnung r WHERE r.bezahlt='0') AS OffeneRechnungen on OffeneRechnungen.Kunde_Nummer=gk.KDNr WHERE GeschäftskundenAnschrift.LAND=? AND "
				+ "KundenUmsatz.Kundenumsatz>=? AND OffeneRechnungen.Anzahl_unbezahlter_Rechnungen<2;";
		
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setString(1, land);
		psKomplex.setDouble(2, kundenUmsatz);
		psKomplex.setInt(3, anzahlUnbezahlterRechnungen);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> sechstesStatement(String wohnOrt) throws SQLException{
		String sql = "SELECT r.Nr FROM rechnung r INNER JOIN(SELECT an.Ort AS Ort, k.AnID, k.Nr AS Kunden_Nummer FROM kunde k INNER JOIN anschrift an ON k.AnID=an.ID) AS KundenWohnort "
				+ "ON r.KdNr=KundenWohnort.Kunden_Nummer WHERE KundenWohnort.Ort=? ORDER BY r.Nr;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setString(1, wohnOrt);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> siebtesStatement(double rechnungsPreisUntergrenze, double rechnungsPreisObergrenze, int menge, int rechnungsPositionen) throws SQLException{
		String sql = "SELECT u.RechnungsID FROM(SELECT * FROM (SELECT * FROM (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition,"
				+ " artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) k WHERE k.Betrag > ? AND k.Betrag < ?) s,"
				+ "(SELECT rp.RechnungsID AS Rechnungsnummer, rp.PositionsNr, rp.ArtikelID, rp.Menge FROM rechnungsposition rp WHERE Menge>=?) t "
				+ "WHERE s.RechnungsID=t.Rechnungsnummer) u GROUP BY Rechnungsnummer HAVING COUNT(u.PositionsNr)>?";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setDouble(1, rechnungsPreisUntergrenze);
		psKomplex.setDouble(1, rechnungsPreisObergrenze);
		psKomplex.setInt(3, menge);
		psKomplex.setInt(4, rechnungsPositionen);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> achtesStatement(int menge, double rechnungsBetrag) throws SQLException{
		String sql ="SELECT u.artikelID, u.Bezeichnung FROM (SELECT * FROM (SELECT * FROM rechnung, "
				+ "(SELECT * FROM rechnungsposition, (SELECT artikel.ID, artikel.Bezeichnung FROM rechnungsposition, "
				+ "artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.ArtikelID HAVING COUNT(*)>?) k "
				+ "WHERE rechnungsposition.ArtikelID=k.ID) j WHERE rechnung.Nr=j.RechnungsID AND rechnung.Bezahlt=\"0\") s, "
				+ "(SELECT rechnungsposition.RechnungsID AS Rechnungsnummer, SUM(preis*menge) AS Betrag FROM rechnungsposition, artikel "
				+ "WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY Rechnungsnummer) t WHERE s.RechnungsID=t.Rechnungsnummer "
				+ "GROUP BY s.RechnungsID HAVING Betrag>?)u";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setInt(1, menge);
		psKomplex.setDouble(2,rechnungsBetrag);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> neuntesStatement(java.util.Date rechnungsDatumUntergrenzeJava, java.util.Date rechnungsDatumObergrenzeJava, int menge) throws SQLException{
		String sql = "SELECT * FROM rechnung, (SELECT * FROM rechnungsposition,(SELECT artikel.ID, artikel.Bezeichnung FROM rechnungsposition,"
				+ " artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.ArtikelID HAVING COUNT(*)>?)"
				+ " k WHERE rechnungsposition.ArtikelID=k.ID) j" + 
				"WHERE Datum BETWEEN '?' AND '?' AND rechnung.Nr=j.RechnungsID";
		psKomplex = conStatement.prepareStatement(sql);
		
		//Hier bei der Umwandlung bin ich mir nicht sicher ob das so funktioniert
		//könntest du das bei gelegenheit Testen?
		java.sql.Date rechnungsDatumUntergrenzeSQL = new java.sql.Date(rechnungsDatumUntergrenzeJava.getTime());
		java.sql.Date rechnungsDatumObergrenzeSQL = new java.sql.Date(rechnungsDatumObergrenzeJava.getTime());
		
		psKomplex.setInt(1, menge);
		psKomplex.setDate(2, rechnungsDatumUntergrenzeSQL);
		psKomplex.setDate(3, rechnungsDatumObergrenzeSQL);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zehntesStatement(java.util.Date zahlungsZiel, String wohnOrt) throws SQLException{
		String sql ="SELECT s.Nr AS Rechnungsnummer FROM (SELECT * FROM rechnung WHERE Zahlungsziel='2018-04-20') s, (SELECT * FROM geschäftskunde, "
				+ "(SELECT * FROM kunde, anschrift WHERE kunde.AnID=anschrift.ID AND anschrift.Ort=?) k WHERE geschäftskunde.KDNr=k.Nr) t WHERE s.KdNr=t.KDNr;";
	
		psKomplex = conStatement.prepareStatement(sql);
		java.sql.Date zahlungsZielSQL = new java.sql.Date(zahlungsZiel.getTime());
		psKomplex.setDate(1, zahlungsZielSQL);
		psKomplex.setString(2, wohnOrt);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> elftesStatement(double gesamtUmsatz, String wohnOrt) throws SQLException{
		String sql ="SELECT t.Nr, t.Vorname, t.Nachname, t.Gesamtumsatz FROM " + 
				"(SELECT * FROM (SELECT kunde.Nr, kunde.Vorname, kunde.Nachname, SUM(Betrag) AS Gesamtumsatz FROM kunde, (SELECT * FROM rechnung," + 
				"(SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition, artikel WHERE rechnungsposition.ArtikelID=artikel.ID"
				+ " GROUP BY rechnungsposition.RechnungsID) h WHERE rechnung.Nr=h.RechnungsID) j WHERE kunde.Nr=j.KdNr GROUP BY kunde.Nr)s "
				+ "WHERE s.Gesamtumsatz>?) t, (SELECT * FROM kunde, anschrift WHERE kunde.AnID=anschrift.ID AND anschrift.Ort=?) u WHERE t.Nr=u.Nr";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setDouble(1, gesamtUmsatz);
		psKomplex.setString(2, wohnOrt);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zwoelftesStatement(String vorname, String nachname, double betrag) throws SQLException{
		String sql ="SELECT t.Nr AS Rechnungsnummer, t.Betrag FROM (SELECT * FROM kunde WHERE kunde.Nr NOT IN (SELECT geschäftskunde.KDNr "
				+ "FROM geschäftskunde) AND Vorname=? AND Nachname=?) s INNER JOIN "
				+ "(SELECT rechnung.Nr, s.Betrag, rechnung.KdNr FROM rechnung, (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag "
				+ "FROM rechnungsposition, artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) s "
				+ "WHERE rechnung.Nr=s.RechnungsID AND Betrag>=?) t ON t.KdNr=s.Nr;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setString(1, vorname);
		psKomplex.setString(2, nachname);
		psKomplex.setDouble(3, betrag);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> dreizehntesStatement(String rechtsform, double gesamtUmsatzUntergrenze, double gesamtUmsatzObergrenze) throws SQLException{
		String sql ="SELECT u.KDNr, u.Firmenname FROM (SELECT * FROM geschäftskunde, unternehmensform "
				+ "WHERE geschäftskunde.RechtsformID=unternehmensform.ID AND unternehmensform.Rechtsform=?)u, "
				+ "(SELECT * FROM (SELECT kunde.Nr, kunde.Vorname, kunde.Nachname, SUM(Betrag) AS Gesamtumsatz FROM kunde, "
				+ "(SELECT * FROM rechnung, (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition, "
				+ "artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) h WHERE rechnung.Nr=h.RechnungsID) j "
				+ "WHERE kunde.Nr=j.KdNr GROUP BY kunde.Nr) t WHERE t.Gesamtumsatz > ? AND t.Gesamtumsatz<?)s WHERE u.KDNr=s.Nr;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setString(1, rechtsform);
		psKomplex.setDouble(2, gesamtUmsatzUntergrenze);
		psKomplex.setDouble(3, gesamtUmsatzObergrenze);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> vierzenhtesStatement(String strasse, int zahlungsArt) throws SQLException{
		String sql ="SELECT s.Nr AS Rechnungsnummer FROM (SELECT r.Nr FROM rechnung r INNER JOIN "
				+ "(SELECT * FROM kunde k INNER JOIN anschrift a ON k.AnID=a.ID AND a.Strasse=?) k ON r.KdNr=k.Nr)"
				+ " s INNER JOIN (SELECT r.Nr FROM rechnung r INNER JOIN zahlungsart z ON r.TransNr=z.TransID AND z.ZANr=?) t ON s.Nr=t.Nr;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setString(1, strasse);
		psKomplex.setInt(2, zahlungsArt);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> fuenfzenhtesStatement(String land) throws SQLException{
		String sql ="SELECT u.KundenNr, u.vorname, u.nachname FROM (SELECT s.Nr AS KundenNr, s.vorname, s.nachname FROM "
				+ "(SELECT * FROM kunde WHERE kunde.Nr NOT IN (SELECT gk.KDNr FROM geschäftskunde gk))s "
				+ "INNER JOIN (SELECT anschrift.ID FROM anschrift INNER JOIN land ON anschrift.LaID=land.ID AND "
				+ "land.Land=?) t ON s.AnID=t.ID) u INNER JOIN (SELECT kunde.Nr FROM kunde WHERE kunde.Nr "
				+ "NOT IN (SELECT DISTINCT kunde.Nr FROM (SELECT * FROM rechnung WHERE rechnung.Bezahlt=0) s INNER JOIN kunde ON kunde.Nr=s.KdNr)) "
				+ "v ON u.KundenNr=v.Nr;";
		
		psKomplex = conStatement.prepareStatement(sql);
		psKomplex.setString(1, land);
		setPs(psKomplex);
		ArrayList<LinkedHashMap<String, String>> querry = db.konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	
	
	
}
