package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EventHandlerJComboBoxes implements ActionListener {
	private testGUI testgui=null;
	
	public EventHandlerJComboBoxes(testGUI gui){
		this.testgui=Objects.requireNonNull(gui);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==testgui.getKCb()){
			Kunde k=(Kunde)testgui.getKCb().getSelectedItem();
			testgui.getKtf6().setText(k.getVorname());
			testgui.getKtf7().setText(k.getNachname());
			testgui.getKtf8().setText(k.getEmail());
			testgui.getKtf9().setText(k.getTelefonNr());
			testgui.getKtf10().setText(k.getAnID());
		}
		else if(e.getSource()==testgui.getrCb()){
			Rechnung r=(Rechnung)testgui.getrCb().getSelectedItem();
			testgui.getRtf6().setText(r.getDatum());
			testgui.getRtf7().setText(r.getBezahlt());
			testgui.getRtf8().setText(r.getZahlungsziel());
			testgui.getRtf9().setText(r.getKdNr());
			testgui.getRtf10().setText(r.getTransNr());
		}
	}
	
	
	

}
