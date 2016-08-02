package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Curso;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class CursoDAO {
	
	public boolean salva(Curso curso) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(curso);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> recuperaTodos() {
		List<Curso> curso = new ArrayList<Curso>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Curso");
			curso = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}
	
	
	public Curso recuperaPorId(Integer id) {
		Curso curso = new Curso();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("from Curso where curso_id=:id");
			query.setParameter("id", id);
			curso = (Curso) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}
	
	

}
