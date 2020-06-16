package com.curso.java;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.java.entities.Aluno;
import com.curso.java.entities.Curso;
import com.curso.java.entities.Grade;
import com.curso.java.repositories.AlunoRepository;
import com.curso.java.repositories.CursoRepository;
import com.curso.java.repositories.GradeRepository;

@SpringBootApplication
public class TesteDatabaseApplication implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private GradeRepository gradeRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Curso curso1 = new Curso(1, "Graduação ADS", "Exatas");
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
		
		// Teste de data de atualização
//		Thread.sleep(3000);
//		Optional<Curso> cursoAlterar = cursoRepository.findById(5);
//		Curso cursoAlterarFinal = cursoAlterar.orElse(null);
//		cursoAlterarFinal.setNome("TESTE ALTERAÇÃO");
//		cursoRepository.save(cursoAlterarFinal);

		// Alteração
//		curso2.setId(2); // TODO Verificar o motivo de não estar permitindo salvar sem o ID
//		curso2.setNome("AGRONEGÓCIO");
//		cursoRepository.save(curso2);

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
//		List<Curso> cursosByQuery = cursoRepository.findAllQuery();
//		System.out.println("FindAll by query ");
//		cursosByQuery.forEach(curso -> System.out.println(curso));

		// Find by area fixa query nativa
//		List<String> cursosByAreaQuery = cursoRepository.findByArea();
//		System.out.println("Curso by area query nativa");
//		cursosByAreaQuery.forEach(curso -> System.out.println(curso));

		// Find by area por paramentro - query nativa
//		List<String> cursosByAreaInformadaQuery = cursoRepository.findByAreaInformada("Exatas");
//		System.out.println("Curso by area informada query nativa");
//		cursosByAreaInformadaQuery.forEach(curso -> System.out.println(curso));

		// Find by area e nome - query nativa
//		List<String> cursosByAreaECursoQuery = cursoRepository.findByAreaECurso("Exatas", "Graduação ADS");
//		System.out.println("Curso by area e curso query nativa");
//		cursosByAreaECursoQuery.forEach(curso -> System.out.println(curso));

		// Find by area e nome - query nativa ?
//		List<String> cursosByAreaParamentrosQuery = cursoRepository.findByAreaParametros("Humanas", "LETRAS");
//		System.out.println("Curso by area e curso query nativa usando ?");
//		cursosByAreaParamentrosQuery.forEach(curso -> System.out.println(curso));
		
		//ADICIONA DADOS PARA TESTE DE OneToMany e ManyToOne
		Aluno aluno1 = new Aluno("Ana", curso1);
		Aluno aluno2 = new Aluno("Ana2", curso1);
		alunoRepository.save(aluno1);
		alunoRepository.save(aluno2);
		
		//ADICIONA DADOS PARA TESTE DE OneToOne
		Grade grade1 = new Grade("Teste 1", aluno1);
		Grade grade2 = new Grade("Teste 2", aluno2);
		gradeRepository.save(grade1);
		gradeRepository.save(grade2);
	}

}
