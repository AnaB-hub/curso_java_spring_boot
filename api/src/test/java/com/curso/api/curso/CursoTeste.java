package com.curso.api.curso;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.curso.api.entities.Curso;

@TestInstance(Lifecycle.PER_CLASS)
class CursoTeste {
	
	Curso c;

	@BeforeAll
	void iniciando() {
		System.out.println("Iniciando a classe de teste");
	}

	@BeforeEach // será executado antes de cada método de teste
	void antesDeCadaUm() {
		System.out.println("Testando um dos métodos");
		c = new Curso(); // Ao criar aqui, evita repetição de código
	}
	
	@AfterAll
	void finalizando() {
		System.out.println("Finalizando a classe de teste");
	}
	
	@AfterEach
	void depoisDeCadaUm() {
		System.out.println("Nome do curso: " + c.getNome());
	}

	@Test
	void testaSetaNome() {
		c.setNome("Curso de teste");
		assertNotNull(c.getNome());
	}

	@Test
	void testaCursoNaoVazio() {
		assertNotNull(c); // Verifica se não é null
	}

	@Test
	void valorCursoNaoNulo() {
		assertNotNull(c.getValorCurso());
	}

	@Test
	void testeNovoCursoValorZero() {
		Assertions.assertEquals(new BigDecimal(0), c.getValorCurso());
	}

	@Test
	void testaNovoCursoSemAlunos() {
		assertTrue(c.getAlunos().isEmpty());
	}

}
