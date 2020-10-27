package com.cobras.controle.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.exception.NegocioException;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

@Service
public class CadastroUnidadeServiceImpl implements CadastroUnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Override
	public Unidade incluir(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		
		if (unidadeExistente != null) {
			throw new NegocioException("Ja existe uma unidade cadastrada com esse codigo");
		}
		
		return unidadeRepository.save(unidade);
	}
	
	@Override
	public Unidade alterar(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		if (unidadeExistente != null && !unidadeExistente.getId().equals(unidade.getId())) {
			throw new NegocioException("Ja existe uma unidade cadastrada com esse codigo");
		}
		return unidadeRepository.save(unidade);
	}
	
	@Override
	public Optional<Unidade> findById(Long id) {
		return unidadeRepository.findById(id);
	}

	@Override
	public List<Unidade> findAll() {
		return unidadeRepository.findAll();
	}

	@Override
	public boolean existsById(Long id) {
		return unidadeRepository.existsById(id);
	}
}
