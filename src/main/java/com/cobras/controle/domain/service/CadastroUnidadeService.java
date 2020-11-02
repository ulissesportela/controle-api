package com.cobras.controle.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cobras.controle.domain.model.Unidade;

public interface CadastroUnidadeService {

	List<Unidade> findByNomeContaining(String nome);

	Unidade findByCodigo(String codigo);

	Unidade findByEmail(String email);
	
	List<Unidade> findAll();
	
	Optional<Unidade> findById(Long id);
	
	boolean existsById(Long id);

	List<Unidade> findByCodigoAndNomeAndResponsavel(String codigo, 
			String nome, String responsavel
			);

	Optional<Unidade> findByCodigoAndNome(String codigo, String nome);

	List<Unidade> findByCodigoAndNomeAndResponsavelAndAtivo(String codigo, 
			String nome, String responsavel, char ativo);

	public Unidade incluir(Unidade unidade);

	public Unidade alterar(Unidade unidade);
	
	Page<Unidade> findAll(Pageable pageable);
	
	Page<Unidade> buscar(Unidade unidade);

	List<Unidade> findByListaParametros(@Param("codigo") String codigo, 
			@Param("nome") String nome, @Param("responsavel")  String responsavel,
			@Param("ativo") char ativo, @Param("cidade") Long cidade, @Param("tipo") Integer tipo, Long estadoId);

	Page<Unidade> buscar(Unidade unidade, Pageable page);

	
	//List<Unidade> buscar(Unidade unidade);

}
