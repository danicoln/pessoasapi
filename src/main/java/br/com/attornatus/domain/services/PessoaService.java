package br.com.attornatus.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.domain.models.Pessoa;
import br.com.attornatus.domain.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Transactional
	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void update(Long pessoaId, Pessoa pessoa) {
		findOrFail(pessoaId);
		pessoa.setId(pessoaId);
		pessoaRepository.save(pessoa);
	}

	public Pessoa findOrFail(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.orElseThrow(() -> new EntityNotFoundException("ID Inválido!"));
	}

	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}

}
