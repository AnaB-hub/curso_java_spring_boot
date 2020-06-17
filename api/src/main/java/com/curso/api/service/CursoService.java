package com.curso.api.service;

import java.util.List;

import com.curso.api.entities.Curso;

public interface CursoService {
	
	public List<Curso> getCursos();
	
	public Curso save(Curso curso);
	
	public Curso findById(Integer id);

}
