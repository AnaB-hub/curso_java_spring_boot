package com.curso.java.udemy.Curso.java.spring.boot;

public class Aluno {

	public int getNotaDoAluno(int a, int b) {
		
		// TODO Remover após corrigir de forma correta para o cliente
		if (b == 0) {
			b = 1;
		}
		
		// FIXME Ajuste na divisão por zero
		int nota = a / b;
		
		// FIXME Retornar outro valor quando for divisão por zero
		return nota;
	}

}
