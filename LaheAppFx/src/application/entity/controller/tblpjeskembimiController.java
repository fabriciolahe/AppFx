package application.entity.controller;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.entity.tblpjeskembimi;

public class tblpjeskembimiController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public tblpjeskembimiController() {
		emf = Persistence.createEntityManagerFactory("LaheAppFx");
		em = emf.createEntityManager();
	}
	
	public List<tblpjeskembimi> getPjesetKembimi(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(tblpjeskembimi.class);
        Root root = query.from(tblpjeskembimi.class);
        query.select(root);
        query.orderBy(criteriaBuilder.desc(root.get("dataKrjimit")));
        return em.createQuery(query).getResultList();
	}
	
	public List<tblpjeskembimi> getListPjeseByDate(Date data) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tblpjeskembimi> criteria = builder.createQuery(tblpjeskembimi.class);
		Root<tblpjeskembimi> root = criteria.from(tblpjeskembimi.class);
		criteria.where(builder.equal(root.get("dataKrjimit"),data));
		List<tblpjeskembimi> pjese = em.createQuery(criteria).getResultList();
		return pjese;
	}
	
	public boolean addPjeseKembimi(tblpjeskembimi pjeset) {
		try {
			em.getTransaction().begin();
			em.merge(pjeset);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deletePjeseKembimi(long id) {
		try {
			em.getTransaction().begin();
			tblpjeskembimi pjeseKembimi = em.find(tblpjeskembimi.class, id);
			em.remove(pjeseKembimi);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePjeseKembimi(tblpjeskembimi pjese,long id) {
		try {
			em.getTransaction().begin();
			tblpjeskembimi pjeseKembimi = em.find(tblpjeskembimi.class, id);
			pjeseKembimi.setKodPjese(pjese.getKodPjese());
			pjeseKembimi.setEmerPjese(pjese.getEmerPjese());
			em.merge(pjese);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
