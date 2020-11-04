package com.cobras.controle.domain.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.domain.model.Estado;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EstadoDTOTest {

	@Test
	void deveEncapsularCamposEntidade() {
		EstadoDTO estadoDTO = new EstadoDTO(1L, "001", "Distrito Federal", "DF");
		Estado estado = new Estado();
		estado.setId(estadoDTO.getId());
		estado.setCodigo(estadoDTO.getCodigo());
		estado.setNome(estadoDTO.getNome());
		estado.setSigla(estadoDTO.getSigla());
		
		assertEquals(estado.getId(), estadoDTO.getId());
		assertEquals(estado.getCodigo(), estadoDTO.getCodigo());
		assertEquals(estado.getNome(), estadoDTO.getNome());
		assertEquals(estado.getSigla(), estadoDTO.getSigla());
		
	}
}
