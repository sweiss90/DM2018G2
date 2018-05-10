package test_Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			setCon(con);
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
	public ArrayList<LinkedHashMap<String, String>> lesenJava2() throws SQLException{
		Statement stm=con.createStatement();
		return konvertiereJava(stm.executeQuery("Select * FROM kunde"));
	}
	public ArrayList<LinkedHashMap<String, String>> lesenJava(){
		try{
			return konvertiereJava(ps.executeQuery());
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("DB lesenJava: "+e.getMessage());
		}
	}
	public ArrayList<LinkedHashMap<String, String>> konvertiereJava(ResultSet rs) throws SQLException{
		ArrayList<LinkedHashMap<String, String>> daten=new ArrayList<>();
		int anz_spalten=rs.getMetaData().getColumnCount();
		if(anz_spalten==0) return null;
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
		//return konvertiereErgebnisTabelle(daten);
		return daten;
	}
	public void schreiben(){
		try{
			ps.execute();
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("DB schreiben: "+e.getMessage());
		}
	}
	
	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public int getCounter_prepared() {
		return counter_prepared;
	}

	public void setCounter_prepared(int counter_prepared) {
		this.counter_prepared = counter_prepared;
	}
	
	
	
	

}
