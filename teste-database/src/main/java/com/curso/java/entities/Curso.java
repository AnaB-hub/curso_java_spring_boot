package com.curso.java.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	private Integer id;
	private String nome;

	public Curso() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
