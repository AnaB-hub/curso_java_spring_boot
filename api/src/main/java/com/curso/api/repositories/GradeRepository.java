package com.curso.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.api.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

}
