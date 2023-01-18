package br.com.attornatus.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.domain.models.Endereco;
import br.com.attornatus.domain.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public Endereco insert(Endereco endereco) {
		validarEnderecoAtual(endereco);
		return enderecoRepository.save(endereco);
	}

	public void validarEnderecoAtual(Endereco endereco) {
		if (endereco.getPrincipal()) {
			final var enderecos = enderecoRepository.findByPessoaId(endereco.getPessoa().getId());
			enderecos.forEach(e -> {
				e.setPrincipal(false);
				enderecoRepository.save(e);
			});
		}
	}

	public void update(Long enderecoId, Endereco endereco) {
		findOrFail(enderecoId);
		endereco.setId(enderecoId);
		validarEnderecoAtual(endereco);
		enderecoRepository.save(endereco);
	}

	public List<Endereco> buscarTodosEnderecos() {
		return enderecoRepository.findAll();
	}

	public Endereco findOrFail(Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.orElseThrow(() -> new EntityNotFoundException("Id do endereço inválido!"));
	}

	public List<Endereco> buscarPeloIdPessoa(Long id) {
		return enderecoRepository.findByPessoaId(id);
	}

	public List<Endereco> buscarUltimoEnderecoPeloIdPessoa(Long id) {
		return enderecoRepository.findByPessoaIdAndPrincipal(id, 1);
	}

}
