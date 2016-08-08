package br.edu.ifms.requerimentos.ws;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.edu.ifms.requerimentos.dao.EstudanteDAO;
import br.edu.ifms.requerimentos.dao.ParecerDAO;
import br.edu.ifms.requerimentos.dao.RequerimentoDAO;
import br.edu.ifms.requerimentos.dao.ServidorDAO;
import br.edu.ifms.requerimentos.model.Estudante;
import br.edu.ifms.requerimentos.model.Parecer;
import br.edu.ifms.requerimentos.model.Requerimento;
import br.edu.ifms.requerimentos.model.RequerimentoMobile;
import br.edu.ifms.requerimentos.model.Servidor;


public class RequerimentoWS {
	
		public String getRequerimentoMobile(String cpf){
			RequerimentoDAO reqDAO = new RequerimentoDAO();
			ParecerDAO parDAO = new ParecerDAO();
			List<RequerimentoMobile> requerimentoMobile = new ArrayList<>();
			List<Requerimento> requerimentos = reqDAO.buscaRequerimentoPorCpf(cpf);
			boolean[] tiposRequerimento = new boolean[16];
			for(Requerimento reque: requerimentos){
				RequerimentoMobile reqMob = new RequerimentoMobile();
				List<Parecer> listaParecer = parDAO.recuperaPeloRequerimentoId(reque.getId());
				reqMob.setProtocolo(reque.getProtocolo());
				reqMob.setStatus(reque.getDeferimento());
				reqMob.setDataCriacao(reque.getData().toString());
				List<String> pareceres = new ArrayList<>();
				for(Parecer par: listaParecer){
					pareceres.add(par.getObservacaoParecer());
				}
				tiposRequerimento[0] = reque.isTiporeq1();
				tiposRequerimento[1] = reque.isTiporeq2();
				tiposRequerimento[2] = reque.isTiporeq3();
				tiposRequerimento[3] = reque.isTiporeq4();
				tiposRequerimento[4] = reque.isTiporeq5();
				tiposRequerimento[5] = reque.isTiporeq6();
				tiposRequerimento[6] = reque.isTiporeq7();
				tiposRequerimento[7] = reque.isTiporeq8();
				tiposRequerimento[8] = reque.isTiporeq9();
				tiposRequerimento[9] = reque.isTiporeq10();
				tiposRequerimento[10] = reque.isTiporeq11();
				tiposRequerimento[11] = reque.isTiporeq12();
				tiposRequerimento[12] = reque.isTiporeq13();
				tiposRequerimento[13] = reque.isTiporeq14();
				tiposRequerimento[14] = reque.isTiporeq15();
				tiposRequerimento[15] = reque.isTiporeq16();
				reqMob.setTiposReq(tiposRequerimento);
				reqMob.setDetalhamento(pareceres);
				requerimentoMobile.add(reqMob);
			}
		Gson gson=new Gson();
		String json=gson.toJson(requerimentoMobile);
		return json;
	}
	
	public String verificaCpf(String cpf){
		EstudanteDAO estuDAO = new EstudanteDAO();
		Estudante estudante = new Estudante();
		estudante = estuDAO.recuperaPorCpf(cpf);
		boolean estudanteExiste;
		if(estudante == null){
			estudanteExiste = false;
		}else{
			estudanteExiste =true;
		}
		Gson gson=new Gson();
		String json=gson.toJson(estudanteExiste);	
		return json;
	}
	
	public String getTodosServidores(){
		ServidorDAO servDAO = new ServidorDAO();
		List<Servidor> servidoresRecuperados = servDAO.recuperaTodos();
		Gson gson=new Gson();
		String json=gson.toJson(servidoresRecuperados);	
		return json;
	}
	
	public String autenticaUsuario(String siape, String senha){
		ServidorDAO servDAO = new ServidorDAO();
		Servidor servidor = servDAO.autenticaUsuario(siape, senha);
		Gson gson=new Gson();
		String json=gson.toJson(servidor);	
		return json;
	}
	
	public String salvaServidor(String servidor){
		Gson gson=new Gson();
		Servidor servidorGson = gson.fromJson(servidor,Servidor.class);
		ServidorDAO servDAO = new ServidorDAO();
		boolean salvou = servDAO.salva(servidorGson);
		String json=gson.toJson(salvou);	
		return json;
	}

}

	