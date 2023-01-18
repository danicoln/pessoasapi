package br.com.attornatus.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.domain.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByPessoaId(Long id);

	List<Endereco> findByPessoaIdAndPrincipal(Long id, Integer b);

}
