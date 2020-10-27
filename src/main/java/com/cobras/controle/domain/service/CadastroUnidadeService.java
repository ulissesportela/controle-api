package com.cobras.controle.domain.service;

import com.cobras.controle.domain.model.Unidade;

public interface CadastroUnidadeService {
	
	public Unidade incluir(Unidade unidade);
	
	public Unidade alterar(Unidade unidade);
	
	public void excluir(Long unidadeId);
}
