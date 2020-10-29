package com.cobras.controle.domain.service;

import java.util.List;
import java.util.Optional;

import com.cobras.controle.domain.model.Unidade;

public interface CadastroUnidadeService {

	List<Unidade> findByNomeContaining(String nome);

	Unidade findByCodigo(String codigo);

	Unidade findByEmail(String email);
	
	List<Unidade> findAll();
	
	Optional<Unidade> findById(Long id);
	
	boolean existsById(Long id);

	List<Unidade> findAllPesquisa(String codigo, String nome,
			String responsavel);

	List<Unidade> findByCodigoAndNomeAndResponsavel(String codigo, 
			String nome, String responsavel
			);

	Optional<Unidade> findByCodigoAndNome(String codigo, String nome);

	List<Unidade> findByCodigoAndNomeAndResponsavelAndAtivo(String codigo, 
			String nome, String responsavel,
			 char ativo);

	public Unidade incluir(Unidade unidade);

	public Unidade alterar(Unidade unidade);

}
