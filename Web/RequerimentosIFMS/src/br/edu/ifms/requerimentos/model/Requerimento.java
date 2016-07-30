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
public class Requerimento {
	@Id
	@Column(name = "requerimento_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String protocolo;
	@Column(name = "data_criacao")
	private Date data;
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
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Requerente requerente;
	@JoinColumn(name="matricula_fk")
	@OneToOne
	private Matricula matricula;
	private boolean tiporeq1;
	private boolean tiporeq2;
	private boolean tiporeq3;
	private boolean tiporeq4;
	private boolean tiporeq5;
	private boolean tiporeq6;
	private boolean tiporeq7;
	private boolean tiporeq8;
	private boolean tiporeq9;
	private boolean tiporeq10;
	private boolean tiporeq11;
	private boolean tiporeq12;
	private boolean tiporeq13;
	private boolean tiporeq14;
	private boolean tiporeq15;
	private boolean tiporeq16;
	
	
	
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
	public boolean isTiporeq1() {
		return tiporeq1;
	}
	public void setTiporeq1(boolean tiporeq1) {
		this.tiporeq1 = tiporeq1;
	}
	public boolean isTiporeq2() {
		return tiporeq2;
	}
	public void setTiporeq2(boolean tiporeq2) {
		this.tiporeq2 = tiporeq2;
	}
	public boolean isTiporeq3() {
		return tiporeq3;
	}
	public void setTiporeq3(boolean tiporeq3) {
		this.tiporeq3 = tiporeq3;
	}
	public boolean isTiporeq4() {
		return tiporeq4;
	}
	public void setTiporeq4(boolean tiporeq4) {
		this.tiporeq4 = tiporeq4;
	}
	public boolean isTiporeq5() {
		return tiporeq5;
	}
	public void setTiporeq5(boolean tiporeq5) {
		this.tiporeq5 = tiporeq5;
	}
	public boolean isTiporeq6() {
		return tiporeq6;
	}
	public void setTiporeq6(boolean tiporeq6) {
		this.tiporeq6 = tiporeq6;
	}
	public boolean isTiporeq7() {
		return tiporeq7;
	}
	public void setTiporeq7(boolean tiporeq7) {
		this.tiporeq7 = tiporeq7;
	}
	public boolean isTiporeq8() {
		return tiporeq8;
	}
	public void setTiporeq8(boolean tiporeq8) {
		this.tiporeq8 = tiporeq8;
	}
	public boolean isTiporeq9() {
		return tiporeq9;
	}
	public void setTiporeq9(boolean tiporeq9) {
		this.tiporeq9 = tiporeq9;
	}
	public boolean isTiporeq10() {
		return tiporeq10;
	}
	public void setTiporeq10(boolean tiporeq10) {
		this.tiporeq10 = tiporeq10;
	}
	public boolean isTiporeq11() {
		return tiporeq11;
	}
	public void setTiporeq11(boolean tiporeq11) {
		this.tiporeq11 = tiporeq11;
	}
	public boolean isTiporeq12() {
		return tiporeq12;
	}
	public void setTiporeq12(boolean tiporeq12) {
		this.tiporeq12 = tiporeq12;
	}
	public boolean isTiporeq13() {
		return tiporeq13;
	}
	public void setTiporeq13(boolean tiporeq13) {
		this.tiporeq13 = tiporeq13;
	}
	public boolean isTiporeq14() {
		return tiporeq14;
	}
	public void setTiporeq14(boolean tiporeq14) {
		this.tiporeq14 = tiporeq14;
	}
	public boolean isTiporeq15() {
		return tiporeq15;
	}
	public void setTiporeq15(boolean tiporeq15) {
		this.tiporeq15 = tiporeq15;
	}
	public boolean isTiporeq16() {
		return tiporeq16;
	}
	public void setTiporeq16(boolean tiporeq16) {
		this.tiporeq16 = tiporeq16;
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
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
