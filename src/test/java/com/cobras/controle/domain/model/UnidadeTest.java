package com.cobras.controle.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.api.controller.UnidadeController;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.impl.CadastroUnidadeServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnidadeTest {
	
	
	@Autowired
	UnidadeRepository unidadeRepository;
	
	@Autowired
	CadastroUnidadeServiceImpl serviceImpl;
	
	@Autowired
	UnidadeController unidadeController;
	
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
		
		assertEquals(true, unidade.equals(unidade));
	}
	
//	@Test
//	void deveRetornarCertoValor() {
//
//		Optional<Unidade> unidadeRetornada = unidadeRepository.findById(1L);
//		System.out.println("UnidadeRetornada Optional" + unidadeRetornada.get());
//		System.out.println("UnidadeRetornada Optional" + unidadeRetornada.get());
//		System.out.println(unidadeRetornada.toString() + " Optinal to String");
//		assertEquals(unidadeRetornada.getId(), 1L);
//		assertEquals(unidadeRetornada.getNome(), "Nome Unidade");
//		assertEquals(unidadeRetornada.getCodigo(), "350");
//		assertEquals(unidadeRetornada.getEmail(), "email@email.com");
//		assertEquals(unidadeRetornada.getTelefone(), "123123123");		
//	}
	
}
