package br.com.attornatus.api.dto.output;

import java.time.LocalDate;

public class PessoaOutput {

	private Long id;
	private String nome;
	private LocalDate dataNasc;

	private EnderecoOutput endereco;

	public EnderecoOutput getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoOutput endereco) {
		this.endereco = endereco;
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

}
