package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Requerimento {
	@Id
	@Column(name = "requerimento_id")
	@GeneratedValue
	private Integer id;
	@Column(name = "data_criacao")
	private Date data;
	@Column(name = "tipo_requerimento")
	private String tipoRequerimento;
	@Column(name = "detalhamento_pedido")
	private String detalhamentoPedido;
	@Column(name = "deferimento")
	private String deferimento;
	@Column(name = "data_primeiro_encaminhamento")
	private Date dataPrimeiroEncaminhamento;
	@JoinColumn(name="servidor_responsavel_fk")
	@OneToOne
	private Servidor servidorResponsavel;
	@JoinColumn(name="setor_destino_fk")
	@OneToOne
	private Setor setorDestino;
	@JoinColumn(name="requerente_fk")
	@ManyToOne(targetEntity = Requerente.class)
	private Requerente requerente;
	@JoinColumn(name="estudante_fk")
	@ManyToOne(targetEntity = Estudante.class)
	private Estudante estudante;
	
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
	public String getTipoRequerimento() {
		return tipoRequerimento;
	}
	public void setTipoRequerimento(String tipoRequerimento) {
		this.tipoRequerimento = tipoRequerimento;
	}
	public String getDetalhamentoPedido() {
		return detalhamentoPedido;
	}
	public void setDetalhamentoPedido(String detalhamentoPedido) {
		this.detalhamentoPedido = detalhamentoPedido;
	}
	public String getDeferimento() {
		return deferimento;
	}
	public void setDeferimento(String deferimento) {
		this.deferimento = deferimento;
	}
	public Date getDataPrimeiroEncaminhamento() {
		return dataPrimeiroEncaminhamento;
	}
	public void setDataPrimeiroEncaminhamento(Date dataPrimeiroEncaminhamento) {
		this.dataPrimeiroEncaminhamento = dataPrimeiroEncaminhamento;
	}
	public Servidor getServidorResponsavel() {
		return servidorResponsavel;
	}
	public void setServidorResponsavel(Servidor servidorResponsavel) {
		this.servidorResponsavel = servidorResponsavel;
	}
	public Setor getSetorDestino() {
		return setorDestino;
	}
	public void setSetorDestino(Setor setorDestino) {
		this.setorDestino = setorDestino;
	}
	public Requerente getRequerente() {
		return requerente;
	}
	public void setRequerente(Requerente requerente) {
		this.requerente = requerente;
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	

}
