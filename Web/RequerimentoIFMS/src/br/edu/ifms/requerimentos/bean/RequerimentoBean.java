package br.edu.ifms.requerimentos.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import br.edu.ifms.requerimento.business.RequerimentoBO;
import br.edu.ifms.requerimentos.dao.MatriculaDAO;
import br.edu.ifms.requerimentos.dao.ParecerDAO;
import br.edu.ifms.requerimentos.dao.RequerenteDAO;
import br.edu.ifms.requerimentos.dao.RequerimentoDAO;
import br.edu.ifms.requerimentos.dao.ServidorSetorDAO;
import br.edu.ifms.requerimentos.model.Curso;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.Servidor;
import br.edu.ifms.requerimentos.model.ServidorSetor;

@ManagedBean
@ViewScoped
public class RequerimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Requerimento requerimento;
	private Curso curso;
	private Parecer parecer;
	private Matricula matricula;
	private Requerente requerente;
	private Estudante estudante;
	private Servidor servidor;
	private Integer setorId;
	private TiposRequerimento tiposRequerimento;
	private boolean estudanteNaoRequerente;
	private List<Matricula> matriculas;
	private List<Requerente> requerentes;
	private List<Parecer> historicoParecer;
	private boolean servidorCerel;
	private boolean servidorDoSetorDestino;
	
	@PostConstruct
	public void init() {
		tiposRequerimento = new TiposRequerimento();
		servidor = (Servidor) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("user");
		ServidorSetorDAO setorServDAO = new ServidorSetorDAO();
		String setores = setorServDAO.recuperaSetoresPorIdServidor(servidor.getId());
		
		if(servidor != null){  
			if(setores.contains("AQ-CEREL")){
				servidorCerel = true;
			}else{
				setorId = 3;
				servidorCerel = false;
			}
		}else{
			servidorCerel = false;
		}
		requerimento = (Requerimento) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("requerimento");
		if(requerimento == null){
			requerimento = new Requerimento();
			requerente = new Requerente();
			estudante = new Estudante();
			curso = new Curso();
			matricula = new Matricula();
		}else{
			requerente = requerimento.getRequerente();
			estudante = requerimento.getMatricula().getEstudante();
			curso = requerimento.getMatricula().getCurso();
			matricula = requerimento.getMatricula();
			ParecerDAO pareDAO = new ParecerDAO();
			historicoParecer = pareDAO.recuperaPeloRequerimentoId(requerimento.getId());
			setaTipoRequerimento();
			if("setores".contains(requerimento.getSetorDestino().getSigla())){
				servidorDoSetorDestino = true;
			}
			requerimento = (Requerimento) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().put("requerimento", null);
			

		}
		parecer = new Parecer();
		RequerenteDAO requDAO = new RequerenteDAO();
		MatriculaDAO matriDAO = new MatriculaDAO();
		requerentes = requDAO.recuperaApenasRequerentesNaoAlunos();
		matriculas = matriDAO.recuperaTodos();
	//	requerimento.setServidorResponsavel(servidor);
		
	}

	public String salvar() {
		RequerimentoBO reqBO = new RequerimentoBO();
		if(requerimento.getId() == null){
			requerimento.setTiporeq1(tiposRequerimento.isCancelamentoMatricula());
			requerimento.setTiporeq2(tiposRequerimento.isCancelamentoUnidadeCurricular());
			requerimento.setTiporeq3(tiposRequerimento.isCertificadoQualificacaoProfisional());
			requerimento.setTiporeq4(tiposRequerimento.isConvalidacao());
			requerimento.setTiporeq5(tiposRequerimento.isDeclaracao());
			requerimento.setTiporeq6(tiposRequerimento.isDesistenciaDeCurso());
			requerimento.setTiporeq7(tiposRequerimento.isEnriquecimentoCurricular());
			requerimento.setTiporeq8(tiposRequerimento.isExameSuficiencia());
			requerimento.setTiporeq9(tiposRequerimento.isHistoricoEscolar());
			requerimento.setTiporeq10(tiposRequerimento.isMatriculaEmUnidadeCurricular());
			requerimento.setTiporeq11(tiposRequerimento.isMudancaDeTurma());
			requerimento.setTiporeq12(tiposRequerimento.isMudancaDeTurno());
			requerimento.setTiporeq13(tiposRequerimento.isTrancamento());
			requerimento.setTiporeq14(tiposRequerimento.isTrasnferencia());
			requerimento.setTiporeq15(tiposRequerimento.isSegundaChamada());
			requerimento.setTiporeq16(tiposRequerimento.isOutros());
			if(!estudanteNaoRequerente && matricula.getEstudante() != null){
				requerente.setNomerequerente(matricula.getEstudante().getNome());
			}
			reqBO.salvaRequerimento(requerimento, estudante, requerente, parecer, matricula, curso, setorId);
		}else{
			parecer.setServidor(servidor);
			parecer.setRequerimento(requerimento); 
			reqBO.salvaParecer(parecer, setorId);
		}
		return "";
	}

	// Quando o botão enter é pressionado no input do nome do estudante, o
	// evento change e acionado e chama esse método
	public void autoCompletarEstudante(AjaxBehaviorEvent event) {
		MatriculaDAO matriDAO = new MatriculaDAO();
		Matricula matriculaRecuperada = new Matricula();
		try {
			String[] numeroMatricula = estudante.getNome().split(" ");
			matriculaRecuperada = matriDAO.recuperaPorMatricula(numeroMatricula[0]);
			matricula = matriculaRecuperada;
			if (matriculaRecuperada != null) {
				curso.setNome(matriculaRecuperada.getCurso().getNome());
				estudante.setRa(matriculaRecuperada.getEstudante().getRa());
				requerente.setCpf(matriculaRecuperada.getEstudante().getCpf());
				estudante.setTelefone(requerente.getFonefixo());
				if (matriculaRecuperada.getEstudante().getCelular() != null) {
					requerente.setFonecel(matriculaRecuperada.getEstudante().getCelular());
				}
				if (matriculaRecuperada.getEstudante().getEmail() != null) {
					requerente.setEmail(matriculaRecuperada.getEstudante().getEmail());
				}
				if (matriculaRecuperada.getEstudante().getTelefone() != null) {
					requerente.setFonefixo(matriculaRecuperada.getEstudante().getTelefone());
				}
				if (matriculaRecuperada.getPeriodo() != null) {
					matricula.setPeriodo(matriculaRecuperada.getPeriodo());
				}
				if (matriculaRecuperada.getTurno() != null) {
					matricula.setTurno(matriculaRecuperada.getTurno());
				}
				if (matriculaRecuperada.getTurma() != null) {
					matricula.setTurma(matriculaRecuperada.getTurma());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Quando o botão enter é pressionado no input do nome do requerente, o evento change e acionado e chama esse método
	public void autoCompletarRequerente(AjaxBehaviorEvent event) {
		RequerenteDAO reqDAO = new RequerenteDAO();
		Requerente requerenteRecuperado = new Requerente();
		try {
			String[] cpf = requerente.getNomerequerente().split(" ");
			requerenteRecuperado = reqDAO.recuperaPorCpf(cpf[0]);
			if (requerenteRecuperado != null) {
				requerente.setCpf(requerenteRecuperado.getEstudante().getCpf());
				requerente.setRg(requerenteRecuperado.getRg());
				requerente.setFonecel(requerenteRecuperado.getFonecel());
				requerente.setFonefixo(requerenteRecuperado.getFonefixo());
				requerente.setEmail(requerenteRecuperado.getEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	// Cria lista pro autocompletar do campo do nome do estudante
	public String getNomesEstudantesCSV() {
		StringBuilder b = new StringBuilder();
		for (Matricula m : matriculas) {
			if (b.length() > 0) {
				b.append(",");
			}
			b.append((m.getMatricula() + "  " + m.getEstudante().getNome()));

		}
		return (b.toString());
	}

	// Cria lista pro autocompletar do campo dos requerentes
	public String getNomesRequerentesCSV() {
		StringBuilder b = new StringBuilder();
		for (Requerente r : requerentes) {
			if (b.length() > 0) {
				b.append(",");
			}
			b.append(r.getCpf() + "  " + r.getNomerequerente());

		}
		return (b.toString());
	}
	
	//seta os tipos so requerimento caso RequerimentoBean receba um objeto requerimento
	public void setaTipoRequerimento(){
		tiposRequerimento.setCancelamentoMatricula(requerimento.isTiporeq1());
		tiposRequerimento.setCancelamentoUnidadeCurricular(requerimento.isTiporeq2());
		tiposRequerimento.setCertificadoQualificacaoProfisional(requerimento.isTiporeq3());
		tiposRequerimento.setConvalidacao(requerimento.isTiporeq4());
		tiposRequerimento.setDeclaracao(requerimento.isTiporeq5());
		tiposRequerimento.setDesistenciaDeCurso(requerimento.isTiporeq6());
		tiposRequerimento.setEnriquecimentoCurricular(requerimento.isTiporeq7());
		tiposRequerimento.setExameSuficiencia(requerimento.isTiporeq8());
		tiposRequerimento.setHistoricoEscolar(requerimento.isTiporeq9());
		tiposRequerimento.setMatriculaEmUnidadeCurricular(requerimento.isTiporeq10());
		tiposRequerimento.setMudancaDeTurma(requerimento.isTiporeq11());
		tiposRequerimento.setMudancaDeTurno(requerimento.isTiporeq12());
		tiposRequerimento.setTrancamento(requerimento.isTiporeq13());
		tiposRequerimento.setTrasnferencia(requerimento.isTiporeq14());
		tiposRequerimento.setSegundaChamada(requerimento.isTiporeq15());
		tiposRequerimento.setOutros(requerimento.isTiporeq16());
	}
	
	public TiposRequerimento getTiposRequerimento() {
		return tiposRequerimento;
	}

	public void setTiposRequerimento(TiposRequerimento tiposRequerimento) {
		this.tiposRequerimento = tiposRequerimento;
	}

	public List<Parecer> getHistoricoParecer() {
		return historicoParecer;
	}



	public void setHistoricoParecer(List<Parecer> historicoParecer) {
		this.historicoParecer = historicoParecer;
	}



	public boolean isEstudanteNaoRequerente() {
		return estudanteNaoRequerente;
	}

	public void setEstudanteNaoRequerente(boolean estudanteErequerente) {
		this.estudanteNaoRequerente = estudanteErequerente;
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

	public Matricula getMatricula() {
		return matricula;
	}

	public Requerente getRequerente() {
		return requerente;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public Curso getCurso() {
		return curso;
	}

	public Integer getSetorId() {
		return setorId;
	}

	public void setSetorId(Integer setorId) {
		this.setorId = setorId;
	}

	public boolean isServidorCerel() {
		return servidorCerel;
	}

	public void setServidorCerel(boolean servidorCerel) {
		this.servidorCerel = servidorCerel;
	}

	public boolean isServidorDoSetorDestino() {
		return servidorDoSetorDestino;
	}

	public void setServidorDoSetorDestino(boolean servidorDoSetorDestino) {
		this.servidorDoSetorDestino = servidorDoSetorDestino;
	}

}
