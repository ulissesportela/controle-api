package com.cobras.controle.domain.model.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MunicipioDTO {

	private Long id;
	
	private String codigo;
	
	private String codigoCompleto;
	
	private String nome;
	
	private Long idEstado;
	
	private String codigoEstado;
	
	private String nomeEstado;
	
    private String siglaEstado;

	public MunicipioDTO(Long id, String codigo, String codigoCompleto, String nome, Long idEstado, String codigoEstado,
			String nomeEstado, String siglaEstado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.codigoCompleto = codigoCompleto;
		this.nome = nome;
		this.idEstado = idEstado;
		this.codigoEstado = codigoEstado;
		this.nomeEstado = nomeEstado;
		this.siglaEstado = siglaEstado;
	}

	
	
	
	
}
