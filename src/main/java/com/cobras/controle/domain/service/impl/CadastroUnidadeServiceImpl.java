package com.cobras.controle.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.converter.DozerConverter;
import com.cobras.controle.domain.exception.NegocioException;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.vo.UnidadeVO;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

@Service
public class CadastroUnidadeServiceImpl implements CadastroUnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Override
	public UnidadeVO incluir(UnidadeVO unidade) {
		Unidade entidade = DozerConverter.parseObject(unidade, Unidade.class);
		return DozerConverter.parseObject(unidadeRepository.save(entidade), UnidadeVO.class);
	}
	
	@Override
	public UnidadeVO alterar(UnidadeVO unidade) {
		Unidade entidade = DozerConverter.parseObject(unidade, Unidade.class);
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		if (unidadeExistente != null && !unidadeExistente.getId().equals(unidade.getId())) {
			throw new NegocioException("Ja existe uma unidade cadastrada com esse codigo");
		}

		return DozerConverter.parseObject(unidadeRepository.save(entidade), UnidadeVO.class);
	}
	
	@Override
	public UnidadeVO findById(Long id) {
		var entidade = unidadeRepository.findById(id);
		return DozerConverter.parseObject(entidade, UnidadeVO.class);
		
	}

	@Override
	public List<UnidadeVO> findAll() {
		return DozerConverter.parseListObjects(unidadeRepository.findAll(), UnidadeVO.class);

	}

	@Override
	public boolean existsById(Long id) {
		return unidadeRepository.existsById(id);
	}


}
