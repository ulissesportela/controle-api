package com.cobras.controle.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.Perfil;

@RestController
public class PerfilController {

	@GetMapping("/perfis")
	public List<Perfil> listar() {
		
		var perfil1 = Perfil.builder().id(1L).nome("Master").build();
		var perfil2 = Perfil.builder().id(2L).nome("Supervisos").build();
		var perfil3 = Perfil.builder().id(3L).nome("Agente").build();
		
		return Arrays.asList(perfil1, perfil2, perfil3);
	}
}
