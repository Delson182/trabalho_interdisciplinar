package br.edu.ifms.requerimentos.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Parecer{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="parecer_id")
    private Integer id;
	@Column(name="dados_parecer")
	private String observacaoParecer;
	private String deliberacaoParecer;
	@Column(name="datahora_parecer")
    private Date data;
	@JoinColumn(name="servidor_responsavel_fk")
	@OneToOne
    private Servidor servidor;
	@JoinColumn(name="setor_encaminhado_fk")
	@OneToOne
    private Setor setor;
	@JoinColumn(name="requerimento_fk")
	@ManyToOne(cascade = {CascadeType.ALL})
    private Requerimento requerimento ;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	public Requerimento getRequerimento() {
		return requerimento;
	}
	public void setRequerimento(Requerimento requerimento) {
		this.requerimento = requerimento;
	}
	public String getObservacaoParecer() {
		return observacaoParecer;
	}
	public void setObservacaoParecer(String observacaoParecer) {
		this.observacaoParecer = observacaoParecer;
	}
	public String getDeliberacaoParecer() {
		return deliberacaoParecer;
	}
	public void setDeliberacaoParecer(String deliberacaoParecer) {
		this.deliberacaoParecer = deliberacaoParecer;
	}

}
