package br.edu.ifms.requerimentos.util;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifms.requerimentos.dao.MatriculaDAO;
import br.edu.ifms.requerimentos.model.Matricula;

public class t {

	public static void main(String[] args) {
		
		MatriculaDAO matriDAO = new MatriculaDAO();
		List<String> listaMatriculas = new ArrayList<String>();
		List<Matricula> matriculas = matriDAO.recuperaPorNome("ADELSON FLORINDO DOS SANTOS");
		System.out.println(matriculas.get(1).getMatricula());
		matriculas.stream().forEach(elem -> System.out.println(elem.getEstudante().getCelular()));
		listaMatriculas.stream().forEach(nome -> System.out.println(nome));
		
	}

}
