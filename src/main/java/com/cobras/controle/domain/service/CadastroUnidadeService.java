package com.cobras.controle.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.UnidadeRepository;

@Service
public class CadastroUnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public Unidade Incluir(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(Long.valueOf(unidade.getCodigo()));
		
		if (unidadeExistente != null && !unidadeExistente.equals(unidade)) {
			
		}
		
		return unidadeRepository.save(unidade);
	}
	
	public void excluir(Long unidadeId) {
		unidadeRepository.deleteById(unidadeId);
	}
}
