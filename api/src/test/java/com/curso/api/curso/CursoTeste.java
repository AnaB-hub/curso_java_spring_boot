package com.curso.api.curso;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

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
	void antesDoCadastro() {
		System.out.println("Testando um dos métodos");
		c = new Curso(); // Ao criar aqui, evita repetição de código
	}

	@Test
	void test() {
//		fail("Not yet implemented");
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
