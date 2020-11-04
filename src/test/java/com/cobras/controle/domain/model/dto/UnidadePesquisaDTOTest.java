package com.cobras.controle.domain.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.domain.model.TipoUnidadeEnum;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnidadePesquisaDTOTest {

	@Test
	void deveValidarCampos() {
		EstadoPesquisaDTO estado = new EstadoPesquisaDTO();
				estado.setId(1L);
				
		MunicipioPesquisaDTO cidade = new MunicipioPesquisaDTO();
				cidade.setId(1L);
		UnidadePesquisaDTO unidadeDTO = new UnidadePesquisaDTO();
		unidadeDTO.setNome("Nome da unidade");
		unidadeDTO.setCodigo("12");
		unidadeDTO.setAtivo("1");
		unidadeDTO.setResponsavel("Responsavel");
		unidadeDTO.setTipo(TipoUnidadeEnum.MATRIZ);
		assertEquals("Nome da unidade", unidadeDTO.getNome());
		assertEquals("12", unidadeDTO.getCodigo());
		assertEquals(TipoUnidadeEnum.MATRIZ, unidadeDTO.getTipo());
		assertEquals("1", unidadeDTO.getAtivo());
		assertEquals("Responsavel", unidadeDTO.getResponsavel());
		assertEquals(1L, unidadeDTO.getCidade().getId());
		assertEquals(1L, unidadeDTO.getCidade().getEstado().getId());
		assertEquals(true, unidadeDTO.equals(unidadeDTO));
	}
}
