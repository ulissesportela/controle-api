package com.cobras.controle.domain.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MunicipioDTOTest {
	
	@Test
	void deveMontarConstrutorParaConsulta() {
		MunicipioDTO municipioDTO = 
				new MunicipioDTO(1L, "001", "0001", 
						"nome", 1L, "001", 
						"nomeEstado", "DF");
		assertEquals(1L, municipioDTO.getId());
		assertEquals("001", municipioDTO.getCodigo());
		assertEquals("nome", municipioDTO.getNome());
		assertEquals("0001", municipioDTO.getCodigoCompleto());
		assertEquals(1L, municipioDTO.getIdEstado());
		assertEquals("001", municipioDTO.getCodigoEstado());
		assertEquals("nomeEstado", municipioDTO.getNomeEstado());
		assertEquals("DF", municipioDTO.getSiglaEstado());
		
	}

}
