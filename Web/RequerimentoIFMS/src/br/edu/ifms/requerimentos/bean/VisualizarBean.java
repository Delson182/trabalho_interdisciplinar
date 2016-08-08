package br.edu.ifms.requerimentos.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.ifms.requerimentos.dao.RequerimentoDAO;
import br.edu.ifms.requerimentos.dao.ServidorSetorDAO;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.Servidor;
@ManagedBean 
@ViewScoped
public class VisualizarBean {
	
	private String filtro;
	private List<Requerimento> listaRequerimentos;
	private Requerimento requerimentoSelecionado;
	List<Requerimento> requerimentosRecuperados;
	private List<Requerimento> requerimentosDoSetor;
	private Servidor  servidor ;
	private boolean servidorCerel;
	
	@PostConstruct
	public void init() {
		RequerimentoDAO reqDAO = new RequerimentoDAO();
		ServidorSetorDAO setorServDAO = new ServidorSetorDAO();
		listaRequerimentos = reqDAO.recuperaTodos();
		requerimentosRecuperados = listaRequerimentos;
		servidor = (Servidor) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("user");
		requerimentosRecuperados = new ArrayList<Requerimento>();
		String setores = setorServDAO.recuperaSetoresPorIdServidor(servidor.getId());
		for(Requerimento req: listaRequerimentos){
			if(setores.contains(req.getSetorDestino().getSigla())){
				requerimentosDoSetor.add(req);
			}
		}
		
		 
		if(setores.contains("AQ-CEREL")){
			servidorCerel = true;
		}else{
			servidorCerel = false;
		}
	}
	public boolean isServidorCerel() {
		return servidorCerel;
	}
	public void setServidorCerel(boolean servidorCerel) {
		this.servidorCerel = servidorCerel;
	}
	public List<Requerimento> getRequerimentosDoSetor() {
		return requerimentosDoSetor;
	}
	public void setRequerimentosDoSetor(List<Requerimento> requerimentosDoSetor) {
		this.requerimentosDoSetor = requerimentosDoSetor;
	}
	public String editarRequerimento() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("requerimento", requerimentoSelecionado);
		return "novo?faces-redirect=true";
		
	}
	public List<Requerimento> buscar(){
		List<Requerimento> resultado = requerimentosRecuperados.stream().filter(req -> req.getProtocolo().
				toLowerCase().contains(filtro.toLowerCase()) || req.getMatricula().getEstudante().getNome().
				toLowerCase().contains(filtro.toLowerCase()) ||req.getSetorDestino().getSigla().
				toLowerCase().contains(filtro.toLowerCase()) || req.getDeferimento().
				toLowerCase().contains(filtro.toLowerCase())).collect(Collectors.toList());
		listaRequerimentos = resultado;
		return listaRequerimentos;
	}
	
	public List<Requerimento> getListaRequerimentos() {
		return listaRequerimentos;
	}
	public void setListaRequerimentos(List<Requerimento> listaRequerimentos) {
		this.listaRequerimentos = listaRequerimentos;
	}
	public Requerimento getRequerimentoSelecionado() {
		return requerimentoSelecionado;
	}
	public void setRequerimentoSelecionado(Requerimento requerimentoSelecionado) {
		this.requerimentoSelecionado = requerimentoSelecionado;
	}
	public String criarNovo(){
		return "novo?faces-redirect=true";
	}
	
	public String getFiltro(){
		return filtro; 
	}
	
	public void setFiltro(String filtro){
		this.filtro = filtro;
	}
	

}