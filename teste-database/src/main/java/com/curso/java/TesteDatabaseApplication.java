package com.curso.java;

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
		Curso curso2 = new Curso(4, "AGRO");
		Curso curso1 = new Curso(67, "ADS");
		
		cursoRepository.save(curso2);
		cursoRepository.save(curso1);
	}

}
