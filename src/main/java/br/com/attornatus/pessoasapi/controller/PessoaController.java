package br.com.attornatus.pessoasapi.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.attornatus.pessoasapi.dto.PessoaDto;
import br.com.attornatus.pessoasapi.entities.Endereco;
import br.com.attornatus.pessoasapi.entities.Pessoa;
import br.com.attornatus.pessoasapi.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	private PessoaService pessoaService;
	

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@PostMapping
	public ResponseEntity<Void> adicionarPessoa(@RequestBody Pessoa pessoa){

		Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(novaPessoa.getId()).toUri();
				
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> editarPessoa(@PathVariable Long id, @RequestBody PessoaDto dto){
		Pessoa pessoa = pessoaService.consultarPessoa(id);
		pessoaService.editarPessoa(pessoa, dto);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id){
		return ResponseEntity.ok().body(pessoaService.consultarPessoa(id));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoa(){
		return ResponseEntity.ok().body(pessoaService.listarPessoas());
	}
	
	
	@GetMapping("/{id}/listar-endereco")
	public ResponseEntity<List<Endereco>> buscarEndereco(@PathVariable Long id){
		Pessoa pessoa = pessoaService.consultarPessoa(id);
		return ResponseEntity.ok().body(pessoa.getEndereco());
	}
	
	@GetMapping("/enderecos")
	public ResponseEntity<List<Endereco>> listarTodosEnderecos(){
		return ResponseEntity.ok().body(pessoaService.buscarTodosEnderecos());
	}
	
}
