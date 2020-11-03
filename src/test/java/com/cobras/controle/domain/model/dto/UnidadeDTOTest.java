package com.cobras.controle.domain.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.TipoUnidadeEnum;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnidadeDTOTest {

	@Test
	void deveValidarCampos() {
		Estado estado = Estado.builder()
				.id(1L)
				.codigo("001")
				.nome("Distrito Federal")
				.sigla("DF").build();
				
		Municipio cidade = Municipio.builder()
				.id(1L)
				.codigo("001")
				.codigoCompleto("001")
				.nome("Cidade").estado(estado).build();
		UnidadeDTO unidadeDTO = new UnidadeDTO();
		unidadeDTO.setUnidadeId(1L);
		unidadeDTO.setNome("Nome da unidade");
		unidadeDTO.setCodigo("12");
		unidadeDTO.setEmail("teste@gmail.com");
		unidadeDTO.setTelefone("12345123");
		unidadeDTO.setAtivo("1");
		unidadeDTO.setJustificativa("Just");
		unidadeDTO.setResponsavel("Responsavel");
		unidadeDTO.setTipo(TipoUnidadeEnum.MATRIZ);
		unidadeDTO.setCidade(cidade);

		assertEquals(1L,unidadeDTO.getUnidadeId());
		assertEquals("Nome da unidade", unidadeDTO.getNome());
		assertEquals("12", unidadeDTO.getCodigo());
		assertEquals(TipoUnidadeEnum.MATRIZ, unidadeDTO.getTipo());
		assertEquals("teste@gmail.com", unidadeDTO.getEmail());
		assertEquals("12345123", unidadeDTO.getTelefone());
		assertEquals("1", unidadeDTO.getAtivo());
		assertEquals("Just", unidadeDTO.getJustificativa());
		assertEquals("Responsavel", unidadeDTO.getResponsavel());
		assertEquals(1L, unidadeDTO.getCidade().getId());
		assertEquals("001", unidadeDTO.getCidade().getCodigo());
		assertEquals("001", unidadeDTO.getCidade().getCodigoCompleto());
		assertEquals("Cidade", unidadeDTO.getCidade().getNome());
		assertEquals(1L, unidadeDTO.getCidade().getEstado().getId());
		assertEquals("001", unidadeDTO.getCidade().getEstado().getCodigo());
		assertEquals("Distrito Federal", unidadeDTO.getCidade().getEstado().getNome());
		assertEquals("DF", unidadeDTO.getCidade().getEstado().getSigla());
		assertEquals(true, unidadeDTO.equals(unidadeDTO));
	}
}
