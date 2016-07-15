package br.edu.ifms.requerimentos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servidor {
	@Id
	@Column(name="servidor_id")
	private Integer id;
	private String siape;
	private String nome;
	
	public Servidor(Integer id, String siape, String nome) {
		this.id = id;
		this.siape = siape;
		this.nome = nome;
	}
	public String getSiape() {
		return siape;
	}
	public void setSiape(String siape) {
		this.siape = siape;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
