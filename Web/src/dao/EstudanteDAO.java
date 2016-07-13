package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Estudante;
import util.JPAUtil;

public class EstudanteDAO {
	
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
