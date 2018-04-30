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
			
			Kunde k=new Kunde(null, testgui.getKtf1().getText(), testgui.getKtf2().getText(), testgui.getKtf3().getText(),testgui.getKtf4().getText(),testgui.getKtf5().getText());
			if(true){ 
				try{
				 KundenListe.getkundenListe().f�geKundeEin(testgui.getVb(), k);
				 }
				 catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getkL�sche()){
			Kunde k=new Kunde(null, testgui.getKtf1().getText(), testgui.getKtf2().getText(), testgui.getKtf3().getText(),testgui.getKtf4().getText(), testgui.getKtf5().getText());
			if(true){
			try{
				 KundenListe.getkundenListe().l�scheKunde(testgui.getVb(), k);
				
				 }
				 catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getk�ndern()){
			Kunde kundAlt=(Kunde) testgui.getCb().getSelectedItem();
 			Kunde kundNeu=new Kunde(kundAlt.getNr(), testgui.getKtf6().getText(), testgui.getKtf7().getText(), testgui.getKtf9().getText(),testgui.getKtf8().getText(), testgui.getKtf10().getText());
			if(true){
			try{
				KundenListe.getkundenListe().�ndereKunde(testgui.getVb(), kundNeu, kundAlt);
				
				 }
				 catch(Exception ex){throw new RuntimeException("�ndern nicht m�glich!");}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(e.getSource()==testgui.getrSende()){
			Rechnung r=new Rechnung(testgui.getRtf1().getText(), testgui.getRtf2().getText(), testgui.getRtf3().getText(), testgui.getRtf4().getText(), testgui.getRtf5().getText());
			if(eingabenPr�fenRechnung(r)){
				try{
					RechnungsListe.getRechnungsListe().f�geRechnungEin(testgui.getVb(),  r);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getrL�sche()){
			Rechnung r=new Rechnung(testgui.getRtf1().getText(), testgui.getRtf2().getText(), testgui.getRtf3().getText(), testgui.getRtf4().getText(), testgui.getRtf5().getText());
			if(true){
				try{
					RechnungsListe.getRechnungsListe().l�scheRechnung(testgui.getVb(), r);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getGkSende()){
			Gesch�ftskunde gk=new Gesch�ftskunde(testgui.getGktf1().getText(), testgui.getGktf2().getText(), testgui.getGktf3().getText());
			if(true){
				try{
					testgui.getVb().f�geGesch�ftskundeEin(gk);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getGkL�sche()){
			Gesch�ftskunde gk=new Gesch�ftskunde(testgui.getGktf1().getText(), testgui.getGktf2().getText(), testgui.getGktf3().getText());
			if(true){
				try{
					testgui.getVb().l�scheGesch�ftskunde(gk);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaSende()){
			Anschrift a=new Anschrift(null, testgui.getAtf1().getText(), testgui.getAtf2().getText(), testgui.getAtf3().getText(), testgui.getAtf4().getText(), testgui.getAtf5().getText());
			if(true){
				try{
					testgui.getVb().f�geAnschriftEin(a);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaL�sche()){
			Anschrift a=new Anschrift(null, testgui.getAtf1().getText(), testgui.getAtf2().getText(), testgui.getAtf3().getText(), testgui.getAtf4().getText(), testgui.getAtf5().getText());
			if(true){
				try{
					testgui.getVb().l�scheAnschrift(a);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getRpSende()){
			Rechnung r=new Rechnung(testgui.getRptf1().getText(), null, null, null ,null, null);
			Rechnung.Rechnungsposition rp= r.new Rechnungsposition(testgui.getRptf2().getText(), testgui.getRptf3().getText(), testgui.getRptf4().getText());
			if(true){
				try{
					testgui.getVb().f�geRechnungspositionEin(rp);
				}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getRpL�sche()){
			Rechnung r=new Rechnung(testgui.getRptf1().getText(), null, null, null ,null, null);
			Rechnung.Rechnungsposition rp= r.new Rechnungsposition(testgui.getRptf2().getText(), testgui.getRptf3().getText(), testgui.getRptf4().getText());
			if(true){
				try{
					testgui.getVb().l�scheRechnungsposition(rp);
					}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getLaSende()){
			Land la=new Land(testgui.getLatf1().getText(), testgui.getLatf2().getText());
			if(true){
				try{
					testgui.getVb().f�geLandEin(la);
				}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getLaL�sche()){
			Land la=new Land(testgui.getLatf1().getText(), testgui.getLatf2().getText());
			if(true){
				try{
					testgui.getVb().l�scheLand(la);
				}catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
				
		
	}
	public boolean eingabenPr�fenKunde(Kunde k){
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
	public boolean eingabenPr�fenRechnung(Rechnung r){
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
