package com.curso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

}
