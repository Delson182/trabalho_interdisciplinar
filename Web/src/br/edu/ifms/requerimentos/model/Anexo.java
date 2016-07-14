package br.edu.ifms.requerimentos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Anexo {
	@Id
	@Column(name = "anexo_id")
	private Integer id;
	@Column(name = "nome_original")
	private String nome;
	private String hash;
	@ManyToOne
	private Requerimento requerimento;
	@OneToMany
	private Integer servidor;
	@Column(name = "datahora_upload")
	private Date data;
	private boolean sigiloso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Requerimento getRequerimento() {
		return requerimento;
	}
	public void setRequerimento(Requerimento requerimento) {
		this.requerimento = requerimento;
	}
	public Integer getServidor() {
		return servidor;
	}
	public void setServidor(Integer servidor) {
		this.servidor = servidor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean getSigiloso() {
		return sigiloso;
	}
	public void setSigiloso(boolean sigiloso) {
		this.sigiloso = sigiloso;
	}

}
