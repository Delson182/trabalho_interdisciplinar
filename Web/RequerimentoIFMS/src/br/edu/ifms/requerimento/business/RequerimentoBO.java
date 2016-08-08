package br.edu.ifms.requerimento.business;

import java.util.Calendar;

import javax.faces.context.FacesContext;

import br.edu.ifms.requerimentos.dao.ParecerDAO;
import br.edu.ifms.requerimentos.dao.RequerenteDAO;
import br.edu.ifms.requerimentos.dao.SetorDAO;
import br.edu.ifms.requerimentos.model.Curso;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.Servidor;

public class RequerimentoBO {

	public void salvaRequerimento(Requerimento requerimento, Estudante estudante, Requerente requerente,
			Parecer parecer, Matricula matricula, Curso curso, Integer setorId) {
	
		SetorDAO setDAO = new SetorDAO();
		ParecerDAO pareDAO = new ParecerDAO();
		RequerenteDAO reqDAO = new RequerenteDAO();
		Requerimento novoRequerimento = new Requerimento();
		novoRequerimento = requerimento;
		estudante = matricula.getEstudante();
		estudante.setCelular(requerente.getFonecel());
		estudante.setTelefone(requerente.getFonefixo());
		estudante.setEmail(requerente.getEmail());
		requerente.setEstudante(estudante);
		Requerente requerenteHistorico = reqDAO.buscaCpfComIdDoEstudante(requerente.getCpf(), estudante.getId());
		if(!(requerenteHistorico == null)){ //Se a relação requerente e aluno já existir, recupera id do objeto no banco
			requerenteHistorico.setFonecel(requerente.getFonecel());
			requerenteHistorico.setFonefixo(requerente.getFonefixo());
			requerenteHistorico.setEmail(requerente.getEmail());
			requerimento.setRequerente(requerenteHistorico);
		}else{
			novoRequerimento.setRequerente(requerente);
		}
		
		novoRequerimento.setMatricula(matricula);
		novoRequerimento.setSetorDestino(setDAO.recuperaPorId(setorId));
		novoRequerimento.setDetalhamentoPedido(requerimento.getDetalhamentoPedido());
		novoRequerimento.setDeferimento(requerimento.getDeferimento());
		novoRequerimento.setDataPrimeiroEncaminhamento(Calendar.getInstance().getTime());
		parecer.setServidor(requerimento.getServidorResponsavel());
		novoRequerimento.setServidorResponsavel(requerimento.getServidorResponsavel());
		novoRequerimento.setProtocolo(requerimento.getProtocolo());
		novoRequerimento.setData(requerimento.getData());
		parecer.setRequerimento(novoRequerimento);
		parecer.setServidor(novoRequerimento.getServidorResponsavel());
		parecer.setObservacaoParecer(parecer.getObservacaoParecer());
		parecer.setSetor(setDAO.recuperaPorId(3));
		parecer.setData(Calendar.getInstance().getTime());
		pareDAO.salvaComRequerimento(parecer);
	}

	public void salvaParecer(Parecer parecer, Integer setorID) {
		ParecerDAO parDAO = new ParecerDAO();
		SetorDAO setDAO = new SetorDAO();
		parDAO.salva(parecer);
	}

}
