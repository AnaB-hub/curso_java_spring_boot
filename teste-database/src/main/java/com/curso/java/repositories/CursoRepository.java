package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
