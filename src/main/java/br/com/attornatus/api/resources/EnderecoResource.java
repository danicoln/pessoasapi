package br.com.attornatus.api.resources;

import java.util.List;

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

import br.com.attornatus.api.dto.input.EnderecoInput;
import br.com.attornatus.api.dto.output.EnderecoOutput;
import br.com.attornatus.domain.models.Endereco;
import br.com.attornatus.domain.services.EnderecoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EnderecoOutput insert(@RequestBody @Valid EnderecoInput input){
		final var endereco = modelMapper.map(input, Endereco.class);
		
		return modelMapper.map(enderecoService.insert(endereco), EnderecoOutput.class);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid EnderecoInput input){
		final var endereco = modelMapper.map(input, Endereco.class);
		enderecoService.update(id, endereco);
		
		return ResponseEntity.ok().build();
	}

	@GetMapping("/pessoa-id/{id}")
	public ResponseEntity<List<Endereco>> buscarEndereco(@PathVariable Long id){
		return ResponseEntity.ok().body(enderecoService.buscarPeloIdPessoa(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listarTodosEnderecos(){
		return ResponseEntity.ok().body(enderecoService.buscarTodosEnderecos());
	}
	
	@GetMapping("/pessoa-id/{id}/principal")
	public ResponseEntity<List<Endereco>> buscarEnderecoPrincipal(@PathVariable Long id){
		return ResponseEntity.ok().body(enderecoService.buscarUltimoEnderecoPeloIdPessoa(id));
	}
	
}
