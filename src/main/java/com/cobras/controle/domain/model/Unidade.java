package com.cobras.controle.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Unidade {

	private Long id;
	private String nome;
	private String chave;
}
