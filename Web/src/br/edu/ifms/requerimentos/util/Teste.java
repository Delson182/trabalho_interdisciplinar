package br.edu.ifms.requerimentos.util;

import java.util.List;

import br.edu.ifms.requerimentos.dao.TipoRequerimentoDAO;
import br.edu.ifms.requerimentos.model.TipoRequerimento;

public class Teste {

	public static void main(String[] args) {
		TipoRequerimentoDAO dao = new TipoRequerimentoDAO();
		List<TipoRequerimento> tabelaSetorServidors = dao.recuperaTodos();
		
		tabelaSetorServidors.stream().forEach(elem -> System.out.println(elem.getId()));
	}

}
