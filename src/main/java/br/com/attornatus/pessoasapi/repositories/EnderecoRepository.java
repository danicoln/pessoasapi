package br.com.attornatus.pessoasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.pessoasapi.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
