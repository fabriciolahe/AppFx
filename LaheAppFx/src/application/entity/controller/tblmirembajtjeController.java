package application.entity.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import application.entity.tblmirembajtje;

public class tblmirembajtjeController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public tblmirembajtjeController() {
		emf = Persistence.createEntityManagerFactory("LaheAppFx");
		em = emf.createEntityManager();
	}
	
	public List<tblmirembajtje> getmirembajtje(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(tblmirembajtje.class);
        Root root = query.from(tblmirembajtje.class);
        query.select(root);
        query.orderBy(criteriaBuilder.desc(root.get("dataKrijimit")));
        return em.createQuery(query).getResultList();
	}
	
	public boolean addMirembajtje(tblmirembajtje mirembajtje) {
		try {
			em.getTransaction().begin();
			em.merge(mirembajtje);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean updateMirembajtje(tblmirembajtje mirembajtje ,long id) {
		try {
			em.getTransaction().begin();
			tblmirembajtje maintenance = em.find(tblmirembajtje.class, id);
			maintenance.setKilomatrat(mirembajtje.getKilomatrat());
			maintenance.setSaeVaji(mirembajtje.getSaeVaji());
			maintenance.setFilterAjri(mirembajtje.isFilterAjri());
			maintenance.setFilterGabine(mirembajtje.isFilterGabine());
			maintenance.setFilterKarburanti(mirembajtje.isFilterKarburanti());
			maintenance.setFilterVaji(mirembajtje.isFilterVaji());
			em.merge(mirembajtje);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deleteMirembajtje(long id) {
		try {
			em.getTransaction().begin();
			tblmirembajtje manutazione = em.find(tblmirembajtje.class, id);
			em.remove(manutazione);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
