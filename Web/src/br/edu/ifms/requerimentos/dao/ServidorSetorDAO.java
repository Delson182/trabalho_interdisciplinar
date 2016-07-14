package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.ServidorSetor;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class ServidorSetorDAO {
	
	public boolean salva(ServidorSetor requerimento) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(requerimento);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<ServidorSetor> recuperaTodos() {
		List<ServidorSetor> requerimento = new ArrayList<ServidorSetor>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM servidor_setor");
			requerimento = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerimento;
	}

}
