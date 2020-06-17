package com.curso.api.curso;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.curso.api.entities.Curso;

class CursoTeste {

	@Test
	void test() {
//		fail("Not yet implemented");
	}

	@Test
	void testaCursoNaoVazio() {
		Curso c = new Curso();
		assertNotNull(c); // Verifica se não é null
	}

	@Test
	void valorCursoNaoNulo() {
		Curso c = new Curso();
		assertNotNull(c.getValorCurso());
	}

	@Test
	void testeNovoCursoValorZero() {
		Curso c = new Curso();
		Assertions.assertEquals(new BigDecimal(0), c.getValorCurso());
	}

	@Test
	void testaNovoCursoSemAlunos() {
		Curso c = new Curso();
		assertTrue(c.getAlunos().isEmpty());
	}

}
