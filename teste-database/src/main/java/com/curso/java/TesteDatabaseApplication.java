package com.curso.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.java.entities.Curso;
import com.curso.java.repositories.CursoRepository;

@SpringBootApplication
public class TesteDatabaseApplication implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Curso curso1 = new Curso(99, "ADS");
		Curso curso2 = new Curso(6, "AGRO");
		
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		
		List<Curso> cursos =  cursoRepository.findAll();
		cursos.forEach(curso -> System.out.println(curso));
		
		System.out.println("Qtde de registros: " + cursoRepository.count());
	}

}
