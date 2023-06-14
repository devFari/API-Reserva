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

import com.api.lab.models.Laboratorio;

import com.api.lab.repository.LaboratorioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
	
	@Autowired
	private LaboratorioRepository laboratorioRepostory;
	
	@GetMapping
	public List<Laboratorio> Listar () {
			return laboratorioRepostory.findAll();
	}
	
@GetMapping ("/{laboratorioID}")
public ResponseEntity<Laboratorio> buscar (@PathVariable Long laboratorioID) {	
	Optional<Laboratorio> laboratorio= laboratorioRepostory.findById(laboratorioID);
	
	if (laboratorio.isPresent() ) {
		return ResponseEntity.ok(laboratorio.get());
	}
	
	return ResponseEntity.notFound().build();
}


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Laboratorio adicionar(@RequestBody Laboratorio laboratorio) {
	return laboratorioRepostory.save(laboratorio);
}



	@PutMapping("/{laboratorioID}")
	public ResponseEntity<Laboratorio> atualizar(@PathVariable Long laboratorioID,
			@RequestBody Laboratorio laboratorio) {
		if (!laboratorioRepostory.existsById(laboratorioID)) {
			return ResponseEntity.notFound().build();
		}
		
			laboratorio.setCod_laboratorio(laboratorioID);
			laboratorio=laboratorioRepostory.save(laboratorio);
			
			return ResponseEntity.ok(laboratorio);
				
	}

	@DeleteMapping("/{laboratorioID}")
	public ResponseEntity<Void> remover(@PathVariable Long laboratorioID){
		if (!laboratorioRepostory.existsById(laboratorioID)) {
			return ResponseEntity.notFound().build();
	}
	laboratorioRepostory.deleteById(laboratorioID);
	
	return ResponseEntity.noContent().build();
	
	}
	}


	