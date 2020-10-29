package com.cobras.controle.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cobras.controle.domain.model.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	List<Unidade> findByNome(String nome);
	
	List<Unidade> findByNomeContaining(String nome);
	
	Unidade findByCodigo(String codigo);
	
	Unidade findByEmail(String email);
	
	@Query(value = "SELECT unidade FROM Unidade unidade INNER JOIN unidade.municipio mun"
			+ " WHERE 1=1 OR unidade.codigo = ?1 OR unidade.nome = ?2 "
			+ "OR unidade.responsavel =?3")
	List<Unidade> findAllPesquisa(String codigo, String nome, String responsavel);
	
	List<Unidade> findByCodigoAndNomeAndResponsavel(String codigo, String nome, 
			String responsavel);
	
	Optional<Unidade> findByCodigoAndNome(String codigo, String nome);

	List<Unidade> findByCodigoAndNomeAndResponsavelAndAtivo(String codigo, 
			String nome, String responsavel, char ativo);
	
	

}
