
package br.edu.ifms.requerimentos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso{
	
	@Id
	@Column(name = "curso_id")
    private Integer id;
	@Column(name = "curso")
    private String nome;
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

}
