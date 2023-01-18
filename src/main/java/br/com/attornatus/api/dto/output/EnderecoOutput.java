package br.com.attornatus.api.dto.output;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EnderecoOutput {

	private Long id;
	private String Logradouro;
	private String cep;
	private String numero;
	private String cidade;

	private Boolean principal;

	@JsonIgnore
	private PessoaOutput pessoa;

	public PessoaOutput getPessoa() {
		return pessoa;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public void setPessoa(PessoaOutput pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
