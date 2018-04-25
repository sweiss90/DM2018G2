package test_Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DB {
	private PreparedStatement ps=null;
	private Connection con=null;
	private int counter_prepared=1;
	
	public DB(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost/rechnungsverwaltung_kopie", "root", "");
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Der DB-Zugang ist nicht vorhanden!");
		}
	}
	
	public void close(){
		finalize();
	}
	
	@Override
	public void finalize(){
		try{
			ps.close();
		} catch(SQLException e){}
		ps=null;
		try{
			con.close();
		}catch(SQLException e) {}
		con=null;
	}
	
	public void setSQL(String sql){
		try{
			ps=con.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("SQL-Fehler: "+e.getMessage());
			
		}
	}
	public String lesenJava(){
		try{
			return konvertiereJava(ps.executeQuery());
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("DB lesenJava: "+e.getMessage());
		}
	}
	private String konvertiereJava(ResultSet rs) throws SQLException{
		ArrayList<LinkedHashMap<String, String>> daten=new ArrayList<>();
		int anz_spalten=rs.getMetaData().getColumnCount();
		if(anz_spalten==0) return "<keine Datensätze>";
		while(rs.next()){
			LinkedHashMap<String, String> datensatz=new LinkedHashMap<>();
			for(int i=1;i<=anz_spalten;i++){
				String name=rs.getMetaData().getColumnName(i);
				String wert=rs.getString(name);
				if(wert!=null)
					datensatz.put(name, wert);
				else
					datensatz.put(name, "");
			}
			daten.add(datensatz);
		}
		return(konvertiereErgebnisTabelle(daten));
	}
	public void schreiben(){
		try{
			ps.execute();
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("DB schreiben: "+e.getMessage());
		}
	}
	private String konvertiereErgebnisTabelle(ArrayList<LinkedHashMap<String, String>> tab){
		String erg=new String("<HTML>");
		for(LinkedHashMap<String, String> datensatz:tab){
			erg+=""+datensatz+"<br>";
		}
		return erg;
	}
	
	public void fügeKundeEin(Kunde k) throws SQLException{
		String sql="INSERT INTO kunde(Vorname, Nachname, Email, TelefonNr, AnID) VALUES (?,?,?,?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1, k.getVorname());
		ps.setString(2, k.getNachname());
		ps.setString(3, k.getEmail());
		ps.setString(4, k.getTelefonNr());
		ps.setString(5, k.getAnID());
		ps.execute();
		
	}
	
	public void löscheKunde(Kunde k) throws SQLException{
		String sql="DELETE FROM kunde WHERE Vorname=? AND Nachname=? AND EMail=? AND TelefonNr=? AND AnID=?;";
		ps=con.prepareStatement(sql);
		ps.setString(1, k.getVorname());
		ps.setString(2, k.getNachname());
		ps.setString(3, k.getEmail());
		ps.setString(4, k.getTelefonNr());
		ps.setString(5, k.getAnID());
		ps.execute();
		
	}
	
	public void fügeRechnungEin(Rechnung r) throws SQLException{
		String sql="INSERT INTO rechnung(Datum, Bezahlt, Zahlungsziel, KdNr, TransNr) VALUES (?,?,?,?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1, r.getDatum());
		ps.setString(2, r.getBezahlt());
		ps.setString(3, r.getZahlungsziel());
		ps.setString(4, r.getKdNr());
		ps.setString(5, r.getTransNr());
		ps.execute();
		
	}
	
	public void löscheRechnung(Rechnung r) throws SQLException{
		String sql="DELETE FROM rechnung WHERE Datum=? AND bezahlt=? AND Zahlungsziel=? AND KdNr=? AND TransNr=?;";
		ps=con.prepareStatement(sql);
		ps.setString(1, r.getDatum());
		ps.setString(2, r.getBezahlt());
		ps.setString(3, r.getZahlungsziel());
		ps.setString(4, r.getKdNr());
		ps.setString(5, r.getTransNr());
		ps.execute();
		
	}
	
	public void fügeGeschäftskundeEin(Geschäftskunde gk) throws SQLException{
		String sql="INSERT INTO geschäftskunde(KDNr, Firmenname, RechtsformID) VALUES (?,?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1, gk.getKDNr());
		ps.setString(2, gk.getFirmenname());
		ps.setString(3, gk.getRechtsformID());
		ps.execute();
	}
	
	public void löscheGeschäftskunde(Geschäftskunde gk) throws SQLException{
		String sql="DELETE FROM geschäftskunde WHERE KDNr=? AND Firmenname=? AND RechtsformID=?;";
		ps=con.prepareStatement(sql);
		ps.setString(1, gk.getKDNr());
		ps.setString(2, gk.getFirmenname());
		ps.setString(3, gk.getRechtsformID());
		ps.execute();
		
	}
	
	public void fügeAnschriftEin(Anschrift a) throws SQLException{
		String sql="INSERT INTO anschrift(Strasse, HausNr, PLZ, Ort, LaID) VALUES(?,?,?,?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1, a.getStrasse());
		ps.setString(2, a.getHausNr());
		ps.setString(3, a.getPlZ());
		ps.setString(4, a.getOrt());;
		ps.setString(5, a.getLaID());
		ps.execute();
	}
	
	public void löscheAnschrift(Anschrift a) throws SQLException{
		String sql="DELETE FROM anschrift WHERE Strasse=? AND HausNr=? AND PLZ=? AND Ort=? AND LaID=?;";
		ps=con.prepareStatement(sql);
		ps.setString(1, a.getStrasse());
		ps.setString(2, a.getHausNr());
		ps.setString(3, a.getPlZ());
		ps.setString(4, a.getOrt());;
		ps.setString(5, a.getLaID());
		ps.execute();
	
	}
	
	public void fügeRechnungspositionEin(Rechnung.Rechnungsposition rp) throws SQLException{
		String sql="INSERT INTO rechnungsposition(RechnungsID, PositionsNr, ArtikelID, Menge) VALUES(?,?,?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1, rp.getNr());
		ps.setString(2, rp.getPositionsNr());
		ps.setString(3, rp.getArtikelID());
		ps.setString(4, rp.getMenge());
		ps.execute();
		
	}
	public void löscheRechnungsposition(Rechnung.Rechnungsposition rp) throws SQLException{
		String sql="DELETE FROM rechnungsposition WHERE RechnungsID=? AND PositionsNr=? AND ArtikelID=? AND Menge=?;";
		ps=con.prepareStatement(sql);
		ps.setString(1, rp.getNr());
		ps.setString(2, rp.getPositionsNr());
		ps.setString(3, rp.getArtikelID());
		ps.setString(4, rp.getMenge());
		ps.execute();
		
	}
	public void fügeLandEin(Land la) throws SQLException{
		String sql="INSERT INTO land(ID, Land) VALUES(?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1, la.getId());
		ps.setString(2, la.getLand());
		ps.execute();
	}
	public void löscheLand(Land la) throws SQLException{
		String sql="DELETE FROM land WHERE ID=? AND LAND=?;";
		ps=con.prepareStatement(sql);
		ps.setString(1, la.getId());
		ps.setString(2, la.getLand());
		ps.execute();
	}

}
