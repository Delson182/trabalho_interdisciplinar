package br.edu.ifms.requerimentos.util;

import java.util.List;
import br.edu.ifms.requerimentos.dao.RequerimentoDAO;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.ws.RequerimentoWS;

public class jutsu {

	public static void main(String[] args) {
		RequerimentoDAO req = new RequerimentoDAO();
		RequerimentoWS rws = new RequerimentoWS();
		System.out.println(rws.getRequerimentoMobile("04223302132")); 
		System.out.println(rws.verificaCpf("04223302132"));
	
	}
 
}
