package com.cobras.controle.domain.model;

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
	
//	@Test
//	void deveValidarCampos() {
//		Unidade unidade = new Unidade();
//		unidade.setId(1L);
//		unidade.setNome("Nome da unidade");
//		unidade.setCodigo("12");
//		unidade.setTipoUnidade(TipoUnidade.MATRIZ);
//		unidade.setCidade(1L);
//		unidade.setEmail("teste@gmail.com");
//		unidade.setTelefone("12345123");
//		unidade.setAtivo(1L);
//		unidade.setJustificativa("Just");
//		unidade.setResponsavel("Responsavel");
//		
//	}
	
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
