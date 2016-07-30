package br.edu.ifms.requerimentos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="servidor_setor")
public class ServidorSetor {
	@Id
	@Column(name="servidor_setor_id")
	private Integer id;
	@JoinColumn(name="servidor_fk")
	@OneToOne
	private Servidor servidor;
	@JoinColumn(name="setor_fk")
	@OneToOne
	private Setor setor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
}
