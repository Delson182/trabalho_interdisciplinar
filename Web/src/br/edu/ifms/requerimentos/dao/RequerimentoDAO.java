package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Curso;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.Servidor;
import br.edu.ifms.requerimentos.model.Setor;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class RequerimentoDAO {
	
	public boolean salva(Requerimento requerimento) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			
			Requerente requerente = requerimento.getRequerente();
			Matricula matricula = requerimento.getMatricula();
			
			Servidor servidor = requerimento.getServidorResponsavel();
			servidor = em.merge(servidor);
			requerimento.setServidorResponsavel(servidor);
			
			Setor setor = requerimento.getSetorDestino();
			setor = em.merge(setor);
			requerimento.setSetorDestino(setor);
			
			Curso curso = matricula.getCurso();
			curso = em.merge(curso);
			matricula.setCurso(curso);
			matricula = em.merge(matricula);
			requerimento.setMatricula(matricula);
			
			Estudante estudante = requerente.getEstudante();
			estudante = em.merge(estudante);
			requerente.setEstudante(estudante);
			requerente = em.merge(requerente);
			requerimento.setRequerente(requerente);
			
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

}
