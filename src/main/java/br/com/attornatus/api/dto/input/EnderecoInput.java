package br.com.attornatus.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoInput {

	@NotBlank
	private String Logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;

	private Boolean principal;

	@NotNull
	private PessoaIdInput pessoa;

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public PessoaIdInput getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaIdInput pessoa) {
		this.pessoa = pessoa;
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
