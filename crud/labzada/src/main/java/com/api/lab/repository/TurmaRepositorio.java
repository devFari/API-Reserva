package com.api.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lab.models.Laboratorio;
import com.api.lab.models.Turma;
@Repository
public interface TurmaRepositorio extends JpaRepository<Turma, Long> {
	List<Laboratorio> findByNome(String nome);
	List<Laboratorio> findByNomeContaining(String nome);
	
}
