package com.cobras.controle.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.dto.UnidadeConsultaDTO;
import com.cobras.controle.domain.model.dto.UnidadeDTO;
import com.cobras.controle.domain.model.dto.UnidadePesquisaDTO;

public interface CadastroUnidadeService {
	
	List<Unidade> buscar(UnidadePesquisaDTO unidade);
	
	List<Unidade> buscar(UnidadeConsultaDTO unidade);
	
	ResponseEntity<Unidade> buscarEntity(UnidadeConsultaDTO unidade);
	
	List<Unidade> buscar(Unidade unidade);
	
	Optional<Unidade> findById(Long id);
	
	public Unidade incluir(UnidadeDTO unidade);
	
	public void alterar(UnidadeDTO unidade);
	
	boolean existsById(Long id);
	
	List<Unidade> findAll();
	

}
