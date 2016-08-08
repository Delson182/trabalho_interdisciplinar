package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class RequerimentoDAO {
	
	public boolean salva(Requerimento requerimento) {
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
	public List<Requerimento> recuperaTodos() {
		List<Requerimento> requerimento = new ArrayList<Requerimento>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerimento");
			requerimento = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerimento;
	}
	
	
	public Requerimento recuperaPorId(Integer id) {
		Requerimento requerimento = new Requerimento();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerimento  where requerimento_id=:id");
			query.setParameter("id", id);
			requerimento = (Requerimento) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerimento;
	}
	
	@SuppressWarnings("unchecked")
	public List<Requerimento> buscaRequerimentoPorCpf(String cpf) {
		List<Requerimento> requerimentos = new ArrayList<Requerimento>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerimento WHERE matricula.estudante.cpf=:cpf");
			query.setParameter("cpf", cpf);
			requerimentos = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerimentos;
	}

}
