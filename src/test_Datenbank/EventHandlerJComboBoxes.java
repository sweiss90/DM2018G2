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
			testgui.getKtf10().setText(k.getAnID().toString());
		}
		else if(e.getSource()==testgui.getrCb()){
			Rechnung r=(Rechnung)testgui.getrCb().getSelectedItem();
			testgui.getRtf6().setText(r.getDatum());
			testgui.getRtf7().setText(r.getBezahlt());
			testgui.getRtf8().setText(r.getZahlungsziel());
			testgui.getRtf9().setText(r.getKdNr().toString());
			//testgui.getRtf10().setText(r.getTransNr());
		}
		else if(e.getSource()==testgui.getGkCb()){
			Geschäftskunde gk=(Geschäftskunde)testgui.getGkCb().getSelectedItem();
			//testgui.getGktf4().setText(gk.getKDNr());
			testgui.getGktf5().setText(gk.getFirmenname());
			//testgui.getGktf6().setText(gk.getRechtsformID());
		}
		else if(e.getSource()==testgui.getAnCb()){
			Anschrift a=(Anschrift)testgui.getAnCb().getSelectedItem();
			testgui.getAtf6().setText(a.getStrasse());
			testgui.getAtf7().setText(a.getHausNr().toString());
			testgui.getAtf8().setText(a.getPlZ());
			testgui.getAtf9().setText(a.getOrt());
			//testgui.getAtf10().setText(a.getLaID());
		}
		else if(e.getSource()==testgui.getArCb()){
			Artikel a=(Artikel)testgui.getArCb().getSelectedItem();
			testgui.getArtf3().setText(a.getBezeichnung());
			//testgui.getArtf4().setText(a.getPreis());
		}
		else if(e.getSource()==testgui.getLaCb()){
			Land la=(Land)testgui.getLaCb().getSelectedItem();
			testgui.getLatf3().setText(la.getId());
			testgui.getLatf4().setText(la.getLand());
		}
		else if(e.getSource()==testgui.getUfCb()){
			Rechtsform rf=(Rechtsform)testgui.getUfCb().getSelectedItem();
		//	testgui.getUftf2().setText(rf.getId());
		}
		else if(e.getSource()==testgui.getZaCb()){
			Zahlungsart za=(Zahlungsart)testgui.getZaCb().getSelectedItem();
		//	testgui.getZatf3().setText(za.getZahlungsartNummer());
		//	testgui.getZatf4().setText(za.getKundennummer());
		}
		else if(e.getSource()==testgui.getRpCb()){
		//	Rechnung.Rechnungsposition rp=(Rechnung.Rechnungsposition)testgui.getRpCb().getSelectedItem();
			//testgui.getRptf5().setText(rp.getNr());
			//testgui.getRptf6().setText(rp.getPositionsNr());
			//testgui.getRptf7().setText(rp.getArtikelID());
			//testgui.getRptf8().setText(rp.getMenge());
		}
		else if(e.getSource()==testgui.getBeCb()){
			Bankeinzug be=(Bankeinzug)testgui.getBeCb().getSelectedItem();
			testgui.getBetf3().setText(be.getIban());
			testgui.getBetf4().setText(be.getBic());
		}
		else if(e.getSource()==testgui.getKkCb()){
			Kreditkarte k=(Kreditkarte)testgui.getKkCb().getSelectedItem();
			testgui.getKktf3().setText(k.getKaNr());
			testgui.getKktf4().setText(k.getAblaufdatum());
		}
		
			
	}
	
	
	
	

}
