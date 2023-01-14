package br.com.attornatus.pessoasapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.pessoasapi.entities.Endereco;
import br.com.attornatus.pessoasapi.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	@Transactional
	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Optional<Endereco> buscarPorId(Long id) {
		return enderecoRepository.findById(id);
	}
	
}
