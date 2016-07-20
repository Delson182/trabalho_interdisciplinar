package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class EstudanteDAO {
	
	public boolean salva(Estudante estudante) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(estudante);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estudante> recuperaTodos() {
		List<Estudante> estudante = new ArrayList<Estudante>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Estudante");
			estudante = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estudante;
	}

}
