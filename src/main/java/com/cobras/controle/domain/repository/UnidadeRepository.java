package com.cobras.controle.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cobras.controle.domain.model.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>, 
		PagingAndSortingRepository<Unidade, Long> {

	Page<Unidade> findAll(Pageable pageable);

	List<Unidade> findByNome(String nome);

	List<Unidade> findByNomeContaining(String nome);

	Unidade findByCodigo(String codigo);
	
	Optional<Unidade> findByResponsavel(String responsavel);

	Unidade findByEmail(String email);

	List<Unidade> findByCodigoAndNomeAndResponsavel(String codigo, String nome, String responsavel);

	Optional<Unidade> findByCodigoAndNome(String codigo, String nome);

	List<Unidade> findByCodigoAndNomeAndResponsavelAndAtivo(String codigo, String nome, 
			String responsavel, char ativo);


	@Transactional
	@Modifying
	@Query("UPDATE Unidade u SET u.codigo = :codigo, u.ativo = :ativo,"
			+ "u.responsavel = :responsavel, u.nome = :nome,"
			+ "u.email = :email, u.justificativa = :justificativa"
			+ " WHERE u.id = :id")
	void updateUnidade(Long id, String codigo, String ativo, String responsavel, 
			String nome, String email, String justificativa);

	List<Unidade> findByAtivo(String responsavel);

	List<Unidade> findByAtivoAndNome(String ativo, String nome);



}
