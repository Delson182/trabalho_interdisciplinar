package br.edu.ifms.requerimentos.util;

public class TipoRequerimento {
	
public String verificaTipo(boolean cancelMa, boolean cancelUni, boolean hist, boolean certiQuali,
		boolean conva, boolean declara, boolean desis, boolean enrProf, boolean exSuf,
		boolean matrUni, boolean mudaTurm, boolean mudaTurn, boolean tranc, boolean trasf,
		boolean segunCham, boolean outros){
	
	String tipoRequerimento = "";

	if(cancelMa){
		tipoRequerimento = tipoRequerimento + "CANCELAMENTO DE MATRÍCULA";
	}
	if(cancelUni){
		tipoRequerimento = tipoRequerimento + ", CANCELAMENTO DE UNIDADE CURRICULAR";
	}
	if(certiQuali){
		tipoRequerimento = tipoRequerimento + ", CERTIFICADO DE QUALIFICAÇÃO PROFISSIONAL";
	}
	if(conva){
		tipoRequerimento = tipoRequerimento + ", CONVALIDAÇÃO";
	}
	if(declara){
		tipoRequerimento = tipoRequerimento + ", DECLARAÇÃO";
			}
	if(desis){
		tipoRequerimento = tipoRequerimento + ", DESISTÊNCIA DE CURSO";
	}
	if(enrProf){
		tipoRequerimento = tipoRequerimento + ", ENREQUECIMENTO PROFISSIONAL";
	}
	if(exSuf){
		tipoRequerimento = tipoRequerimento + ", EXAME DE SUFICIÊNCIA";
	}
	if(hist){
		tipoRequerimento = tipoRequerimento + ", HISTÓRICO ESCOLAR";
	}
	if(matrUni){
		tipoRequerimento = tipoRequerimento + ", MATRÍCULA EM UNIDADE CURRICULAR";
			}
	if(mudaTurm){
		tipoRequerimento = tipoRequerimento + ", MUDANÇA DE TURMA";
	}
	if(mudaTurn){
		tipoRequerimento = tipoRequerimento + ", MUDANÇA DE TURNO";
	}
	if(tranc){
		tipoRequerimento = tipoRequerimento + ", TRANCAMENTO";
	}
	if(trasf){
		tipoRequerimento = tipoRequerimento + ", TRANSFERÊNCIA";
	}
	if(segunCham){
		tipoRequerimento = tipoRequerimento + ", SEGUNDA CHAMADA";
	}
	if(outros){
		tipoRequerimento = tipoRequerimento + ", OUTROS";
	}
	if(tipoRequerimento.length() > 0 && tipoRequerimento.charAt(0)==','){
		tipoRequerimento = tipoRequerimento.substring(2);
	}
	return tipoRequerimento;
}

}
