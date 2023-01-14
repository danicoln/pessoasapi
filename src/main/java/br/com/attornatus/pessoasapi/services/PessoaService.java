package br.com.attornatus.pessoasapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.pessoasapi.dto.PessoaDto;
import br.com.attornatus.pessoasapi.entities.Pessoa;
import br.com.attornatus.pessoasapi.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	
	public Pessoa criarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	@Transactional
	public void editarPessoa(Pessoa pessoa, PessoaDto pessoaDto) {
		if(pessoaDto.getNome() != null) {
			pessoa.setNome(pessoaDto.getNome());
			criarPessoa(pessoa);
		}
		
		if(pessoaDto.getDataNasc() != null) {
			pessoa.setDataNasc(pessoaDto.getDataNasc());
			criarPessoa(pessoa);
		}
	}
	
	public Pessoa consultarPessoa(Long id) {
		Optional<Pessoa> pessoa =  pessoaRepository.findById(id);
		return pessoa.orElseThrow(() -> new EntityNotFoundException("ID Inválido!"));
	}
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}
	
}
