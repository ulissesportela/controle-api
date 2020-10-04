package com.cobras.controle.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.Unidade;

@RestController
public class UnidadeController {

	@GetMapping("/unidades")
	public List<Unidade> listar() {
		
		var unidade1 = Unidade.builder().id(1L).nome("Guarulhos").build();
		var unidade2 = Unidade.builder().id(2L).nome("Taguatinga").build();
		return Arrays.asList(unidade1, unidade2);
	}
}
