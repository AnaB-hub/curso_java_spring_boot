package com.curso.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;
import com.curso.api.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> getCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso save(Curso curso) {
		curso.setId(0); //TODO id mockado, porém ao salvar, recebe id sequencial normalmente
		return cursoRepository.save(curso);
	}

	@Override
	public Curso findById(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElse(null);
	}

	@Override
	public List<Curso> findByNome(String valor) {
		return cursoRepository.findByNomeContaining(valor);
	}

	@Override
	public void update(Curso curso) {
		Optional<Curso> cursoAtual = cursoRepository.findById(curso.getId());
		Curso atual = cursoAtual.orElse(null);
		atual.setNome(curso.getNome());
		atual.setArea(curso.getArea());
		cursoRepository.save(atual);
		
	}
}
