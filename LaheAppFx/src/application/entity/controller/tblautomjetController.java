package application.entity.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.entity.tblautomjet;
import application.entity.tblklient;
import javafx.util.Callback;

public class tblautomjetController {
	
	private tblklient klient;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public tblautomjetController() {
		emf = Persistence.createEntityManagerFactory("LaheAppFx");
		em = emf.createEntityManager();
	}
	
	public List<tblklient> kerkoKlient(String kerkim) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblklient> criteria = builder.createQuery(tblklient.class);
		Root<tblklient> root = criteria.from(tblklient.class);
		criteria.where(
				builder.or(
						builder.like(root.get("emri"),"%"+ kerkim +"%"),
						builder.like(root.get("mbiemri"),"%"+ kerkim +"%"),
						builder.like(root.get("kompania"),"%"+ kerkim +"%"),
						builder.like(root.get("nrcelulari"),"%"+ kerkim +"%")
				  )
				);
		List<tblklient> klient = em.createQuery(criteria).getResultList();
		return klient;
	}
	
	public List<tblautomjet> kerkoAutomjet(String targa){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblautomjet> criteria = builder.createQuery(tblautomjet.class);
		Root<tblautomjet> root = criteria.from(tblautomjet.class);
		criteria.where(builder.like(root.get("targa"),"%"+ targa +"%"));
		List<tblautomjet> auto = em.createQuery(criteria).getResultList();
		return auto;
	}
	
	public List<tblautomjet> kerkoAutomjetId(long id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblautomjet> criteria = builder.createQuery(tblautomjet.class);
		Root<tblautomjet> root = criteria.from(tblautomjet.class);
		criteria.where(builder.equal(root.get("id"),id));
		List<tblautomjet> auto = em.createQuery(criteria).getResultList();
		return auto;
	}
	
	public List<tblautomjet> getAutomjete() {
		TypedQuery<tblautomjet> query = em.createQuery("select k  from tblautomjet k", tblautomjet.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	public List<tblklient> getKlient(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(tblklient.class);
        Root root = query.from(tblklient.class);
        query.select(root);
        return em.createQuery(query).getResultList();
	}
	
	public boolean addAutomjet(tblautomjet auto) {
		try {
			em.getTransaction().begin();
			em.merge(auto);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean updateAutomjet(tblautomjet auto,long id) {
		try {
			em.getTransaction().begin();
			tblautomjet automjet = em.find(tblautomjet.class, id);	    	
			automjet.setKlient(auto.getKlient());
			automjet.setNrshasi(auto.getNrshasi());
			automjet.setMarka(auto.getMarka());
			automjet.setModel(auto.getModel());
			automjet.setKarburant(auto.getKarburant());
			automjet.setKambio(auto.getKambio());
			automjet.setCilindrata(auto.getCilindrata());
			automjet.setFuqia(auto.getFuqia());
			automjet.setViti(auto.getViti());
			em.merge(auto);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deleteAutomjet(long id) {
		try {
			em.getTransaction().begin();
			tblautomjet automjet = em.find(tblautomjet.class, id);
			em.remove(automjet);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
