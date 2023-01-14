package br.com.attornatus.pessoasapi.dto;

import java.time.LocalDate;

import br.com.attornatus.pessoasapi.entities.Endereco;

public class PessoaDto {

	private Long id;
	private String nome;
	private LocalDate dataNasc;
	private Endereco endereco;
	
	public PessoaDto(Long id, String nome, LocalDate dataNasc, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
	}

	public PessoaDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
