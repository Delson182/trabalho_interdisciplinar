package util;

import java.util.List;

import dao.RequerimentoDAO;
import model.Requerimento;

public class Teste {

	public static void main(String[] args) {
		RequerimentoDAO dao = new RequerimentoDAO();
		List<Requerimento> tabelaRequerimentos = dao.recuperaTodos();
		tabelaRequerimentos.stream().forEach(elem -> System.out.println("element " + elem.getEstudante().getNome()));
	}

}
