package com.cobras.controle.domain.model.dto;

import lombok.Getter;

@Getter
public class EstadoDTO {

	private Long id;
	
	private String codigo;
	
	private String nome;
	
    private String sigla;

	public EstadoDTO(Long id, String codigo, String nome, String sigla) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}
}
