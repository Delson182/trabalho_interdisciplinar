package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Servidor {
	@Id
	@Column(name="servidor_id")
	private Integer id;
	private String siape;
	private String nome;
	@ManyToMany
	private List<Setor> setor;
	
	public String getSiape() {
		return siape;
	}
	public void setSiape(String siape) {
		this.siape = siape;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Setor> getSetor() {
		return setor;
	}
	public void setSetor(List<Setor> setor) {
		this.setor = setor;
	}

}
