package com.curso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByNome(String nome);

	List<Curso> findByNomeContaining(String nome);
	
	List<Curso> findByNomeLike(String nome);

}
