package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;

import javax.swing.JComboBox;

public class EventHandlerAktualisieren implements ActionListener {
	private testGUI gui=null;
	
	public EventHandlerAktualisieren(testGUI gui){
		this.gui=gui;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==gui.getkAktualisiere()){
			try{
				KundenListe.getkundenListe().kundenListeAktualisieren(gui.getVb());
				gui.getkDatensatz().setText(KundenListe.getkundenListe().toString());
				gui.getKCb().setModel(new JComboBox(KundenListe.getkundenListe().getkListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getrAktualisiere()){
			try{
				RechnungsListe.getRechnungsListe().rechnungsListeAktualisieren(gui.getVb());
				gui.getrDatensatz().setText(RechnungsListe.getRechnungsListe().toString());
				gui.getrCb().setModel(new JComboBox(RechnungsListe.getRechnungsListe().getRListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getaAktualisiere()){
			try{
				AnschriftenListe.getAnschriftenListe().anschriftenListeAktualisieren(gui.getVb());
				gui.getaDatensatz().setText(AnschriftenListe.getAnschriftenListe().toString());
				gui.getAnCb().setModel(new JComboBox(AnschriftenListe.getAnschriftenListe().getaListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getArAktualisiere()){
			try{
				ArtikelListe.getArtikelListe().artikelListeAktualisieren(gui.getVb());
				gui.getArDatensatz().setText(ArtikelListe.getArtikelListe().toString());
				gui.getArCb().setModel(new JComboBox(ArtikelListe.getArtikelListe().getaListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getZaAktualisiere()){
			try{
				ZahlungsartListe.getZahlungsartListe().zahlungsartListeAktualisieren(gui.getVb());
				gui.getZaDatensatz().setText(ZahlungsartListe.getZahlungsartListe().toString());
				gui.getZaCb().setModel(new JComboBox(ZahlungsartListe.getZahlungsartListe().getZaListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getBeAktualisiere()){
			try{
				BankeinzugListe.getBankeinzugListe().bankeinzugListeAktualisieren(gui.getVb());
				gui.getBeDatensatz().setText(BankeinzugListe.getBankeinzugListe().toString());
				gui.getBeCb().setModel(new JComboBox(BankeinzugListe.getBankeinzugListe().getbeListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getLaAktualisiere()){
			try{
				LaenderListe.getLaenderListe().laenderListeAktualisieren(gui.getVb());
				gui.getLaDatensatz().setText(LaenderListe.getLaenderListe().toString());
				gui.getLaCb().setModel(new JComboBox(LaenderListe.getLaenderListe().getLaListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getUfAktualisiere()){
			try{
				RechtsformListe.getRechtsformListe().rechtsformListeAktualisieren(gui.getVb());
				gui.getUfDatensatz().setText(RechtsformListe.getRechtsformListe().toString());
				gui.getUfCb().setModel(new JComboBox(RechtsformListe.getRechtsformListe().getRfListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getGkAktualisiere()){
			try{
				GeschaeftskundenListe.getGeschaeftskundenListe().geschaeftskundenListeAktualisieren(gui.getVb());
				gui.getGkDatensatz().setText(GeschaeftskundenListe.getGeschaeftskundenListe().toString());
				gui.getGkCb().setModel(new JComboBox(GeschaeftskundenListe.getGeschaeftskundenListe().getGkListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getKkAktualisiere()){
			try{
				KreditkarteListe.getKreditkarteListe().kreditkarteListeAktualisieren(gui.getVb());
				gui.getKkDatensatz().setText(KreditkarteListe.getKreditkarteListe().toString());
				gui.getKkCb().setModel(new JComboBox(KreditkarteListe.getKreditkarteListe().getkkListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getRpAktualisiere()){
			try{
				RechnungspositionsListe.getRechnungspositionsListe().rechnungsPositionsListeAktualisieren(gui.getVb());
				gui.getRpDatensatz().setText(RechnungspositionsListe.getRechnungspositionsListe().toString());
				gui.getKkCb().setModel(new JComboBox(RechnungspositionsListe.getRechnungspositionsListe().getRpListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		
	}
	
	

}
