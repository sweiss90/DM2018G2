package test_Datenbank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test_JPA_schreiben {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager db=null;
		DB dbank=new DB();
		try{
			
			/*Land la=new Land("CHE", "Schweiz");
			Anschrift a=new Anschrift("Huberweg",
				27, "0179", "München", la);
			Kunde k1=new Kunde("Thomas", "Müller", "thomas.müller@web.de", "017663273672", a);*/
			factory=Persistence.createEntityManagerFactory("rechnungsverwaltung2");
			db=factory.createEntityManager();
			db.getTransaction().begin();
			/*db.persist(la);
			db.persist(a);
			db.persist(k1);
			*/
			
			RechtsformListe.getRechtsformListe().rechtsformListeAktualisieren(dbank);
			for(Rechtsform rf:RechtsformListe.getRechtsformListe().getRfListe()){
				db.persist(rf);
			}
			ArtikelListe.getArtikelListe().artikelListeAktualisieren(dbank);
			for(Artikel a:ArtikelListe.getArtikelListe().getaListe()){
				db.persist(a);
			}
			LaenderListe.getLaenderListe().laenderListeAktualisieren(dbank);
			for(Land la: LaenderListe.getLaenderListe().getLaListe()){
				db.persist(la);
			}
			AnschriftenListe.getAnschriftenListe().anschriftenListeAktualisieren(dbank);
			for(Anschrift a:AnschriftenListe.getAnschriftenListe().getaListe()){
				db.persist(a);
			}
			KundenListe.getkundenListe().kundenListeAktualisieren(dbank);
			for(Kunde k:KundenListe.getkundenListe().getkListe()){
				System.out.println("Kunde: "+k);
				db.persist(k);
			}
			db.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				db.close();
				
			}catch(Exception ex){}
		}
		

	}

}
