package application.entity.controller;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.entity.tbllengje;
import application.entity.tblpjeskembimi;

public class tbllengjeController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public tbllengjeController() {
		emf = Persistence.createEntityManagerFactory("LaheAppFx");
		em = emf.createEntityManager();
	}
	
	public List<tbllengje> getlengje(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(tbllengje.class);
        Root root = query.from(tbllengje.class);
        query.select(root);
        query.orderBy(criteriaBuilder.desc(root.get("dataKrijimit")));
        return em.createQuery(query).getResultList();
	}
	
	public List<tbllengje> getListPjeseByDate(Date data) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<tbllengje> criteria = builder.createQuery(tbllengje.class);
		Root<tbllengje> root = criteria.from(tbllengje.class);
		criteria.where(builder.equal(root.get("dataKrijimit"),data));
		List<tbllengje> pjese = em.createQuery(criteria).getResultList();
		return pjese;
	}
	
	public boolean addLengje(tbllengje lengje) {
		try {
			em.getTransaction().begin();
			em.merge(lengje);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deleteLengje(long id) {
		try {
			em.getTransaction().begin();
			tbllengje lengje = em.find(tbllengje.class, id);
			em.remove(lengje);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateLengje(tbllengje lengje,long id) {
		try {
			em.getTransaction().begin();
			tbllengje leng = em.find(tbllengje.class, id);
			leng.setKodi(lengje.getKodi());
			leng.setTipi(lengje.getTipi());
			leng.setSasia(lengje.getSasia());
			em.merge(lengje);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
