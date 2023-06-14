package com.api.lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.lab.models.Professor;


import com.api.lab.repository.ProfessorRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepositorio professorRepositorio;
	
	@GetMapping
	public List<Professor> Listar () {
			return professorRepositorio.findAll();
	}

	@GetMapping ("/{professorID}")
	public ResponseEntity<Professor> buscar (@PathVariable Long professorID) {	
		Optional<Professor> professor= professorRepositorio.findById(professorID);
		
		if (professor.isPresent() ) {
			return ResponseEntity.ok(professor.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Professor adicionar(@RequestBody Professor professor) {
		return professorRepositorio.save(professor);
	}
	
	@PutMapping("/{professorID}")
	public ResponseEntity<Professor> atualizar(@PathVariable Long professorID,
			@RequestBody Professor professor) {
		if (!professorRepositorio.existsById(professorID)) {
			return ResponseEntity.notFound().build();
		}
		
			professor.setMatricula(professorID);
			professor=professorRepositorio.save(professor);
			
			return ResponseEntity.ok(professor);
	}
	
	@DeleteMapping("/{professorID}")
	public ResponseEntity<Void> remover(@PathVariable Long professorID){
		if (!professorRepositorio.existsById(professorID)) {
			return ResponseEntity.notFound().build();
	}
	professorRepositorio.deleteById(professorID);
	
	return ResponseEntity.noContent().build();
	
	}
	
	
	
	
	
}
