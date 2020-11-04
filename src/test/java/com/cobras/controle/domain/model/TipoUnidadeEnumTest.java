package com.cobras.controle.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TipoUnidadeEnumTest {

	@Test
	void deveRetornarOvalorInteiro() {
		assertEquals(1, TipoUnidadeEnum.MATRIZ.getValor());
		assertEquals(2, TipoUnidadeEnum.PARCEIRA.getValor());
		assertEquals(3, TipoUnidadeEnum.PROPRIA.getValor());
	}
	
	@Test
	void deveRetornarValueof() {
		assertEquals(TipoUnidadeEnum.MATRIZ, TipoUnidadeEnum.valueOf(1));
		assertEquals(TipoUnidadeEnum.PARCEIRA, TipoUnidadeEnum.valueOf(2));
		assertEquals(TipoUnidadeEnum.PROPRIA, TipoUnidadeEnum.valueOf(3));
	}
	
}
