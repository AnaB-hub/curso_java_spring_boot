package com.curso.java.udemy.Curso.java.spring.boot;

public class Curso implements Runnable {

	public String mostraDados() {
		Aluno alunoA = new Aluno();
		System.out.println(alunoA.getNotaDoAluno(10, 1));
		
		Aluno alunoB = new Aluno();
		System.out.println(alunoB.getNotaDoAluno(10, 0));
		
		String valor = "Olá";
		return valor;
	}

	//Acrescentado apenas para ver a utilização do TO_DO
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
