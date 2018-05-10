package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventHandlerKomplexeAbfragen implements ActionListener {
	private testGUI gui=null;
	public EventHandlerKomplexeAbfragen(testGUI gui){
		this.gui=gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		PreparedStatementKomplex psk=new PreparedStatementKomplex(gui);
		if(ev.getSource()==gui.getK11()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.erstesStatement(gui.getKa2().getText(), gui.getKa1().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK12()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.zweitesStatement(gui.getKa4().getText(), gui.getKa3().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK13()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.drittesStatement(gui.getKa5().getText(), gui.getKa6().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK14()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.viertesStatement(gui.getKa8().getText(), gui.getKa10().getText(),
						gui.getKa11().getText(), gui.getKa9().getText(), gui.getKa7().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK15()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.fuenftesStatement(gui.getKa14().getText(), gui.getKa12().getText(), 
						gui.getKa13().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK16()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.sechstesStatement(gui.getKa15().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK17()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.siebtesStatement(gui.getKa16().getText(), gui.getKa17().getText(), 
						gui.getKa19().getText(),gui.getKa18().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK18()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.achtesStatement(gui.getKa20().getText(), gui.getKa21().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK19()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.neuntesStatement(gui.getKa23().getText(), gui.getKa24().getText(),gui.getKa22().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK20()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.zehntesStatement(gui.getKa25().getText(), gui.getKa26().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK21()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.elftesStatement(gui.getKa27().getText(), gui.getKa28().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK22()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.zwoelftesStatement(gui.getKa30().getText(), gui.getKa31().getText(), gui.getKa29().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK23()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.dreizehntesStatement(gui.getKa32().getText(), gui.getKa33().getText(), gui.getKa34().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK24()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.vierzehntesStatement(gui.getKa35().getText(), gui.getKa36().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(ev.getSource()==gui.getK25()){
			try{
				String erg=konvertiereErgebnisTabelle(psk.fuenfzenhtesStatement(gui.getKa37().getText()));
				zeigeErgebnis(erg);
				}
			catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private static String konvertiereErgebnisTabelle(ArrayList<LinkedHashMap<String, String>> result) {
		String erg=new String("<HTML>");
		for(LinkedHashMap<String, String> datensatz:result){
			erg+=datensatz+"<br/>";
		}
		return erg+="</HTML>";
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
