package test_Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PreparedStatementKomplex {

	private testGUI gui;
	private PreparedStatement psKomplex;
	
	public PreparedStatementKomplex(testGUI gui) {
		this.gui=gui;	}

	public PreparedStatement getPs() {
		return psKomplex;
	}
	
	public void setPs(PreparedStatement ps) {
		this.psKomplex = ps;
	}
	
	public ArrayList<LinkedHashMap<String, String>> erstesStatement(String maxMengeUnbezahlterRechnungen, String land) throws SQLException {
		
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
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, maxMengeUnbezahlterRechnungen);
		psKomplex.setString(2, land);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zweitesStatement(String unternehmensform, String land) throws SQLException{
		String sql="SELECT * FROM (SELECT * FROM (SELECT * FROM(SELECT Firmenname, geschäftskunde.KDNr FROM geschäftskunde, unternehmensform WHERE geschäftskunde.RechtsformID=unternehmensform.ID and unternehmensform.ID=?) m, kunde WHERE m.KDNr=kunde.Nr) k," + 
				"(SELECT anschrift.ID, anschrift.Strasse, land.Land FROM anschrift, land WHERE anschrift.LaID=land.ID AND LAND.ID=?) l WHERE k.AnID=l.ID) s," + 
				"(SELECT kunde.Nr, kunde.Vorname, kunde.Nachname, SUM(Betrag) AS Gesamtumsatz FROM kunde, "
				+ "(SELECT * FROM rechnung, (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition, artikel "
				+ "WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) h WHERE rechnung.Nr=h.RechnungsID) j WHERE kunde.Nr=j.KdNr GROUP BY kunde.Nr) t " + 
				"WHERE s.ID=t.Nr;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, unternehmensform);
		psKomplex.setString(2, land);
		ArrayList<LinkedHashMap<String, String>> querry =gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> drittesStatement(String rechnungsPosMenge, String bezahlt) throws SQLException{
		String sql="SELECT a.Preis FROM (SELECT rp.Menge, rp.ArtikelID, rp.RechnungsID FROM rechnungsposition rp) AS rechnungsposition "
				+ "INNER JOIN artikel a ON a.ID=rechnungsposition.ArtikelID INNER JOIN (SELECT r.Nr AS Rechnungsnummer, r.Bezahlt FROM rechnung r WHERE r.Bezahlt=?) AS rechnung "
				+ "ON rechnungsposition.RechnungsID=rechnung.Rechnungsnummer WHERE rechnungsposition.Menge>=? AND rechnung.Bezahlt=?;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, bezahlt);
		psKomplex.setString(2, rechnungsPosMenge);
		psKomplex.setString(3, bezahlt);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> viertesStatement(String bezahlt, String rechtsformEins, String rechtsformZwei, String kundenUmsatz, String mengeUnbezahlteRechnungengroesserGleich) throws SQLException{
		String sql ="SELECT Kundenumsatz.RechnungsBetrag, OffeneRechnungen.RechnungsNummer, gk.Firmenname, k.Vorname AS Ansprechpartner_Vorname, k.Nachname Ansprechpartner_Nachname, "
				+ "k.Email AS EMail, k.TelefonNr AS Telefonnummer FROM (SELECT gk.KDNr, SUM(RechnungsBetrag) AS Kundenumsatz, RechnungsBetrag, KundenNummer"
				+ " FROM (SELECT r.Nr, r.KdNr AS KundenNummer, rb.RechnungsBetrag AS RechnungsBetrag FROM"
				+ " (SELECT r.Nr, SUM(Rechnungspositions_Preis) AS RechnungsBetrag FROM rechnung r INNER JOIN "
				+ "(SELECT rp.RechnungsID, rp.PositionsNr,(a.Preis*rp.Menge) AS Rechnungspositions_Preis FROM Artikel a INNER JOIN rechnungsposition rp "
				+ "ON a.ID=rp.ArtikelID ORDER BY rp.RechnungsID ASC, rp.PositionsNr ASC) AS rppTable ON (r.Nr=rppTable.RechnungsID) GROUP BY r.Nr) AS rb INNER JOIN rechnung r "
				+ "ON rb.Nr=r.Nr) AS Kundenumsatz INNER JOIN geschäftskunde gk ON Kundenumsatz.KundenNummer = gk.KDNr GROUP BY gk.KDNr) AS Kundenumsatz INNER JOIN geschäftskunde gk"
				+ " ON Kundenumsatz.KundenNummer=gk.KDNr INNER JOIN kunde k on gk.KDNr=k.Nr INNER JOIN (SELECT SUM(r.Bezahlt)AS Unbezahlte_Rechnungen, r.KdNr AS KundenNummer, "
				+ "r.Nr AS RechnungsNummer FROM rechnung r WHERE r.Bezahlt=?)AS OffeneRechnungen ON gk.KDNr=OffeneRechnungen.KundenNummer "
				+ "WHERE gk.RechtsformID<>? AND gk.RechtsformID<>? AND Kundenumsatz.Kundenumsatz<? AND OffeneRechnungen.Unbezahlte_Rechnungen>=?";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, bezahlt);
		psKomplex.setString(2, rechtsformEins);
		psKomplex.setString(3, rechtsformZwei);
		psKomplex.setString(4, kundenUmsatz);
		psKomplex.setString(5, mengeUnbezahlteRechnungengroesserGleich);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> fuenftesStatement(String land, String kundenUmsatz, String anzahlUnbezahlterRechnungen) throws SQLException{
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
				+ "KundenUmsatz.Kundenumsatz>=? AND OffeneRechnungen.Anzahl_unbezahlter_Rechnungen<?;";
		
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, land);
		psKomplex.setString(2, kundenUmsatz);
		psKomplex.setString(3, anzahlUnbezahlterRechnungen);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> sechstesStatement(String wohnOrt) throws SQLException{
		String sql = "SELECT r.Nr FROM rechnung r INNER JOIN(SELECT an.Ort AS Ort, k.AnID, k.Nr AS Kunden_Nummer FROM kunde k INNER JOIN anschrift an ON k.AnID=an.ID) AS KundenWohnort "
				+ "ON r.KdNr=KundenWohnort.Kunden_Nummer WHERE KundenWohnort.Ort=? ORDER BY r.Nr;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, wohnOrt);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> siebtesStatement(String rechnungsPreisUntergrenze, String rechnungsPreisObergrenze, String menge, String rechnungsPositionen) throws SQLException{
		String sql = "SELECT u.RechnungsID FROM(SELECT * FROM (SELECT * FROM (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition,"
				+ " artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) k WHERE k.Betrag > ? AND k.Betrag < ?) s,"
				+ "(SELECT rp.RechnungsID AS Rechnungsnummer, rp.PositionsNr, rp.ArtikelID, rp.Menge FROM rechnungsposition rp WHERE Menge>=?) t "
				+ "WHERE s.RechnungsID=t.Rechnungsnummer) u GROUP BY Rechnungsnummer HAVING COUNT(u.PositionsNr)>=?";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, rechnungsPreisUntergrenze);
		psKomplex.setString(2, rechnungsPreisObergrenze);
		psKomplex.setString(3, menge);
		psKomplex.setString(4, rechnungsPositionen);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> achtesStatement(String menge, String rechnungsBetrag) throws SQLException{
		String sql ="SELECT * FROM (SELECT u.artikelID, u.Bezeichnung FROM (SELECT * FROM (SELECT * FROM rechnung, "
				+ "(SELECT * FROM rechnungsposition, (SELECT artikel.ID, artikel.Bezeichnung FROM rechnungsposition, "
				+ "artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.ArtikelID HAVING COUNT(*)>?) k "
				+ "WHERE rechnungsposition.ArtikelID=k.ID) j WHERE rechnung.Nr=j.RechnungsID AND rechnung.Bezahlt=\"0\") s, "
				+ "(SELECT rechnungsposition.RechnungsID AS Rechnungsnummer, SUM(preis*menge) AS Betrag FROM rechnungsposition, artikel "
				+ "WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY Rechnungsnummer) t WHERE s.RechnungsID=t.Rechnungsnummer "
				+ "GROUP BY s.RechnungsID HAVING Betrag>?)u)w GROUP BY Bezeichnung";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, menge);
		psKomplex.setString(2,rechnungsBetrag);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> neuntesStatement(String rechnungsDatumUntergrenzeJava, String rechnungsDatumObergrenzeJava, String menge) throws SQLException{
		String sql = "SELECT Bezeichnung FROM (SELECT * FROM rechnung, (SELECT * FROM rechnungsposition,(SELECT artikel.ID, artikel.Bezeichnung FROM rechnungsposition, "
				+ "artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.ArtikelID HAVING COUNT(*)>?) "
				+ "k WHERE rechnungsposition.ArtikelID=k.ID) j " 
				+ "WHERE Datum BETWEEN ? AND ? AND rechnung.Nr=j.RechnungsID) p GROUP BY Bezeichnung";
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		
		psKomplex.setString(1, menge);
		psKomplex.setString(2, rechnungsDatumUntergrenzeJava);
		psKomplex.setString(3, rechnungsDatumObergrenzeJava);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zehntesStatement(String zahlungsZiel, String wohnOrt) throws SQLException{
		String sql ="SELECT s.Nr FROM (SELECT * FROM rechnung WHERE Zahlungsziel=?) s, (SELECT * FROM geschäftskunde, "
				+ "(SELECT * FROM kunde, anschrift WHERE kunde.AnID=anschrift.ID AND anschrift.Ort=?) k WHERE geschäftskunde.KDNr=k.Nr) t WHERE s.KdNr=t.KDNr;";
	
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, zahlungsZiel);
		psKomplex.setString(2, wohnOrt);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> elftesStatement(String gesamtUmsatz, String wohnOrt) throws SQLException{
		String sql ="SELECT t.Nr, t.Vorname, t.Nachname, t.Gesamtumsatz FROM " + 
				"(SELECT * FROM (SELECT kunde.Nr, kunde.Vorname, kunde.Nachname, SUM(Betrag) AS Gesamtumsatz FROM kunde, (SELECT * FROM rechnung," + 
				"(SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition, artikel WHERE rechnungsposition.ArtikelID=artikel.ID"
				+ " GROUP BY rechnungsposition.RechnungsID) h WHERE rechnung.Nr=h.RechnungsID) j WHERE kunde.Nr=j.KdNr GROUP BY kunde.Nr)s "
				+ "WHERE s.Gesamtumsatz>?) t, (SELECT * FROM kunde, anschrift WHERE kunde.AnID=anschrift.ID AND anschrift.Ort=?) u WHERE t.Nr=u.Nr";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, gesamtUmsatz);
		psKomplex.setString(2, wohnOrt);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> zwoelftesStatement(String vorname, String nachname, String betrag) throws SQLException{
		String sql ="SELECT t.Nr, t.Betrag FROM (SELECT * FROM kunde WHERE kunde.Nr NOT IN (SELECT geschäftskunde.KDNr "
				+ "FROM geschäftskunde) AND Vorname=? AND Nachname=?) s INNER JOIN "
				+ "(SELECT rechnung.Nr, s.Betrag, rechnung.KdNr FROM rechnung, (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag "
				+ "FROM rechnungsposition, artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) s "
				+ "WHERE rechnung.Nr=s.RechnungsID AND Betrag>=?) t ON t.KdNr=s.Nr;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, vorname);
		psKomplex.setString(2, nachname);
		psKomplex.setString(3, betrag);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> dreizehntesStatement(String rechtsform, String gesamtUmsatzUntergrenze, String gesamtUmsatzObergrenze) throws SQLException{
		String sql ="SELECT u.KDNr, u.Firmenname FROM (SELECT * FROM geschäftskunde, unternehmensform "
				+ "WHERE geschäftskunde.RechtsformID=unternehmensform.ID AND unternehmensform.Rechtsform=?)u, "
				+ "(SELECT * FROM (SELECT kunde.Nr, kunde.Vorname, kunde.Nachname, SUM(Betrag) AS Gesamtumsatz FROM kunde, "
				+ "(SELECT * FROM rechnung, (SELECT rechnungsposition.RechnungsID, SUM(preis*menge) AS Betrag FROM rechnungsposition, "
				+ "artikel WHERE rechnungsposition.ArtikelID=artikel.ID GROUP BY rechnungsposition.RechnungsID) h WHERE rechnung.Nr=h.RechnungsID) j "
				+ "WHERE kunde.Nr=j.KdNr GROUP BY kunde.Nr) t WHERE t.Gesamtumsatz > ? AND t.Gesamtumsatz<?)s WHERE u.KDNr=s.Nr;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, rechtsform);
		psKomplex.setString(2, gesamtUmsatzUntergrenze);
		psKomplex.setString(3, gesamtUmsatzObergrenze);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> vierzehntesStatement(String strasse, String zahlungsArt) throws SQLException{
		String sql ="SELECT s.Nr AS Rechnungsnummer FROM (SELECT r.Nr FROM rechnung r INNER JOIN "
				+ "(SELECT * FROM kunde k INNER JOIN anschrift a ON k.AnID=a.ID AND a.Strasse=?) k ON r.KdNr=k.Nr)"
				+ " s INNER JOIN (SELECT r.Nr FROM rechnung r INNER JOIN zahlungsart z ON r.TransNr=z.TransID AND z.ZANr=?) t ON s.Nr=t.Nr;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, strasse);
		psKomplex.setString(2, zahlungsArt);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	public ArrayList<LinkedHashMap<String, String>> fuenfzenhtesStatement(String land) throws SQLException{
		String sql ="SELECT u.KundenNr, u.vorname, u.nachname FROM (SELECT s.Nr AS KundenNr, s.vorname, s.nachname FROM "
				+ "(SELECT * FROM kunde WHERE kunde.Nr NOT IN (SELECT gk.KDNr FROM geschäftskunde gk))s "
				+ "INNER JOIN (SELECT anschrift.ID FROM anschrift INNER JOIN land ON anschrift.LaID=land.ID AND "
				+ "land.Land=?) t ON s.AnID=t.ID) u INNER JOIN (SELECT kunde.Nr FROM kunde WHERE kunde.Nr "
				+ "NOT IN (SELECT DISTINCT kunde.Nr FROM (SELECT * FROM rechnung WHERE rechnung.Bezahlt=0) s INNER JOIN kunde ON kunde.Nr=s.KdNr)) "
				+ "v ON u.KundenNr=v.Nr;";
		
		psKomplex = gui.getVb().getCon().prepareStatement(sql);
		psKomplex.setString(1, land);
		ArrayList<LinkedHashMap<String, String>> querry = gui.getVb().konvertiereJava(psKomplex.executeQuery());
		return querry;
	}
	
	
	
	
}
