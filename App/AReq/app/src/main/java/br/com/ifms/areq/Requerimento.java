package br.com.ifms.areq;

import java.io.Serializable;

public class Requerimento implements Serializable {
    private String requerimento;
    private String dataCriacao;
    private String tipoReq;
    private String detalhamento;
    private String status;

    public Requerimento(String requerimento, String dataCriacao, String tipoReq, String detalhamento, String status) {
        this.requerimento = requerimento;
        this.dataCriacao = dataCriacao;
        this.tipoReq = tipoReq;
        this.detalhamento = detalhamento;
        this.status = status;
    }

    public String getRequerimento() {
        return requerimento;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getTipoReq() {
        return tipoReq;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return requerimento+" / "+tipoReq;
    }
}