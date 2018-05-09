package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class EventHandlerEinfacheAbfragen implements ActionListener {
	private testGUI gui;
	private JInternalFrame itf;
	
	public EventHandlerEinfacheAbfragen(testGUI gui){
		this.gui=gui;
	}
	public void actionPerformed(ActionEvent e){
		PreparedStatementsEinfach pse=new PreparedStatementsEinfach(gui);
		if(e.getSource()==gui.getB11()){
			try {
				String result=konvertiereErgebnisTabelle(pse.erstesStatement(gui.getL11().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==gui.getB12()){
			try {
				String result=konvertiereErgebnisTabelle(pse.zweitesStatement(gui.getL12().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==gui.getB13()){
			try {
				String result=konvertiereErgebnisTabelle(pse.drittesStatement(gui.getL13().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==gui.getB14()){
			try {
				String result=konvertiereErgebnisTabelle(pse.viertesStatement(gui.getL14().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==gui.getB15()){
			try {
				String result=konvertiereErgebnisTabelle(pse.fuenftesStatement(gui.getL15().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==gui.getB16()){
			try {
				String result=konvertiereErgebnisTabelle(pse.sechstesStatement(gui.getL16().getText(),gui.getL162().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		else if(e.getSource()==gui.getB17()){
			try {
				String result=konvertiereErgebnisTabelle(pse.siebtesStatement(gui.getL17().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		else if(e.getSource()==gui.getB18()){
			try {
				String result=konvertiereErgebnisTabelle(pse.achtesStatement(gui.getL18().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
		else if(e.getSource()==gui.getB19()){
			try {
				String result=konvertiereErgebnisTabelle(pse.neuntesStatement(gui.getL19().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
		else if(e.getSource()==gui.getB21()){
			try {
				String result=konvertiereErgebnisTabelle(pse.zehntestatement(gui.getL21().getText()));
				zeigeErgebnis(result);
				
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
		
	}
	private String konvertiereErgebnisTabelle(ArrayList<LinkedHashMap<String, String>> result) {
		String erg=new String("<HTML>");
		for(LinkedHashMap<String, String> datensatz:result){
			erg+=datensatz+"<br>";
		}
		return (erg+="</HTML>");
	}
	private static void zeigeErgebnis(String erg){
		JFrame jf=new JFrame("Ergebnis");
		JLabel l1=new JLabel(erg);
		jf.add(l1);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	
}
