package test_Datenbank;

import java.util.ArrayList;

public class ArtikelListe {
	private ArrayList<Artikel> artikelListe;
	
	public ArtikelListe(){
		artikelListe=new ArrayList<>();
	}
	
	public void f�geArtikelEin(Artikel a){
		artikelListe.add(a);
	}
	
	public void entferneArtikel(Artikel a){
		artikelListe.add(a);
	}
	
	public boolean enth�ltArtikel(Artikel a){
		return artikelListe.contains(a);
	}
	
	public ArrayList<Artikel> getArtikelListe(){
		return artikelListe;
	}

}
