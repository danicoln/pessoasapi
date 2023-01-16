package br.com.attornatus.pessoasapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus.pessoasapi.dto.PessoaDto;
import br.com.attornatus.pessoasapi.entities.Endereco;
import br.com.attornatus.pessoasapi.entities.Pessoa;
import br.com.attornatus.pessoasapi.repositories.EnderecoRepository;
import br.com.attornatus.pessoasapi.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;

	public PessoaService(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
		this.pessoaRepository = pessoaRepository;
		this.enderecoRepository = enderecoRepository;
	}
	
	@Transactional
	public Pessoa criarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
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
	
	//criar um metodo que busca o endereco pelo cep
	@Transactional
	public Endereco adicionarEndereco(Pessoa pessoa, Endereco endereco) {
		criarPessoa(pessoa);
		
		pessoa.getEndereco().add(endereco);
		
		endereco.setPessoa(pessoa);
		
		return endereco;
	}
	
	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoService.salvarEndereco(endereco);
	}
	
	public List<Endereco> addEndereco(Endereco endereco){
		return enderecoService.addEndereco(endereco);
	}
	
	public List<Endereco> buscarTodosEnderecos(){
		return enderecoRepository.findAll();
	}
	
}
