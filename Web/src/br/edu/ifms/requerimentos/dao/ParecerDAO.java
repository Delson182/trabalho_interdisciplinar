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

public class ParecerDAO {
	
	public boolean salvaComRequerimento(Parecer parecer) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			Requerimento requerimento = parecer.getRequerimento();
			
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
		
			requerimento.setRequerente(requerente);
			parecer.setRequerimento(requerimento);
			parecer.setServidor(servidor);
			parecer.setSetor(setor);
			em.persist(parecer);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parecer> recuperaTodos() {
		List<Parecer> parecer = new ArrayList<Parecer>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Parecer");
			parecer = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parecer;
	}

}
