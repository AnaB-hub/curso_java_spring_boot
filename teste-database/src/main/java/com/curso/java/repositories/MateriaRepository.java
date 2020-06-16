package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer>{

}
