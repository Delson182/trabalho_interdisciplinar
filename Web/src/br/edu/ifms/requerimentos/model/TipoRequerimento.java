package br.edu.ifms.requerimentos.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="tipo_requerimento")
public class TipoRequerimento {
	@Id
	@GeneratedValue
	private Integer id;
	@JoinColumn(name="requerimento_fk")
	@ManyToOne
	private Requerimento requerimento;
	@Enumerated(EnumType.STRING)
	private DescricaoTipoRequerimento tipo;
	
	public Requerimento getRequerimento() {
		return requerimento;
	}
	public void setRequerimento(Requerimento requerimento) {
		this.requerimento = requerimento;
	}
	public DescricaoTipoRequerimento getTipo() {
		return tipo;
	}
	public void setTipo(DescricaoTipoRequerimento tipo) {
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
