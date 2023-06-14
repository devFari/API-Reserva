package com.api.lab.models;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
//import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;


 

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Laboratorio {
	
	

	@Column(name="nome_Laboratorio")
	private String nome;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codLaboratorio;
	

	
	
	
	//getters setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCod_laboratorio() {
		return codLaboratorio;
	}

	public void setCod_laboratorio(Long codLaboratorio) {
		this.codLaboratorio = codLaboratorio;
	}


	
	 

}




