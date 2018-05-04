package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
		else if(e.getSource()==gui.getGkAktualisiere()){
			try{
				GeschaeftskundenListe.getGeschaeftskundenListe().geschaeftskundenListeAktualisieren(gui.getVb());
				gui.getGkDatensatz().setText(GeschaeftskundenListe.getGeschaeftskundenListe().toString());
				gui.getGkCb().setModel(new JComboBox(GeschaeftskundenListe.getGeschaeftskundenListe().getGkListe().toArray()).getModel());
			}catch(Exception ex){};
		}
		else if(e.getSource()==gui.getaAktualisiere()){
			try{
				AnschriftenListe.getAnschriftenListe().anschriftenListeAktualisieren(gui.getVb());
				gui.getaDatensatz().setText(AnschriftenListe.getAnschriftenListe().toString());
				gui.getaCb().setModel(new JComboBox(AnschriftenListe.getAnschriftenListe().getaListe().toArray()).getModel());
			}catch(Exception ex){};
		}
	}
	
	

}
