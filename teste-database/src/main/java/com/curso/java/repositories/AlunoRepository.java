package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
