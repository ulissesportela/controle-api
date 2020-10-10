package com.cobras.controle.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cobras.controle.domain.model.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	List<Unidade> findByNome(String nome);
	List<Unidade> findByNomeContaining(String nome);
	Unidade findByCodigo(Long codigo);
}
