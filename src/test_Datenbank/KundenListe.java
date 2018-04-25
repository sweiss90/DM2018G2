package test_Datenbank;

import java.util.ArrayList.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;

public class KundenListe {
	private ArrayList<Kunde> kundenListe;
	
	public KundenListe(){
		kundenListe=new ArrayList<>();
	}
	
	public void fügeKundeHinzu(Kunde k){
		kundenListe.add(k);
	}
	
	public boolean enthältKunde(Kunde k){
		Iterator<Kunde> it= kundenListe.iterator();
		while(it.hasNext()){
			if(it.next().equals(k))
				return true;
			}
		return false;
		//alternativ:
		// return kundenListe.contains(k);
	}
	public boolean entferneKunde(Kunde k){
		Iterator<Kunde> it= kundenListe.iterator();
		while(it.hasNext()){
			if(it.next().equals(k)){
				kundenListe.remove(it.next());
				return true;
			}
		}
		return false;
	}

	public ArrayList<Kunde> getKundenListe() {
		return kundenListe;
	}

	
	

}
