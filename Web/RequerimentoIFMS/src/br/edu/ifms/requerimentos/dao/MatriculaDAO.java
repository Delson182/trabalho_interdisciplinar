package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class MatriculaDAO {
	
	public boolean salva(Matricula matricula) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(matricula);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Matricula> recuperaTodos() {
		List<Matricula> matricula = new ArrayList<Matricula>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Matricula");
			matricula = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matricula;
	}
	@SuppressWarnings("unchecked")
	public List<Matricula> recuperaPorNome(String nome) {
		List<Matricula> matricula = new ArrayList<Matricula>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("from Matricula WHERE matricula.estudante.nome=:nome");
			query.setParameter("nome", nome);
			matricula = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matricula;
	}
	
	public Matricula recuperaPorMatricula(String numeroMatricula) {
		Matricula matricula = new Matricula();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("from Matricula where matricula=:numeroMatricula");
			query.setParameter("numeroMatricula", numeroMatricula);
			matricula = (Matricula) query.getSingleResult();;
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matricula;
	}

}
