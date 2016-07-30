package br.edu.ifms.requerimentos.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.ifms.requerimento.bean.model.Visualizar;
import br.edu.ifms.requerimentos.dao.VisualizarDAO;
import br.edu.ifms.requerimentos.model.Requerimento;

@ManagedBean 
@ViewScoped
public class VisualizarBean {
	
	private String filtro;
	private boolean pendente;
	private boolean deferido;
	private boolean indeferido;
	private Visualizar visualizar;
	private Requerimento requerimento;
	private List<Visualizar> lista;
	private String prot;
	
	
	public String criarNovo(){
		return "novo?faces-redirect=true";
	}
	public String getProt() {
		return prot;
	}

	public void setProt(String prot) {
		this.prot = prot;
	}

	public Visualizar getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Visualizar visualizar) {
		this.visualizar = visualizar;
	}

	public VisualizarBean() {
		requerimento = new Requerimento();
		visualizar = new Visualizar();
	}

	public String getFiltro(){
		return filtro; 
	}
	
	public void setFiltro(String filtro){
		this.filtro = filtro;
	}
	
	public String getProtocolo() {
		return requerimento.getProtocolo();
	}

	public Date getDataCriacao() {
		return requerimento.getData();
	}

	public String getNome() {
		return requerimento.getRequerente().getNomerequerente();
	}

	public String getSetor() {
		return requerimento.getSetorDestino().getSigla();
	}
	
	public boolean isPendente() {
		return pendente;
	}

	public void setPendente(boolean pendentes) {
		this.pendente = pendentes;
	}

	public boolean isDeferido() {
		return deferido;
	}

	public void setDeferido(boolean deferido) {
		this.deferido = deferido;
	}

	public boolean isIndeferido() {
		return indeferido;
	}

	public void setIndeferido(boolean indeferido) {
		this.indeferido = indeferido;
	}	
	public List<Visualizar> getLista() {
		return lista;
	}

	public void setLista(List<Visualizar> lista) {
		this.lista = lista;
	}

	public void recuperarLista(){
		VisualizarDAO visualizar = new VisualizarDAO();
		lista = visualizar.recuperaTodos(filtro);
		lista = lista == null ? new ArrayList<>() : lista;
	}
	
	public String modal(Visualizar visualizar) {
		this.visualizar = visualizar;
		System.out.println("Protocolo: " + visualizar.getProtocolo());
		return "$('.modalPseudoClass').modal();return false;";
	}
}