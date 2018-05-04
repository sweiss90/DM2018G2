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
				 KundenListe.getkundenListe().fügeKundeEin(testgui.getVb(), k);
				 }
				 catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getkLösche()){
			Kunde k=new Kunde(null, testgui.getKtf1().getText(), testgui.getKtf2().getText(), testgui.getKtf3().getText(),testgui.getKtf4().getText(), testgui.getKtf5().getText());
			if(true){
			try{
				 KundenListe.getkundenListe().löscheKunde(testgui.getVb(), k);
				
				 }
				 catch(Exception ex){}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==testgui.getkÄndern()){
			Kunde kundAlt=(Kunde) testgui.getKCb().getSelectedItem();
 			Kunde kundNeu=new Kunde(kundAlt.getNr(), testgui.getKtf6().getText(), testgui.getKtf7().getText(), testgui.getKtf9().getText(),testgui.getKtf8().getText(), testgui.getKtf10().getText());
			if(true){
			try{
				KundenListe.getkundenListe().ändereKunde(testgui.getVb(), kundNeu, kundAlt);
				
				 }
				 catch(Exception ex){throw new RuntimeException("Ändern nicht möglich!");}
			}else{
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(e.getSource()==testgui.getrSende()){
			Rechnung r=new Rechnung(testgui.getRtf1().getText(), testgui.getRtf2().getText(), testgui.getRtf3().getText(), testgui.getRtf4().getText(), testgui.getRtf5().getText());
			if(eingabenPrüfenRechnung(r)){
				try{
					RechnungsListe.getRechnungsListe().fügeRechnungEin(testgui.getVb(),  r);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getrLösche()){
			Rechnung r=new Rechnung(testgui.getRtf1().getText(), testgui.getRtf2().getText(), testgui.getRtf3().getText(), testgui.getRtf4().getText(), testgui.getRtf5().getText());
			if(true){
				try{
					RechnungsListe.getRechnungsListe().löscheRechnung(testgui.getVb(), r);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getrÄndern()){
			Rechnung rechnungAlt=(Rechnung)testgui.getrCb().getSelectedItem();
			Rechnung rechnungNeu=new Rechnung(rechnungAlt.getNr(), testgui.getRtf6().getText(), testgui.getRtf7().getText(), testgui.getRtf8().getText(), testgui.getRtf9().getText(), testgui.getRtf10().getText());
			if(true){
				try{
					RechnungsListe.getRechnungsListe().ändereRechnung(testgui.getVb(), rechnungNeu, rechnungAlt);
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
		else if(e.getSource()==testgui.getGkÄndern()){
			Geschäftskunde gkAlt=(Geschäftskunde)testgui.getGkCb().getSelectedItem();
			Geschäftskunde gkNeu=new Geschäftskunde(testgui.getGktf4().getText(), testgui.getGktf5().getText(), testgui.getGktf6().getText());
			if(true){
				try{
					GeschaeftskundenListe.getGeschaeftskundenListe().ändereGeschäftskunde(testgui.getVb(), gkNeu, gkAlt);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaSende()){
			Anschrift a=new Anschrift(null, testgui.getAtf1().getText(), testgui.getAtf2().getText(), testgui.getAtf3().getText(), testgui.getAtf4().getText(), testgui.getAtf5().getText());
			if(true){
				try{
					testgui.getVb().fügeAnschriftEin(a);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaLösche()){
			Anschrift a=new Anschrift(null, testgui.getAtf1().getText(), testgui.getAtf2().getText(), testgui.getAtf3().getText(), testgui.getAtf4().getText(), testgui.getAtf5().getText());
			if(true){
				try{
					testgui.getVb().löscheAnschrift(a);
				}catch(Exception ex){}
			}else
				JOptionPane.showMessageDialog(null, "Datensatz fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource()==testgui.getaÄndern()){
			Anschrift aAlt=(Anschrift)testgui.getaCb().getSelectedItem();
			Anschrift aNeu=new Anschrift(aAlt.getId(),testgui.getAtf6().getText(), testgui.getAtf7().getText(), testgui.getAtf8().getText(), testgui.getAtf9().getText(), testgui.getAtf10().getText());
			if(true){
				try{
					AnschriftenListe.getAnschriftenListe().ändereAnschrift(testgui.getVb(), aNeu, aAlt);
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
		else if(e.getSource()==testgui.getRpÄndern()){
			Rechnung r=new Rechnung(testgui.getRptf5().getText(), null, null, null, null); //verbessern!!
			Rechnung.Rechnungsposition rpAlt=(Rechnung.Rechnungsposition) testgui.getRpCb().getSelectedItem();
			Rechnung.Rechnungsposition rpNeu=r.new Rechnungsposition(testgui.getRptf6().getText(), testgui.getRptf7().getText(), testgui.getRptf8().getText());
			try{
				RechnungspositionsListe.getRechnungspositionsListe().ändereRechnungsposition(testgui.getVb(), rpNeu, rpAlt);
			}catch(Exception ex){};
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
