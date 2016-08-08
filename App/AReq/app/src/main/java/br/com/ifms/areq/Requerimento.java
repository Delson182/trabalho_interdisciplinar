package br.com.ifms.areq;

import java.io.Serializable;
import java.util.List;

public class Requerimento implements Serializable {

    private String protocolo;
    private String dataCriacao;
    private boolean[] tipoReq;
    private List<String> detalhamento;
    private String status;
    private String[] tipos = {"Cancelamento de Matrícula", "Cancelamento de Unidade Curricular", "Certificado" +
            " de Qualificação Profissional", "Convalidação", "Declaração", "Desistência de Curso", "Enriqueci" +
            "mento Curricular", "Exame de Suficiência", "Histórico Escolar", "Matrícula em Unidade Curricular", 
            "Mudança de Turma", "Mudança de Turno", "Trancamento", "Transferência", "Segunda Chamada", "Outros"};

    public void setProtocolo(String protocolo){
        this.protocolo = protocolo;
    }

    public void setDataCriacao(String dataCriacao){
        this.dataCriacao = dataCriacao;
    }
    public void setTipoReq(boolean[] tipoReq){
        this.tipoReq = tipoReq;
    }
    public void setDetalhamento(List<String> detalhamento){
        this.detalhamento = detalhamento;
    }
    public void setStatus(String status){
        this.status = status;
    }


    public String getRequerimento() {
        return protocolo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    /*public String getTipoReq() {
        if(tipoReq[] = null) {
            for (int i = 0; i < tipoReq.length; i++) {
                if (tipoReq[i]) {
                    return tipos[i];
                }
            }
        }else{
            return "Não há";
        }
    }*/

    public String getDetalhamento() {
        String detalhes = "";
        for (String partes: detalhamento) {
            detalhes += partes+" ";
        }
        return detalhes;
    }

    public String getStatus() {
        if(status == null){
            return "Não há";
        } else {
            return status;
        }
    }

    @Override
    public String toString(){
        return "Protocolo Nº: "+ protocolo;
    }
}
