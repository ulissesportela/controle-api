package com.cobras.controle.domain.model.vo;

import java.io.Serializable;
import com.cobras.controle.domain.model.TipoUnidade;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UnidadeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String codigo;

	private TipoUnidade tipo;
	
	private Long cidade;
	
	private String email;
	
	private String telefone;
	
	private char ativo;
	
	private String justificativa;
	
}
