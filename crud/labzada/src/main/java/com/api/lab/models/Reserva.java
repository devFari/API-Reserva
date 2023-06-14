package com.api.lab.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.ArrayList;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;





@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Reserva {
	
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codReserva ;
 
	private String nome;
	
	
	@Column(name="turno_da_reserva")
	private String turnoRS;
	
	

	private LocalDateTime dataRerservada;
	LocalDate localDate3         = LocalDate.now().plusDays(1).plusMonths(1);
	LocalDateTime localDateTime3 = LocalDateTime.now().plusDays(1).plusMonths(1).plusHours(2);
	
	
	@ManyToOne
	private Turma turma;
	
	@ManyToOne
	private Professor professor;
	
	@ManyToOne
	private Laboratorio laboratorio;
	
	
	//ArrayList<Laboratorio> Laboratorios;
	
	//ArrayList<Professor> Professores;
	//ArrayList<Reserva> turmas;
		

	
	//Reserva reserva = new reserva();
	//reserva.setDataHoraCadastro(LocalDateTime.now());

	//reserva.save(reserva);
	
	//getters
/*public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
		
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}*/

	
	public Long getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(Long codReserva) {
		this.codReserva = codReserva;
	}
	public String getTurnoRS() {
		return turnoRS;
	}
	public void setTurnoRS(String turnoRS) {
		this.turnoRS = turnoRS;
	}

	
	public LocalDateTime getDataRerservada() {
		return dataRerservada;
	}
	public void setDataRerservada(LocalDateTime dataRerservada) {
		this.dataRerservada = dataRerservada;
	}
	public String getNomeReserva() {
		return nome;
	}
	public void setNomeReserva(String nomeReserva) {
		nome = nomeReserva;
	}
	
	
	
}
