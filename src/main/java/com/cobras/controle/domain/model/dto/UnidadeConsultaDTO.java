package com.cobras.controle.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeConsultaDTO {

	private String codigo;
	
	private String ativo;
	
	private String nome;
	
	private String responsavel;

	private Long cidadeId;
	
	private Long estadoId;
}
