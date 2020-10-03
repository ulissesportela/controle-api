package com.cobras.controle.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	@GetMapping("/usuarios")
	public String listar() {
		return "Teste";
	}
}
