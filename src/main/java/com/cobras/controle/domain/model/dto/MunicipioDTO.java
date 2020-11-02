package com.cobras.controle.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MunicipioDTO {

	private Long id;
	
	private String codigo;
	
	private String codigoCompleto;
	
	private String nome;

	public MunicipioDTO(Long id, String codigo, String codigoCompleto, String nome) {
		this.id = id;
		this.codigo = codigo;
		this.codigoCompleto = codigoCompleto;
		this.nome = nome;
	}
	
	
}
