package com.cobras.controle.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {


	private Long id;
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String telefone;
}
