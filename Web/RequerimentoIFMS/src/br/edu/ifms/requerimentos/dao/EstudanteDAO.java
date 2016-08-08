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
	@SuppressWarnings("unchecked")
	public Estudante recuperaPorCpf(String cpf) {
		List<Estudante> estudantes = new ArrayList<Estudante>();
		Estudante estudante = new Estudante();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Estudante where cpf=:cpf");
			query.setParameter("cpf", cpf);
			estudantes = query.getResultList();
			if(!estudantes.isEmpty()){
				estudante = estudantes.get(0);
			}else{
				estudante = null;
			}
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estudante;
	}

}
