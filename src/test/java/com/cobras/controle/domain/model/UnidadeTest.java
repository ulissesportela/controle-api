package com.cobras.controle.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnidadeTest {
	
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
		Unidade unidade = Unidade.builder()
				.id(1L)
				.nome("Nome da unidade")
				.codigo("12")
				.email("teste@gmail.com")
				.telefone("12345123")
				.ativo("1")
				.justificativa("Just")
				.responsavel("Responsavel")
				.tipo(TipoUnidadeEnum.MATRIZ)
				.cidade(cidade)
				.build();

		assertEquals(1L,unidade.getId());
		assertEquals("Nome da unidade", unidade.getNome());
		assertEquals("12", unidade.getCodigo());
		assertEquals(TipoUnidadeEnum.MATRIZ, unidade.getTipo());
		assertEquals("teste@gmail.com", unidade.getEmail());
		assertEquals("12345123", unidade.getTelefone());
		assertEquals("1", unidade.getAtivo());
		assertEquals("Just", unidade.getJustificativa());
		assertEquals("Responsavel", unidade.getResponsavel());
		assertEquals(1L, unidade.getCidade().getId());
		assertEquals("001", unidade.getCidade().getCodigo());
		assertEquals("001", unidade.getCidade().getCodigoCompleto());
		assertEquals("Cidade", unidade.getCidade().getNome());
		assertEquals(1L, unidade.getCidade().getEstado().getId());
		assertEquals("001", unidade.getCidade().getEstado().getCodigo());
		assertEquals("Distrito Federal", unidade.getCidade().getEstado().getNome());
		assertEquals("DF", unidade.getCidade().getEstado().getSigla());
		assertEquals(true, unidade.equals(unidade));
	}
	
}
