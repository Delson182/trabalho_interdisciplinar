package br.edu.ifms.requerimentos.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.ifms.requerimentos.dao.ServidorDAO;
import br.edu.ifms.requerimentos.model.Servidor;

@ManagedBean
@ViewScoped
public class LoginBean {

	private String siape;
	private String senha;
	private ServidorDAO servidorDao = new ServidorDAO();

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login() {
		Servidor servidor = servidorDao.autenticaUsuario(siape, senha);
		if (siape.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Prencha o campo Siape!", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:siape", msg);
		} else if (senha.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Prencha o campo Senha!", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:senha", msg);
		} else
		if (servidor!=null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", servidor);
			return "restrito/visualizar?faces-redirect=true";
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Siape ou senha inválidos!", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:siape", msg);
		}
		return "#";
	}

}
