package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Servidor;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class ServidorDAO {
	
	public boolean salva(Servidor servidor) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(servidor);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Servidor> recuperaTodos() {
		List<Servidor> servidor = new ArrayList<Servidor>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Servidor");
			servidor = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servidor;
	}
	
	
	public Servidor recuperaPorId(Integer id) {
		Servidor servidor = new Servidor();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("from Servidor where servidor_id=:id");
			query.setParameter("id", id);
			servidor = (Servidor) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servidor;
	}
	
	

}
