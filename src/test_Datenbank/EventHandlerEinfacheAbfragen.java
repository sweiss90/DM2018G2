package test_Datenbank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventHandlerEinfacheAbfragen implements ActionListener {
	
	private testGUI tG=null; 
	
	public EventHandlerEinfacheAbfragen(testGUI tg) {
		this.tG=tg;
	}
	
	public void actionPerformed(ActionEvent e) {
		tG.geteA().getSelectedItem();
		if(e.getSource()==tG.get()) {
			
		}
	}
	

}
