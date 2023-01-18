package br.com.attornatus.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.domain.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
