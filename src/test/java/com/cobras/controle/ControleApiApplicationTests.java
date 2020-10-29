package com.cobras.controle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.api.controller.EstadoController;
import com.cobras.controle.api.controller.PerfilController;
import com.cobras.controle.api.controller.UnidadeController;
import com.cobras.controle.api.controller.UsuarioController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ControleApiApplicationTests {

	
	@Autowired
	private EstadoController estadoController;
	
	@Autowired
	private PerfilController perfilController;
	
	@Autowired
	private UnidadeController unidadeController;
	
	@Autowired
	private UsuarioController usuarioController;

	@Test
	void contextLoads() {
		assertThat(estadoController).isNotNull();
		assertThat(perfilController).isNotNull();
		assertThat(unidadeController).isNotNull();
		assertThat(usuarioController).isNotNull();
	}
}
