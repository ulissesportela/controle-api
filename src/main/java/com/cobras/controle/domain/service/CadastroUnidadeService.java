package com.cobras.controle.domain.service;

import java.util.List;
import java.util.Optional;

import com.cobras.controle.domain.model.Unidade;

public interface CadastroUnidadeService {

	public Unidade incluir(Unidade unidade);
	
	public Unidade alterar(Unidade unidade);
	
	public Optional<Unidade> findById(Long id);
	
	public List<Unidade> findAll();
	
	public boolean existsById(Long id);
}
