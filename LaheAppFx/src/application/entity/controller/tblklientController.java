package application.entity.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import application.entity.tblklient;

public class tblklientController {

	private EntityManagerFactory emf;
	private EntityManager em;

	public tblklientController() {
		emf = Persistence.createEntityManagerFactory("LaheAppFx");
		em = emf.createEntityManager();
	}

	public List<tblklient> getKlients() {
		TypedQuery<tblklient> query = em.createQuery("select k from tblklient k", tblklient.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return query.getResultList();
	}
	
	public boolean addKlient(tblklient klient) {
		try {
			em.getTransaction().begin();
			em.persist(klient);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean updateKlient(tblklient klient, long id) {
		try {
			em.getTransaction().begin();
			tblklient kli = em.find(tblklient.class, id);
			kli.setEmri(klient.getEmri());
			kli.setMbiemri(klient.getMbiemri());
			kli.setKompania(klient.getKompania());
			kli.setNrcelulari(klient.getNrcelulari());
			em.merge(klient);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean deleteKlient(long id) {
		try {
			em.getTransaction().begin();
			tblklient kli = em.find(tblklient.class, id);
			em.remove(kli);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
