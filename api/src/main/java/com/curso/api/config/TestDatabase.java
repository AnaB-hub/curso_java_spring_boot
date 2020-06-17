package com.curso.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;

@Component
@Profile(value = "test")
public class TestDatabase implements CommandLineRunner {
	
	/**
	 * Essa classe só será executada qdo o perfil for test
	 * */

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void run(String... args) throws Exception {
		Curso curso1 = new Curso("Graduação ADS", "Exatas");
		Curso curso2 = new Curso("AGRO Graduação", "Exatas");
		Curso curso3 = new Curso("LETRAS", "Humanas");
		Curso curso4 = new Curso("BLA graduação", "Humanas");
		Curso curso5 = new Curso("LALALA", "Humanas");
		Curso curso6 = new Curso("12312", "Humanas");

		// Cadastro
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);
		cursoRepository.save(curso6);
	}

}
