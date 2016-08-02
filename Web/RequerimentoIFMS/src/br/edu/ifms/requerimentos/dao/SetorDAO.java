package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Setor;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class SetorDAO {
	
	public boolean salva(Setor setor) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(setor);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Setor> recuperaTodos() {
		List<Setor> setor = new ArrayList<Setor>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Setor");
			setor = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setor;
	}
	
	
	@SuppressWarnings("unchecked")
	public Setor recuperaPorId(Integer id) {
		Setor setor = new Setor();
		List<Setor> setores = new ArrayList<Setor>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("from Setor where setor_id=:id");
			query.setParameter("id", id);
			setores = query.getResultList();
			if(setores != null){
				setor = setores.get(0);
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setor;
	}
	
	

}
