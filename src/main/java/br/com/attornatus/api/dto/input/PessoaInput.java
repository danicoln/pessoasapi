package br.com.attornatus.api.dto.input;

import java.time.LocalDate;

import br.com.attornatus.domain.models.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaInput {

	@NotBlank
	private String nome;
	@NotNull
	private LocalDate dataNasc;

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
