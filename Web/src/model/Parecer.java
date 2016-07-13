package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Parecer{
	@Id
	@Column(name="parecer_id")
    private Integer id;
	@Column(name="datahora_parecer")
    private Date data ;
	@OneToOne
    private Servidor servidor ;
	@OneToOne
    private Setor setor;
	@ManyToOne
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

}
