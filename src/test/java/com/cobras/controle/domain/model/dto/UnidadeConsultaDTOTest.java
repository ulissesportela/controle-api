package com.cobras.controle.domain.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UnidadeConsultaDTOTest {

	@Test
	void deveVerificarEReceberCamposNulosVindoDoJSONDoReact() {
		UnidadeConsultaDTO parametroPesquisaReact = new UnidadeConsultaDTO();
		UnidadeConsultaDTO camposParaConsulta = new UnidadeConsultaDTO();
		parametroPesquisaReact.setCodigo("");
		parametroPesquisaReact.setAtivo("");
		parametroPesquisaReact.setResponsavel("");
		parametroPesquisaReact.setCidadeId(null);
		parametroPesquisaReact.setEstadoId(null);
		camposParaConsulta.setCodigo(parametroPesquisaReact.getCodigo());
		camposParaConsulta.setAtivo(parametroPesquisaReact.getAtivo());
		camposParaConsulta.setResponsavel(parametroPesquisaReact.getResponsavel());
		camposParaConsulta.setCidadeId(parametroPesquisaReact.getCidadeId());
		camposParaConsulta.setEstadoId(parametroPesquisaReact.getEstadoId());
		assertEquals("", camposParaConsulta.getCodigo());
		assertEquals("", camposParaConsulta.getAtivo());
		assertEquals("", camposParaConsulta.getResponsavel());
		assertEquals(null, camposParaConsulta.getCidadeId());
		assertEquals(null, camposParaConsulta.getEstadoId());
	}
	
	@Test
	void deveVerificarCamposPreenchidosDoReact() {
		UnidadeConsultaDTO parametroPesquisaReact = new UnidadeConsultaDTO();
		UnidadeConsultaDTO camposParaConsulta = new UnidadeConsultaDTO();
		parametroPesquisaReact.setCodigo("0001");
		parametroPesquisaReact.setNome("nomeUnidade");
		parametroPesquisaReact.setAtivo("1");
		parametroPesquisaReact.setResponsavel("resp");
		parametroPesquisaReact.setCidadeId(1L);
		parametroPesquisaReact.setEstadoId(20L);
		camposParaConsulta.setCodigo(parametroPesquisaReact.getCodigo());
		camposParaConsulta.setNome("nomeUnidade");
		camposParaConsulta.setAtivo(parametroPesquisaReact.getAtivo());
		camposParaConsulta.setResponsavel(parametroPesquisaReact.getResponsavel());
		camposParaConsulta.setCidadeId(parametroPesquisaReact.getCidadeId());
		camposParaConsulta.setEstadoId(parametroPesquisaReact.getEstadoId());
		assertEquals("0001", camposParaConsulta.getCodigo());
		assertEquals("nomeUnidade", camposParaConsulta.getNome());
		assertEquals("1", camposParaConsulta.getAtivo());
		assertEquals("resp", camposParaConsulta.getResponsavel());
		assertEquals(1L, camposParaConsulta.getCidadeId());
		assertEquals(20L, camposParaConsulta.getEstadoId());
	}
}
