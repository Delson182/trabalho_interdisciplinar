package br.edu.ifms.requerimentos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula{
	
	@Id
	@Column(name = "matricula_id")
    private Integer id; 
    private String matricula;
    private String periodo;
    private String turma;
    @JoinColumn(name = "curso_fk")
    @ManyToOne
    private Curso curso;
    
	public Integer getId() {
		return id;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getPeriodo() {
		return periodo;
	}
	public String getTurma() {
		return turma;
	}
	public Curso getCurso() {
		return curso;
	}

}
