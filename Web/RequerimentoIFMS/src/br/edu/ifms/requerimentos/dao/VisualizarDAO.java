package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifms.requerimento.bean.model.Visualizar;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class VisualizarDAO {
	@SuppressWarnings("unchecked")
	public List<Visualizar> recuperaTodos(String filtro) {
		List<Visualizar> visualizar = new ArrayList<Visualizar>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			//Select r.protocolo, r.data_criacao, e.nome, s.sigla FROM Requerimento r LEFT JOIN Estudante e ON r.estudante_fk = e.estudante_id LEFT JOIN Setor s ON r.setor_destino_fk = s.setor_id
			Query query = em.createQuery("FROM Visualizar WHERE lower(nome) like :nome");
			query.setParameter("nome", "%" + filtro + "%");
			visualizar = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visualizar;
	}
}
