package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class EventHandlerButtons implements ActionListener {
	private testGUI testgui;
	
	public EventHandlerButtons(testGUI gui){
			this.testgui=Objects.requireNonNull(gui);
		}
	

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==testgui.getkSende()){
			
			Kunde k=new Kunde(testgui.getKtf1().getText(), testgui.getKtf2().getText(), testgui.getKtf3().getText(),testgui.getKtf4().getText(),testgui.getKtf5().getText());
			if(eingabenPrüfenKunde(k)){ 
				try{
				 testgui.getVb().fügeKundeEin(k);
				 }
				 catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getkLösche()){
			Kunde k=new Kunde(testgui.getKtf1().getText(), testgui.getKtf2().getText(), testgui.getKtf3().getText(),testgui.getKtf4().getText(), testgui.getKtf5().getText());
			if(eingabenPrüfenKunde(k)){
			try{
				 testgui.getVb().löscheKunde(k);
				 }
				 catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getrSende()){
			Rechnung r=new Rechnung(testgui.getRtf1().getText(), testgui.getRtf2().getText(), testgui.getRtf3().getText(), testgui.getRtf4().getText(), testgui.getRtf5().getText());
			if(eingabenPrüfenRechnung(r)){
				try{
					testgui.getVb().fügeRechnungEin(r);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getrLösche()){
			Rechnung r=new Rechnung(testgui.getRtf1().getText(), testgui.getRtf2().getText(), testgui.getRtf3().getText(), testgui.getRtf4().getText(), testgui.getRtf5().getText());
			if(true){
				try{
					testgui.getVb().löscheRechnung(r);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getGkSende()){
			Geschäftskunde gk=new Geschäftskunde(testgui.getGktf1().getText(), testgui.getGktf2().getText(), testgui.getGktf3().getText());
			if(true){
				try{
					testgui.getVb().fügeGeschäftskundeEin(gk);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getGkLösche()){
			Geschäftskunde gk=new Geschäftskunde(testgui.getGktf1().getText(), testgui.getGktf2().getText(), testgui.getGktf3().getText());
			if(true){
				try{
					testgui.getVb().löscheGeschäftskunde(gk);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaSende()){
			Anschrift a=new Anschrift(testgui.getAtf1().getText(), testgui.getAtf2().getText(), testgui.getAtf3().getText(), testgui.getAtf4().getText(), testgui.getAtf5().getText());
			if(true){
				try{
					testgui.getVb().fügeAnschriftEin(a);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaLösche()){
			Anschrift a=new Anschrift(testgui.getAtf1().getText(), testgui.getAtf2().getText(), testgui.getAtf3().getText(), testgui.getAtf4().getText(), testgui.getAtf5().getText());
			if(true){
				try{
					testgui.getVb().löscheAnschrift(a);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getRpSende()){
			Rechnung r=new Rechnung(testgui.getRptf1().getText(), null, null, null ,null, null);
			Rechnung.Rechnungsposition rp= r.new Rechnungsposition(testgui.getRptf2().getText(), testgui.getRptf3().getText(), testgui.getRptf4().getText());
			if(true){
				try{
					testgui.getVb().fügeRechnungspositionEin(rp);
				}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getRpLösche()){
			Rechnung r=new Rechnung(testgui.getRptf1().getText(), null, null, null ,null, null);
			Rechnung.Rechnungsposition rp= r.new Rechnungsposition(testgui.getRptf2().getText(), testgui.getRptf3().getText(), testgui.getRptf4().getText());
			if(true){
				try{
					testgui.getVb().löscheRechnungsposition(rp);
					}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getLaSende()){
			Land la=new Land(testgui.getLatf1().getText(), testgui.getLatf2().getText());
			if(true){
				try{
					testgui.getVb().fügeLandEin(la);
				}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getLaLösche()){
			Land la=new Land(testgui.getLatf1().getText(), testgui.getLatf2().getText());
			if(true){
				try{
					testgui.getVb().löscheLand(la);
				}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
				
		
	}
	public boolean eingabenPrüfenKunde(Kunde k){
		Pattern vorname=Pattern.compile("[[a-z]|\\-]{2,}");
		Matcher m1=vorname.matcher(k.getVorname());
		boolean gleich1=m1.matches();
		
		Pattern nachname=Pattern.compile("[[a-z]|\\-]{2,}");
		Matcher m2=nachname.matcher(k.getNachname());
		boolean gleich2=m2.matches();
		
		Pattern telefon=Pattern.compile("[1-9]{3,}");
		Matcher m3=telefon.matcher(k.getTelefonNr());
		boolean gleich3=m3.matches();
		
		Pattern AnID=Pattern.compile("[1-9]{1,}");
		Matcher m4=AnID.matcher(k.getAnID()+"");
		boolean gleich4=m4.matches();
		
		if(gleich1 && gleich2 && gleich3 && gleich4)
			return true;
		else
			return false;
	}
	public boolean eingabenPrüfenRechnung(Rechnung r){
		Pattern bezahlt=Pattern.compile("[0|1]{1}");
		Matcher m1=bezahlt.matcher(r.getBezahlt());
		boolean gleich1=m1.matches();
		
		Pattern KundenNr=Pattern.compile("[1-9]{1,}");
		Matcher m2=KundenNr.matcher(r.getKdNr());
		boolean gleich2=m2.matches();
		
		if(gleich2&&gleich1)
			return true;
		else
			return false;
	}

}
