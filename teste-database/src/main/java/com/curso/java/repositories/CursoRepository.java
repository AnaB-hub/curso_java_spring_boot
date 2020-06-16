package com.curso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.java.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByNome(String nome);

	List<Curso> findByNomeContaining(String nome);
	
	List<Curso> findByNomeLike(String nome);
	
	List<Curso> findByNomeLikeIgnoreCase(String nome);
	
	@Query(value = "select c from Curso c")
	List<Curso> findAllQuery();
	
	@Query(value = "select nome_curso from curso_faculdade where area = 'Humanas'", nativeQuery = true)
	List<String> findByArea();

}
