package com.cobras.controle.domain.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.api.controller.UnidadeController;
import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.TipoUnidadeEnum;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.dto.EstadoPesquisaDTO;
import com.cobras.controle.domain.model.dto.MunicipioPesquisaDTO;
import com.cobras.controle.domain.model.dto.UnidadePesquisaDTO;
import com.cobras.controle.domain.repository.UnidadeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CadastroUnidadeServiceImplTest {

	@Autowired
	@Mock
	CadastroUnidadeServiceImpl serviceImpl;

	@Autowired
	@Mock
	UnidadeController unidadeController;

	@Autowired
	@Mock
	UnidadeRepository unidadeRepository;

	@Test
	void deveBuscarTodasUnidades() {
		List<Unidade> listaUnidades = new ArrayList<Unidade>();
		listaUnidades = unidadeRepository.findAll();
		assertThat(listaUnidades).isNotNull();
	}

	@Test
	void findAllRepository() {
		List<Unidade> unidadeLista = unidadeRepository.findAll();
		assertThat(unidadeLista).isNotNull();
	}
	
	@Test
	void deveBuscarNaService() {
		EstadoPesquisaDTO estado = new EstadoPesquisaDTO();
		estado.setId(27L);
				
		MunicipioPesquisaDTO cidade = new MunicipioPesquisaDTO();
		cidade.setId(5570L);
		
		UnidadePesquisaDTO unidade = new UnidadePesquisaDTO();
		unidade.setNome("teste");
		unidade.setCodigo("0022");
		unidade.setAtivo("1");
		unidade.setResponsavel(null);
		unidade.setCidade(cidade);
		unidade.getCidade().setEstado(estado);
		List<Unidade> unidadeLista = serviceImpl.buscar(unidade);
		assertEquals(1, unidadeLista.size());
	}
	
	@Test
	void deveBuscarNaServiceCamposDePesquisaNulosDevemTrazerTudo() {
		EstadoPesquisaDTO estado = new EstadoPesquisaDTO();
		estado.setId(null);

				
		MunicipioPesquisaDTO cidade = new MunicipioPesquisaDTO();
		cidade.setId(null);
				
		UnidadePesquisaDTO unidade = new UnidadePesquisaDTO();
				unidade.setNome(null);
				unidade.setCodigo(null);
				unidade.setAtivo(null);
				unidade.setResponsavel(null);
				unidade.setCidade(cidade);
				unidade.getCidade().setEstado(estado);
		List<Unidade> unidadeLista = serviceImpl.buscar(unidade);
		assertEquals(30, unidadeLista.size());
	}
	
	@Test
	void deveBuscarUnidadePorId() {
		Optional<Unidade> entidade = unidadeRepository.findById(1L);
		assertThat(entidade).isPresent().isNotNull();
	}

	@Test
	void naoDeveBuscarUnidadePorId() {
		Optional<Unidade> entidade = unidadeRepository.findById(12300L);
		assertThat(entidade).isEmpty();
	}

	@Test
	void controllerBuscaNaService() {
		ResponseEntity<Unidade> unidade = unidadeController.buscaPorId(1L);
		assertThat(unidade).isNotNull();
	}

	
	@Test
	void NaoDevecontrollerBuscaNaService() {
		ResponseEntity<Unidade> unidade = unidadeController.buscaPorId(12300L);
		assertThat(unidade).isNotNull();
	}
	
	
//	@Test
//	void deveAlterarUnidade() {
//		Unidade unidade = new Unidade();
//		unidade.setNome("Nome Unidade");
//		unidade.setCodigo("444");
//		unidade.setTipo(TipoUnidadeEnum.PARCEIRA);
//		//unidade.setCidade(5570L);
//		unidade.setEmail("email@email.com");
//		unidade.setTelefone("123123123");
//		unidade.setAtivo("1");
//		
//		ResponseEntity<Unidade> unidadeResponse = unidadeController.buscar(1L);
//		boolean unidadeExistente = unidadeRepository.existsById(1L);
//		boolean unidadeNaoExistente = unidadeRepository.existsById(1000L);
//		assertThat(unidade).isNotNull();
//		unidade = serviceImpl.alterar(unidade);
//		unidade.setCodigo("333");
//		unidadeResponse = unidadeController.alterar(1L, unidade);
//		assertThat(ResponseEntity.ok(unidade)).isNotNull();
//		assertThat(unidadeExistente).isTrue();
//		assertThat(unidadeNaoExistente).isFalse();
//		assertThat(unidadeResponse).isNotNull();
//	}
//	
//	@Test
//	void deveIncluirUnidade() {
//		Unidade unidade = new Unidade();
//		unidade.setNome("Nome Unidade");
//		unidade.setCodigo("222");
//		unidade.setTipo(TipoUnidadeEnum.PARCEIRA);
//		unidade.setCidade(5570L);
//		unidade.setEmail("email@email.com");
//		unidade.setTelefone("123123123");
//		unidade.setAtivo("1");
//		unidadeController.incluir(unidade);
//		
//	}

}
