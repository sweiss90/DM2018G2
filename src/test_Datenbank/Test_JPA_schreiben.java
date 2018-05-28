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
			factory=Persistence.createEntityManagerFactory("rechnungsverwaltung2");
			db=factory.createEntityManager();
			db.getTransaction().begin();
			
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
				db.persist(k);
				}
			
			GeschaeftskundenListe.getGeschaeftskundenListe().geschaeftskundenListeAktualisieren(dbank);
			for(Geschäftskunde gk:GeschaeftskundenListe.getGeschaeftskundenListe().getGkListe()){
				db.persist(gk);
			}
			KundenListe.getkundenListe().kundenListeAktualisieren2(dbank);
			
			ZahlungsartListe.getZahlungsartListe().zahlungsartListeAktualisieren(dbank);
			db.getTransaction().commit();
			db.getTransaction().begin();
			
			BankeinzugListe.getBankeinzugListe().bankeinzugListeAktualisieren(dbank);
			for(Bankeinzug be:BankeinzugListe.getBankeinzugListe().getbeListe()){
				db.persist(be);
			}
			KreditkarteListe.getKreditkarteListe().kreditkarteListeAktualisieren(dbank);
			for(Kreditkarte kk:KreditkarteListe.getKreditkarteListe().getkkListe()){
				db.persist(kk);
			}
			ÜberweisungListe.getÜberweisungListe().überweisungListeAktualisieren(dbank);
			for(Überweisung ub:ÜberweisungListe.getÜberweisungListe().getuewListe()){
				db.persist(ub);
			}
			ZahlungsartListe.getZahlungsartListe().zahlungsartListeAktualisieren(dbank);
			
			RechnungsListe.getRechnungsListe().rechnungsListeAktualisieren(dbank);
			for(Rechnung r:RechnungsListe.getRechnungsListe().getRListe()){
				db.persist(r);
			}
			RechnungspositionsListe.getRechnungspositionsListe().rechnungsPositionsListeAktualisieren(dbank);
			for(Rechnungsposition rp:RechnungspositionsListe.getRechnungspositionsListe().getRpListe()){
				db.persist(rp);
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
