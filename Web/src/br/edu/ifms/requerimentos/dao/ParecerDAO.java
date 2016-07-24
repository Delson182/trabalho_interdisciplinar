package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class ParecerDAO {
	
	public boolean salva(Parecer parecer) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(parecer);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parecer> recuperaTodos() {
		List<Parecer> parecer = new ArrayList<Parecer>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Parecer");
			parecer = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parecer;
	}

}
