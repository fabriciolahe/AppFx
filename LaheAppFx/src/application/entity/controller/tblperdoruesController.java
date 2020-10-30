package application.entity.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.entity.tblperdorues;

public class tblperdoruesController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public tblperdoruesController() {
		emf = Persistence.createEntityManagerFactory("LaheAppFx");
		em = emf.createEntityManager();
	}
	
	public List<tblperdorues> getListPerdorues(){
		
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(tblperdorues.class);
        Root root = query.from(tblperdorues.class);
        query.select(root);
        return em.createQuery(query).getResultList();
        
	}
	
	//Kerko sipas perdoruesit
	public List<tblperdorues> kerkoPerdorues(String perdoruesi){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblperdorues> criteria = builder.createQuery(tblperdorues.class);
		Root<tblperdorues> root = criteria.from(tblperdorues.class);
		criteria.where(builder.like(root.get("perdoruesi"),"%"+ perdoruesi +"%"));
		List<tblperdorues> perdorues = em.createQuery(criteria).getResultList();
		return perdorues;
	}
	
	//Kerko sipas fjalekalimit
	public List<tblperdorues> kerkoFjalekalime(String fjalekalim){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblperdorues> criteria = builder.createQuery(tblperdorues.class);
		Root<tblperdorues> root = criteria.from(tblperdorues.class);
		criteria.where(builder.like(root.get("fjalekalimi"),"%"+ fjalekalim +"%"));
		List<tblperdorues> perdorues = em.createQuery(criteria).getResultList();
		return perdorues;
	}
	
	//Logohu ne sistem
	public List<tblperdorues> gjejPerdorues(String perdoruesi, String fjalekalimi){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblperdorues> criteria = builder.createQuery(tblperdorues.class);
		Root<tblperdorues> root = criteria.from(tblperdorues.class);
		criteria.where(
				builder.like(root.get("perdoruesi"),"%"+ perdoruesi +"%"),
				builder.like(root.get("fjalekalimi"),"%"+ fjalekalimi +"%")
				);
		List<tblperdorues> perdorues = em.createQuery(criteria).getResultList();
		return perdorues;
	}
	
	public boolean addPerdorues(tblperdorues perdorues) {
		try {
			em.getTransaction().begin();
			em.merge(perdorues);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean updatePerdorues(tblperdorues perdorues ,long id) {
		try {
			em.getTransaction().begin();
			tblperdorues username = em.find(tblperdorues.class, id);
			username.setEmri(perdorues.getEmri());
			username.setMbiemri(perdorues.getMbiemri());
			username.setEmail(perdorues.getEmail());
			username.setTelefon(perdorues.getTelefon());
			username.setAdresa(perdorues.getAdresa());
			username.setPerdoruesi(perdorues.getPerdoruesi());
			username.setFjalekalimi(perdorues.getFjalekalimi());
			username.setAdmin(perdorues.isAdmin());
			em.merge(perdorues);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deletePerdorues(long id) {
		try {
			em.getTransaction().begin();
			tblperdorues username = em.find(tblperdorues.class, id);
			em.remove(username);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
