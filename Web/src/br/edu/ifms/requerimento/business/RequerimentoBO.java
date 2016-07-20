package br.edu.ifms.requerimento.business;

import java.util.List;

import br.edu.ifms.requerimentos.model.DescricaoTipoRequerimento;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Matricula;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.model.Requerimento;

public class RequerimentoBO {

	public void salvaRequerimento(Requerimento requerimento, List<DescricaoTipoRequerimento> listaTiposRequerimentos,
			Estudante estudante, Requerente requerente, Parecer parecer, Matricula matricula) {
		
		listaTiposRequerimentos.stream().forEach(elem -> System.out.println(elem.toString()));
		System.out.println(requerimento.getRequerente().getNomerequerente());
		
	}

}
