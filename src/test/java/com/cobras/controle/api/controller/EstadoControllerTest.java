package com.cobras.controle.api.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.domain.model.dto.EstadoDTO;
import com.cobras.controle.domain.model.dto.MunicipioDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EstadoControllerTest {
	
	@Autowired
	private EstadoController estadoController;
//	
//	@Test
//	void deveListarEstados() {
//		List<EstadoDTO> estadoDTOLista = estadoController.listar();
//		assertThat(!estadoDTOLista.isEmpty());
//	}
//	
//	@Test
//	void deveRetornarMunicipiosDoEstado() {
//		List<MunicipioDTO> listaMunicipiosDTO = estadoController.listarMunicipios(1L);
//		assertThat(!listaMunicipiosDTO.isEmpty());
//	}
	
}
