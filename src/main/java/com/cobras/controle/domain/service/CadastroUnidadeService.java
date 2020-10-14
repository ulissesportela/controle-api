package com.cobras.controle.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.exception.NegocioException;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.UnidadeRepository;

@Service
public class CadastroUnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public Unidade incluir(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		
		if (unidadeExistente != null && !unidadeExistente.equals(unidade)) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
		}
		
		return unidadeRepository.save(unidade);
	}
	
	public void excluir(Long unidadeId) {
		unidadeRepository.deleteById(unidadeId);
	}
}
