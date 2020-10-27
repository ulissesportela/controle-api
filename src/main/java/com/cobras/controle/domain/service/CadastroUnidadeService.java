package com.cobras.controle.domain.service;

import java.util.List;

import com.cobras.controle.domain.model.vo.UnidadeVO;

public interface CadastroUnidadeService {

	public UnidadeVO incluir(UnidadeVO unidade);
	
	public UnidadeVO alterar(UnidadeVO unidade);
	
	public UnidadeVO findById(Long id);
	
	public List<UnidadeVO> findAll();
	
	public boolean existsById(Long id);
}
