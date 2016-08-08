package br.edu.ifms.requerimentos.model;

import java.util.List;

public class RequerimentoMobile {
	
	
	private String protocolo;
    private String dataCriacao;
    private boolean[] tiposReq;
    private List<String> detalhamento;
    private String status;
    
    public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	

	public List<String> getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(List<String> detalhamento) {
		this.detalhamento = detalhamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean[] getTiposReq() {
		return tiposReq;
	}

	public void setTiposReq(boolean[] tiposReq) {
		this.tiposReq = tiposReq;
	}

    
}
