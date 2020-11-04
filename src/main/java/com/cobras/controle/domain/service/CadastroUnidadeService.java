package com.cobras.controle.domain.service;

import java.util.List;
import java.util.Optional;

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.dto.UnidadePesquisaDTO;

public interface CadastroUnidadeService {
	
	List<Unidade> buscar(UnidadePesquisaDTO unidade);
	
	Optional<Unidade> findById(Long id);
	
	public Unidade incluir(Unidade unidade);
	
	public Unidade alterar(Unidade unidade);
	
	boolean existsById(Long id);
	
	List<Unidade> findAll();

}
