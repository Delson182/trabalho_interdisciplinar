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
    private String turno;
    @JoinColumn(name = "curso_fk")
    @ManyToOne
    private Curso curso;
    
	public Matricula() {
		
	}
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
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
