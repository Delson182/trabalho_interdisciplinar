package br.edu.ifms.requerimento.business;

import java.util.List;

import br.edu.ifms.requerimentos.model.DescricaoTipoRequerimento;
import br.edu.ifms.requerimentos.model.Requerimento;

public class RequerimentoBO {
	
	public void salvaRequerimento(Requerimento requerimento, 
			List<DescricaoTipoRequerimento> listaTiposRequerimentos){
		listaTiposRequerimentos.stream().forEach(elem -> System.out.println(elem.toString()));
		
	}

}
