package com.curso.api.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true)
	private Integer id;

	private String nome;

	@ManyToMany
	@JoinTable(name = "grade_materia", 
			   joinColumns = {
					   @JoinColumn(name = "materia_id", referencedColumnName = "id")
			   }, 
			   inverseJoinColumns = {
					@JoinColumn(name = "grade_id", referencedColumnName = "id") 
			   })
	private Set<Grade> grades = new HashSet<Grade>();
	
	public Materia() {}

	public Materia(String nome, Set<Grade> grades) {
		super();
		this.nome = nome;
		this.grades = grades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
