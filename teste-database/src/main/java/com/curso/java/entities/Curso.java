package com.curso.java.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "curso_faculdade")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true)
	private Integer id;

	@Column(name = "nome_curso")
	private String nome;

	private String area;

	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;

	@NotNull(message = "Não pode ser null")
	@NotBlank(message = "Não pode ser vazio")
	private String usuario;

	// Campos que não precisam ser salvos no BD
	@Transient
	private BigDecimal valorCurso;

	@PostPersist
	private void aposPersistirDados() {
		this.nome = this.nome + " POST";
	}

	@PrePersist
	private void antesPersistirDados() {
		this.usuario = "ADMIN";
	}

	public Curso() {
	}

	public Curso(String nome) {
		this.nome = nome;
	}

	public Curso(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Curso(Integer id, String nome, String area) {
		super();
		this.id = id;
		this.nome = nome;
		this.area = area;
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

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(BigDecimal valorCurso) {
		this.valorCurso = valorCurso;
	}

}
