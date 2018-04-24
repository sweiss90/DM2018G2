package test_Datenbank;

import java.sql.DriverManager;
import java.sql.*;

public class Testklasse {

	public static void main(String[] args) {
		Connection con=null;
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost/rechnungsverwaltung_kopie", "root", "");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("Select * FROM kunde");
			while(rs.next()){
				System.out.println(rs.getString("Nachname") + ", " + rs.getString("Vorname")+ ", "+ rs.getString("Email"));
			}
			Statement stmm=con.createStatement();
			//stmm.execute("INSERT INTO unternehmensform(Rechtsform) VALUES('gAG')");
			
			
			ResultSet rs2=stm.executeQuery("Select * FROM unternehmensform");
			
			System.out.println("------------\n");
			while(rs2.next()){
				System.out.println(rs2.getInt("ID") + ", " + rs2.getString("Rechtsform"));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
