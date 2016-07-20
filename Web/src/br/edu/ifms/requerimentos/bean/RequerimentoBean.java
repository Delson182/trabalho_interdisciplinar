package br.edu.ifms.requerimentos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import br.edu.ifms.requerimento.business.RequerimentoBO;
import br.edu.ifms.requerimentos.dao.EstudanteDAO;
import br.edu.ifms.requerimentos.model.DescricaoTipoRequerimento;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.Servidor;

@ManagedBean
@ViewScoped
public class RequerimentoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Requerimento requerimento;
	private Parecer parecer;
	private Matricula matricula;
	private Requerente requerente;
	private Estudante estudante;
	private Servidor servidor;
	private TiposRequerimento tiposRequerimento = new TiposRequerimento();
	private boolean estudanteErequerente;
	
	@PostConstruct
	public void init() {
	   requerente = new Requerente();
	   estudante = new Estudante();
	}
	
	public void autoCompletar(AjaxBehaviorEvent event) {
		EstudanteDAO estuDAO = new EstudanteDAO();
		List<Estudante> estudantes = estuDAO.recuperaTodos();
		Estudante resultado = new Estudante();
		if(!(estudantes.stream().filter(elem -> elem.getNome().equals(requerente.getNomerequerente())).count()>1)){
			resultado= estudantes.stream().filter(elem -> elem.getNome().equals(requerente.getNomerequerente())).findFirst().orElse(null);
			requerente.setCpf(resultado.getCpf());
			estudante.setRa(resultado.getRa());
			requerente.setFonecel(resultado.getTelefone());
			requerente.setEmail(resultado.getEmail());
			estudante.setNome(resultado.getNome());
		}
		
	} 


	public String getNomesCSV() {
		StringBuilder b=new StringBuilder();
		EstudanteDAO estuDAO = new EstudanteDAO();
		List<Estudante> estudantes = estuDAO.recuperaTodos();;
		for (Estudante s:estudantes) {
			if (b.length()>0) {
				b.append(",");
			}
			b.append((s.getNome()));
			
		}
		return (b.toString());
	}
	
	public String salvar(){
		RequerimentoBO reqBO= new RequerimentoBO();
		List<DescricaoTipoRequerimento> listaTiposRequerimentos = criaListaTiposRequerimento();
		reqBO.salvaRequerimento(requerimento, listaTiposRequerimentos, estudante, requerente, parecer, matricula);
		return"";
	}
	
	public List<DescricaoTipoRequerimento> criaListaTiposRequerimento(){
		List<DescricaoTipoRequerimento> descr = new ArrayList<DescricaoTipoRequerimento>() ;
		if(tiposRequerimento.isCancelamentoMatricula()){
			descr.add(DescricaoTipoRequerimento.CANCELAMENTO_MATRICULA);
		}
		if(tiposRequerimento.isCancelamentoUnidadeCurricular()){
			descr.add(DescricaoTipoRequerimento.CANCELAMENTO_UNIDADE_CURRICULAR);
		}
		if(tiposRequerimento.isCertificadoQualificacaoProfisional()){
			descr.add(DescricaoTipoRequerimento.CERTIFICADO_DE_QUALIFICACAO_PROFISSIONAL);
		}
		if(tiposRequerimento.isConvalidacao()){
			descr.add(DescricaoTipoRequerimento.CONVALIDACAO);
		}
		if(tiposRequerimento.isDeclaracao()){
			descr.add(DescricaoTipoRequerimento.DECLARACAO);
		}
		if(tiposRequerimento.isDesistenciaDeCurso()){
			descr.add(DescricaoTipoRequerimento.DESISTENCIA_DE_CURSO);
		}
		if(tiposRequerimento.isEnriquecimentoProfissional()){
			descr.add(DescricaoTipoRequerimento.ENREQUECIMENTO_PROFISSIONAL);
		}
		if(tiposRequerimento.isExameSuficiencia()){
			descr.add(DescricaoTipoRequerimento.EXAME_DE_SUFICIENCIA);
		}
		if(tiposRequerimento.isHistoricoEscolar()){
			descr.add(DescricaoTipoRequerimento.HISTORICO_ESCOLAR);
		}
		if(tiposRequerimento.isMatriculaEmUnidadeCurricular()){
			descr.add(DescricaoTipoRequerimento.MATRICULA_EM_UNIDADE_CURRICULAR);
		}
		if(tiposRequerimento.isMudancaDeTurma()){
			descr.add(DescricaoTipoRequerimento.MUDANCA_DE_TURMA);
		}
		if(tiposRequerimento.isMudancaDeTurno()){
			descr.add(DescricaoTipoRequerimento.MUDANCA_DE_TURNO);
		}
		if(tiposRequerimento.isTrancamento()){
			descr.add(DescricaoTipoRequerimento.TRANCAMENTO);
		}
		if(tiposRequerimento.isSegundaChamada()){
			descr.add(DescricaoTipoRequerimento.SEGUNDA_CHAMADA);
		}
		if(tiposRequerimento.isTrasnferencia()){
			descr.add(DescricaoTipoRequerimento.TRANSFERENCIA);
		}
		if(tiposRequerimento.isOutros()){
			descr.add(DescricaoTipoRequerimento.OUTROS);
		}
		return descr;
	}
	
	public TiposRequerimento getTiposRequerimento() {
		return tiposRequerimento;
	}

	public void setTiposRequerimento(TiposRequerimento tiposRequerimento) {
		this.tiposRequerimento = tiposRequerimento;
	}

	public boolean isEstudanteErequerente() {
		return estudanteErequerente;
	}

	public void setEstudanteErequerente(boolean estudanteErequerente) {
		this.estudanteErequerente = estudanteErequerente;
	}

	public Requerimento getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(Requerimento requerimento) {
		this.requerimento = requerimento;
	}

	public Parecer getParecer() {
		return parecer;
	}

	public void setParecer(Parecer parecer) {
		this.parecer = parecer;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Requerente getRequerente() {
		return requerente;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}  
	
}
