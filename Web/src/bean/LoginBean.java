package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String nomeUsuario;


	private String senha;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login() {
		if(nomeUsuario.isEmpty()){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Prencha o campo Usuário.", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:nomeUsuario", msg);
		}else if(senha.isEmpty()){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Prencha o campo Senha.", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:senha", msg);
		}else if ("BootsFaces".equalsIgnoreCase(nomeUsuario) && "rocks!".equalsIgnoreCase(senha)) {
			return "visualizar.xhtml?faces-redirect=true";
		}else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos!", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:nomeUsuario", msg);
		}
		return null;
	}

	public void login2() {
		if ("BootsFaces".equalsIgnoreCase(nomeUsuario) && "rocks!".equalsIgnoreCase(senha)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Congratulations! You've successfully logged in.", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:passwordDiv", msg);

		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "That's the wrong password. Hint: BootsFaces rocks!", "");
			FacesContext.getCurrentInstance().addMessage("loginForm:passwordDiv", msg);
		}
	}

	public void forgotPassword() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Default user name: BootsFaces", "");
		FacesContext.getCurrentInstance().addMessage("loginForm:nomeUsuario", msg);
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Default senha: rocks!", "");
		FacesContext.getCurrentInstance().addMessage("loginForm:senha", msg);
	}
}
