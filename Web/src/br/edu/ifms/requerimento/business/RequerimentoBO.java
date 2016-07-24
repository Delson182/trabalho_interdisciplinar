package br.edu.ifms.requerimento.business;

import java.util.List;

import br.edu.ifms.requerimentos.dao.CursoDAO;
import br.edu.ifms.requerimentos.dao.MatriculaDAO;
import br.edu.ifms.requerimentos.dao.ParecerDAO;
import br.edu.ifms.requerimentos.dao.RequerenteDAO;
import br.edu.ifms.requerimentos.dao.RequerimentoDAO;
import br.edu.ifms.requerimentos.dao.ServidorDAO;
import br.edu.ifms.requerimentos.dao.SetorDAO;
import br.edu.ifms.requerimentos.model.Curso;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.Setor;

public class RequerimentoBO {

	public void salvaRequerimento(Requerimento requerimento,
			Estudante estudante, Requerente requerente, Parecer parecer, Matricula matricula, Curso curso, Integer setorId) {
		RequerimentoDAO reqDAO = new RequerimentoDAO();
		ServidorDAO servDAO = new ServidorDAO();
		SetorDAO setDAO = new SetorDAO();
		MatriculaDAO matriDAO = new MatriculaDAO();
		Matricula novaMatricula = new Matricula();
		Requerimento novoRequerimento = new Requerimento();
		novoRequerimento = requerimento;
		requerente.setEstudante(estudante);
		novoRequerimento.setRequerente(requerente);
		novaMatricula = matriDAO.recuperaPorMatricula("2014104035002-1");
		novaMatricula.setPeriodo(matricula.getPeriodo());
		novaMatricula.setTurma(matricula.getTurma());
		novaMatricula.setTurno(matricula.getTurno());
		novoRequerimento.setMatricula(novaMatricula);
		novoRequerimento.setSetorDestino(setDAO.recuperaPorId(setorId));
		parecer.setServidor(servDAO.recuperaPorId(5));
		novoRequerimento.setServidorResponsavel(servDAO.recuperaPorId(5));
		novoRequerimento.setProtocolo(requerimento.getProtocolo());
		novoRequerimento.setData(requerimento.getData());
		reqDAO.salva(novoRequerimento);
		
		//MatriculaDAO matDAO = new MatriculaDAO();
		//List<Matricula> lista = matDAO.recuperaPorNome(estudante.getId());
		//lista.stream().forEach(elem -> System.out.println(elem.getMatricula()));
		
	}

}
