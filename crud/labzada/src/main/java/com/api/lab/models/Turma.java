package com.api.lab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;




@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Turma {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_turma;
	
	@NotBlank
	@Column(name= "curso")
	private String nome;

	@Column(name = "periodo_do_curso")
	private String periodo;
	
	@Column(name = "turno_da_turma")
	private String	turno;
	
	
	
	
	
//  get and seters
	
	
	
	 
	public Long getCod_turma() {
		return cod_turma;
	}
	public void setCod_turma(Long cod_turma) {
		this.cod_turma = cod_turma;
	}
	 
	 public String getCurso() {
		return nome;
	}
	public void setCurso(String nome) {
		this.nome = nome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;}
	
	

}

