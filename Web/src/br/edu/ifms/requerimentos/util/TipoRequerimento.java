package br.edu.ifms.requerimentos.util;

public class TipoRequerimento {
	
public String verificaTipo(boolean cancelMa, boolean cancelUni, boolean hist, boolean certiQuali,
		boolean conva, boolean declara, boolean desis, boolean enrProf, boolean exSuf,
		boolean matrUni, boolean mudaTurm, boolean mudaTurn, boolean tranc, boolean trasf,
		boolean segunCham, boolean outros){
	
	String tipoRequerimento = "";

	if(cancelMa){
		tipoRequerimento = tipoRequerimento + "CANCELAMENTO DE MATR�CULA";
	}
	if(cancelUni){
		tipoRequerimento = tipoRequerimento + ", CANCELAMENTO DE UNIDADE CURRICULAR";
	}
	if(certiQuali){
		tipoRequerimento = tipoRequerimento + ", CERTIFICADO DE QUALIFICA��O PROFISSIONAL";
	}
	if(conva){
		tipoRequerimento = tipoRequerimento + ", CONVALIDA��O";
	}
	if(declara){
		tipoRequerimento = tipoRequerimento + ", DECLARA��O";
			}
	if(desis){
		tipoRequerimento = tipoRequerimento + ", DESIST�NCIA DE CURSO";
	}
	if(enrProf){
		tipoRequerimento = tipoRequerimento + ", ENREQUECIMENTO PROFISSIONAL";
	}
	if(exSuf){
		tipoRequerimento = tipoRequerimento + ", EXAME DE SUFICI�NCIA";
	}
	if(hist){
		tipoRequerimento = tipoRequerimento + ", HIST�RICO ESCOLAR";
	}
	if(matrUni){
		tipoRequerimento = tipoRequerimento + ", MATR�CULA EM UNIDADE CURRICULAR";
			}
	if(mudaTurm){
		tipoRequerimento = tipoRequerimento + ", MUDAN�A DE TURMA";
	}
	if(mudaTurn){
		tipoRequerimento = tipoRequerimento + ", MUDAN�A DE TURNO";
	}
	if(tranc){
		tipoRequerimento = tipoRequerimento + ", TRANCAMENTO";
	}
	if(trasf){
		tipoRequerimento = tipoRequerimento + ", TRANSFER�NCIA";
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
