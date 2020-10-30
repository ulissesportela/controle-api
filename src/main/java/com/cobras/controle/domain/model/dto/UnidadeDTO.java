package com.cobras.controle.domain.model.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.TipoUnidade;

public class UnidadeDTO {

	private Long unidadeId;

	private String codigo;
	
	private char ativo;
	
	private String responsavel;
	
	private String nome;
	
	private String email;
	
	private String justificativa;

	private String telefone;

	
	private TipoUnidade tipo;
	
	private Municipio municipio;
	
	private Estado estado;
}
