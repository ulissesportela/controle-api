package com.cobras.controle.domain.model.dto;

import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.TipoUnidadeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeDTO {

	private Long unidadeId;

	private String codigo;
	
	private String ativo;
	
	private String responsavel;
	
	private String nome;
	
	private String email;
	
	private String justificativa;

	private String telefone;
	
	private TipoUnidadeEnum tipo;
	
	private Municipio cidade;
	
}
