package com.curso.java;

import java.util.List;
import java.util.Optional;

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
		Curso curso3 = new Curso(9, "LETRAS");
		Curso curso4 = new Curso(66, "BLA");
		Curso curso5 = new Curso(60, "LALALA");
		
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);
		
		curso2.setId(2); //TODO Verificar o motivo de não estar permitindo salvar sem o ID
		curso2.setNome("AGRONEGÓCIO");
		cursoRepository.save(curso2);
		
		List<Curso> cursos =  cursoRepository.findAll();
		cursos.forEach(curso -> System.out.println(curso));
		
		System.out.println("Qtde de registros: " + cursoRepository.count());
		
		cursoRepository.deleteById(3);
		cursoRepository.delete(curso2); //Exclusão pela entidade
		
		System.out.println("Qtde de registros após a exclusão: " + cursoRepository.count());
		
		Optional<Curso> byId = cursoRepository.findById(5);
		Curso byIdFinal = byId.orElse(null);
		System.out.println("Curso de ID 5: " + byIdFinal);
		
	}

}
