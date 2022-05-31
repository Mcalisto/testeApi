package com.example.demo.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Cadastro")
public class Cadastro{
	

	@GeneratedValue
	@Id
	private int ID;
	
	@Column(name = "nome")
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dtNascimento")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date dtNascimento;
	
	

	@Column(name = "naturalidade")
	private String naturalidade;
	
	@Column(name = "nacionalidade")
	private String nacionalidade;
	
	@Column(name = "cpf")
	@NotBlank(message = "CPF é obrigatorio")
	private String cpf;
	
	@CreatedDate
	@Column(name = "createdOn", nullable = false, updatable = false)
    private LocalDate createdOn = LocalDate.now();

    @LastModifiedDate
    @Column(name = "updatedOn", nullable = false, updatable = true)
    private LocalDate updatedOn;
	
	public Cadastro() {}
	
	public Cadastro(String nome, String sexo, String email, Date dtNascimento, String naturalidade, String nacionalidade, String cpf) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	

}
