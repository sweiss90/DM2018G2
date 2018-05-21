package test_Datenbank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test_JPA_schreiben {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager db=null;
		try{
			
			Land la=new Land("GER", "Deutschland");
			Anschrift a=new Anschrift(1, "Huberweg",
				27, "0179", "München", la);
			Kunde k1=new Kunde(1, "Thomas", "Müller", "thomas.müller@web.de", "017663273672", a);
			factory=Persistence.createEntityManagerFactory("rechnungsverwaltung2");
			db=factory.createEntityManager();
			db.getTransaction().begin();
			db.persist(la);
			db.persist(a);
			db.persist(k1);
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
