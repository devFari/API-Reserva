package com.api.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lab.models.Professor;
@Repository
public interface ProfessorRepositorio extends JpaRepository<Professor, Long> {
	List<Professor> findByNome(String nome);
	List<Professor> findByNomeContaining(String nome);
}
