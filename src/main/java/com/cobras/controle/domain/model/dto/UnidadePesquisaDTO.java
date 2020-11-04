package com.cobras.controle.domain.model.dto;

import com.cobras.controle.domain.model.TipoUnidadeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadePesquisaDTO {

	private String codigo;
	
	private String ativo;
	
	private String nome;
	
	private String responsavel;
	
	private TipoUnidadeEnum tipo;
	
	private MunicipioPesquisaDTO cidade;
	
}
