package br.edu.ifms.requerimentos.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class EstudanteDAO {

	// Android
	public String consultaDispositivo(String cpf) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Estudante e = null;
			Query query = em.createQuery("FROM Estudante where cpf = :cpf");
			query.setParameter("cpf", cpf);
			e = (Estudante) query.getSingleResult();
			em.close();
			return e.getDispositivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Android
	@SuppressWarnings("unchecked")
	public boolean consultaPorCpf(String cpf) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			List<Estudante> e = null;
			Query query = em.createQuery("FROM Estudante where cpf = :cpf");
			query.setParameter("cpf", cpf);
			e = query.getResultList();
			em.close();
			if (e.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//Android
	public boolean insereDispositivo(String cpf, String dispositivo) {
		String sql = "update Estudante set dispositivo = :dispositivo where cpf = :cpf";
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			Query query = em.createQuery(sql);
			query.setParameter("dispositivo", dispositivo);
			query.setParameter("cpf", cpf);
			query.executeUpdate();
			transacao.commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
