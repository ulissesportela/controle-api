package com.cobras.controle.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Usuario {

	private Long id;
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String telefone;
	
}
