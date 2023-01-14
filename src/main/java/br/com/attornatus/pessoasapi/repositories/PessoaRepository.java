package br.com.attornatus.pessoasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.pessoasapi.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
