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
public class TesteDatabaseApplication implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Curso curso1 = new Curso(99, "Graduação ADS", "Exatas");
		Curso curso2 = new Curso(6, "AGRO Graduação", "Exatas");
		Curso curso3 = new Curso(9, "LETRAS", "Humanas");
		Curso curso4 = new Curso(66, "BLA graduação", "Humanas");
		Curso curso5 = new Curso(60, "LALALA", "Humanas");

		// Cadastro
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);

		// Alteração
		curso2.setId(2); // TODO Verificar o motivo de não estar permitindo salvar sem o ID
		curso2.setNome("AGRONEGÓCIO");
		cursoRepository.save(curso2);

		// Listagem
		List<Curso> cursos = cursoRepository.findAll();
		cursos.forEach(curso -> System.out.println(curso));
		System.out.println("Qtde de registros: " + cursoRepository.count());

		// Exclusão
//		cursoRepository.deleteById(3);
//		cursoRepository.delete(curso2); // Exclusão pela entidade
//		System.out.println("Qtde de registros após a exclusão: " + cursoRepository.count());

		// FindById
		Optional<Curso> byId = cursoRepository.findById(5);
		Curso byIdFinal = byId.orElse(null);
		System.out.println("Curso de ID 5: " + byIdFinal);

		// FindByNome
//		List<Curso> cursosByNome = cursoRepository.findByNome("ADS");
//		System.out.println("Curso by nome");
//		cursosByNome.forEach(curso -> System.out.println(curso));

		// FindByNome containing
//		List<Curso> cursosByNomeContaining = cursoRepository.findByNomeContaining("Graduação");
//		System.out.println("Curso by nome containing");
//		cursosByNomeContaining.forEach(curso -> System.out.println(curso));

		// FindByNome LIKE
//		List<Curso> cursosByNomeLike = cursoRepository.findByNomeLike("%Graduação%");// RETORNA QUEM TEM "Graduação" NO INÍCIO
//		System.out.println("Curso by nome LIKE");
//		cursosByNomeLike.forEach(curso -> System.out.println(curso));

		// FindByNome LIKE IGNORE CASE
//		List<Curso> cursosByNomeLike = cursoRepository.findByNomeLikeIgnoreCase("%Graduação%");// IGNORA MAIUSCULAS E MINUSCULAS
//		System.out.println("Curso by nome LIKE");
//		cursosByNomeLike.forEach(curso -> System.out.println(curso));

		// FindAll by query
		List<Curso> cursosByQuery = cursoRepository.findAllQuery();
		System.out.println("FindAll by query ");
		cursosByQuery.forEach(curso -> System.out.println(curso));

		// Find by area query nativa
		List<String> cursosByAreaQuery = cursoRepository.findByArea();
		System.out.println("Curso by query nome");
		cursosByAreaQuery.forEach(curso -> System.out.println(curso));

	}

}
