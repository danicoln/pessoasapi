package br.com.attornatus.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.api.dto.input.PessoaInput;
import br.com.attornatus.api.dto.output.PessoaOutput;
import br.com.attornatus.domain.models.Pessoa;
import br.com.attornatus.domain.services.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PessoaOutput insert(@RequestBody @Valid PessoaInput input){
		final var pessoa = modelMapper.map(input, Pessoa.class);
		
		return modelMapper.map(pessoaService.insert(pessoa), PessoaOutput.class);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid PessoaInput input){
		final var pessoa = modelMapper.map(input, Pessoa.class);
		pessoaService.update(id, pessoa);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public PessoaOutput consultarPessoa(@PathVariable Long id){
		return modelMapper.map(pessoaService.findOrFail(id), PessoaOutput.class);
		
	}
	
	@GetMapping
	public List<PessoaOutput> listarPessoa(){
		return pessoaService.listarPessoas().stream().map(p -> modelMapper.map(p, PessoaOutput.class)).collect(Collectors.toList()); 
	}
	
}
