package br.com.attornatus.pessoasapi.dto;

public class EnderecoDto {
	
	private Long id;
	private String Logradouro;
	private String cep;
	private String numero;
	private String cidade;
	
	public EnderecoDto(Long id, String logradouro, String cep, String numero, String cidade) {
		this.id = id;
		Logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
	}

	public EnderecoDto() {
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
