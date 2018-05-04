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
		else if(e.getSource()==testgui.getGkCb()){
			Geschäftskunde gk=(Geschäftskunde)testgui.getGkCb().getSelectedItem();
			testgui.getGktf4().setText(gk.getKDNr());
			testgui.getGktf5().setText(gk.getFirmenname());
			testgui.getGktf6().setText(gk.getRechtsformID());
		}
		else if(e.getSource()==testgui.getaCb()){
			Anschrift a=(Anschrift)testgui.getaCb().getSelectedItem();
			testgui.getAtf6().setText(a.getStrasse());
			testgui.getAtf7().setText(a.getHausNr());
			testgui.getAtf8().setText(a.getPlZ());
			testgui.getAtf9().setText(a.getOrt());
			testgui.getAtf10().setText(a.getLaID());
			
		}
	}
	
	
	

}
