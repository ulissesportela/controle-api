package com.cobras.controle.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.exception.NegocioException;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

@Service
public class CadastroUnidadeServiceImpl implements CadastroUnidadeService{

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public Unidade incluir(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		
		if (unidadeExistente != null) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
		}
		
		return unidadeRepository.save(unidade);
	}
	
	public Unidade alterar(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		
		if (unidadeExistente != null && !unidadeExistente.getId().equals(unidade.getId())) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
		}
		
		return unidadeRepository.save(unidade);
	}
	
	public void excluir(Long unidadeId) {
		unidadeRepository.deleteById(unidadeId);
	}

	
}
