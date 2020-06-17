package com.curso.api.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CursoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "O nome não pode ser null")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Size(max = 20, message = "O nome deve ter até 20 caracteres")
	@Size(min = 5, message = "O nome deve ter mais do que 5 caracteres")
	private String nome;

	@NotBlank(message = "Area não pode ser vazia e não pode ser um espaço apenas")
	private String area;

	public CursoDTO() {
	}

	public CursoDTO(Integer id, String nome, String area) {
		super();
		this.id = id;
		this.nome = nome;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
