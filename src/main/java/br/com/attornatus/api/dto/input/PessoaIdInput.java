package br.com.attornatus.api.dto.input;

import jakarta.validation.constraints.NotNull;

public class PessoaIdInput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
