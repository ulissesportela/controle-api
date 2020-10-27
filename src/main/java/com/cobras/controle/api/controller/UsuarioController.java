package com.cobras.controle.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.Usuario;

@RestController
public class UsuarioController {

	@GetMapping("/usuarios")
	public List<Usuario> listar() {
		var usuario1 =  Usuario.builder().id(1L).nome("Joao").cpf("34659198073").build();
		var usuario2 = Usuario.builder().id(2L).nome("Maria").cpf("60448151022").build();
		
		return Arrays.asList(usuario1, usuario2);
	}
}
