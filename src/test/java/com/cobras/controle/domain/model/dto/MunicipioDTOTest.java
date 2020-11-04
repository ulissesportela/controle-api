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
						"nome");
		assertEquals(1L, municipioDTO.getId());
		assertEquals("001", municipioDTO.getCodigo());
		assertEquals("nome", municipioDTO.getNome());
		assertEquals("0001", municipioDTO.getCodigoCompleto());
		
	}

}
