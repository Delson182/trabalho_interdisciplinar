package bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;

import util.TipoRequerimento;

@ManagedBean
@ViewScoped
public class RequerimentoBean{
	
	private String protocolo;
	private Date dataCriacao;
	private String nomeRequerente;
	private String rg;
	private String cpf;
	private String ra;
	private String telefone;
	private String celular;
	private String email;
	private String nomeEstudante;
	private String curso;
	private String periodo;
	private String turno;
	private String turma;
	private String tipoRequerimento;
	private boolean estudanteErequerente;
	private String detalhamento;
	private String parecer;
	private boolean cancelMa, cancelUni, hist, certiQuali, conva, declara, desis, enrProf, exSuf, matrUni,
	mudaTurm, mudaTurn, tranc, trasf, segunCham, outros;
	private boolean favoravel, desfavoravel, naoAptoDespachar;
	private String setorDestino;
	
	
	public String salvar(){
		validar();
		TipoRequerimento tipoReq = new TipoRequerimento();
		tipoRequerimento = tipoReq.verificaTipo(cancelMa, cancelUni, hist, certiQuali, conva, declara, desis, enrProf,
				exSuf, matrUni, mudaTurm, mudaTurn, tranc, trasf, segunCham, outros);
		
		System.out.println(dataCriacao);
		System.out.println(tipoRequerimento);
		System.out.println(curso);
		System.out.println(desfavoravel);
		return"";
	}
	public void eventoCheck(AjaxBehaviorEvent e) {
		System.out.println("entroooo");
		 if(favoravel){
			 desfavoravel = false;
			 naoAptoDespachar = false;
			 
		 }
		e.setPhaseId(PhaseId.INVOKE_APPLICATION);
		 
		  
	}
	public void validar(){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "campo inválidos", "");
		if(protocolo == null || protocolo.isEmpty()){
			FacesContext.getCurrentInstance().addMessage("formularioTopo:protocolo", msg);
		}
	}
	
	
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getNomeRequerente() {
		return nomeRequerente;
	}
	public void setNomeRequerente(String nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeEstudante() {
		return nomeEstudante;
	}
	public void setNomeEstudante(String nomeEstudante) {
		this.nomeEstudante = nomeEstudante;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getTipoRequerimento() {
		return tipoRequerimento;
	}
	public void setTipoRequerimento(String tipoRequerimento) {
		this.tipoRequerimento = tipoRequerimento;
	}
	public boolean isEstudanteErequerente() {
		return estudanteErequerente;
	}
	public void setEstudanteErequerente(boolean estudanteErequerente) {
		this.estudanteErequerente = estudanteErequerente;
	}

	public boolean isCancelMa() {
		return cancelMa;
	}
	public void setCancelMa(boolean cancelMa) {
		this.cancelMa = cancelMa;
	}
	public boolean isCancelUni() {
		return cancelUni;
	}
	public void setCancelUni(boolean cancelUni) {
		this.cancelUni = cancelUni;
	}
	public boolean isHist() {
		return hist;
	}
	public void setHist(boolean hist) {
		this.hist = hist;
	}
	public boolean isCertiQuali() {
		return certiQuali;
	}
	public void setCertiQuali(boolean certiQuali) {
		this.certiQuali = certiQuali;
	}
	public boolean isConva() {
		return conva;
	}
	public void setConva(boolean conva) {
		this.conva = conva;
	}
	public boolean isDeclara() {
		return declara;
	}
	public void setDeclara(boolean declara) {
		this.declara = declara;
	}
	public boolean isDesis() {
		return desis;
	}
	public void setDesis(boolean desis) {
		this.desis = desis;
	}
	public boolean isEnrProf() {
		return enrProf;
	}
	public void setEnrProf(boolean enrProf) {
		this.enrProf = enrProf;
	}
	public boolean isExSuf() {
		return exSuf;
	}
	public void setExSuf(boolean exSuf) {
		this.exSuf = exSuf;
	}
	public boolean isMatrUni() {
		return matrUni;
	}
	public void setMatrUni(boolean matrUni) {
		this.matrUni = matrUni;
	}
	public boolean isMudaTurm() {
		return mudaTurm;
	}
	public void setMudaTurm(boolean mudaTurm) {
		this.mudaTurm = mudaTurm;
	}
	public boolean isMudaTurn() {
		return mudaTurn;
	}
	public void setMudaTurn(boolean mudaTurn) {
		this.mudaTurn = mudaTurn;
	}
	public boolean isTranc() {
		return tranc;
	}
	public void setTranc(boolean tranc) {
		this.tranc = tranc;
	}
	public boolean isTrasf() {
		return trasf;
	}
	public void setTrasf(boolean trasf) {
		this.trasf = trasf;
	}
	public boolean isSegunCham() {
		return segunCham;
	}
	public void setSegunCham(boolean segunCham) {
		this.segunCham = segunCham;
	}
	public boolean isOutros() {
		return outros;
	}
	public void setOutros(boolean outros) {
		this.outros = outros;
	}
	public String getDetalhamento() {
		return detalhamento;
	}
	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}
	public String getParecer() {
		return parecer;
	}
	public void setParecer(String parecer) {
		this.parecer = parecer;
	}
	public boolean isFavoravel() {
		return favoravel;
	}
	public void setFavoravel(boolean favoravel) {
		System.out.println("setou");
		this.favoravel = favoravel;
	}
	public boolean isDesfavoravel() {
		return desfavoravel;
	}
	public void setDesfavoravel(boolean desfavoravel) {
		this.desfavoravel = desfavoravel;
	}
	public boolean isNaoAptoDespachar() {
		return naoAptoDespachar;
	}
	public void setNaoAptoDespachar(boolean naoAptoDespachar) {
		this.naoAptoDespachar = naoAptoDespachar;
	}
	public String getSetorDestino() {
		return setorDestino;
	}
	public void setSetorDestino(String setorDestino) {
		this.setorDestino = setorDestino;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}  
	
}
