package com.cobras.controle.domain.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cobras.controle.api.controller.UnidadeController;
import com.cobras.controle.converter.DozerConverter;
import com.cobras.controle.domain.model.vo.UnidadeVO;
import com.cobras.controle.domain.repository.UnidadeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CadastroUnidadeServiceImplTest {

	@Autowired
	CadastroUnidadeServiceImpl serviceImpl;
	
	@Autowired
	UnidadeController unidadeController;
	
	@Autowired
	UnidadeRepository unidadeRepository;
	
	
//	@Test
//	void deveBuscarTodasUnidades() {
//		List<UnidadeVO> listaUnidades = new ArrayList<UnidadeVO>();
//		listaUnidades = DozerConverter.parseListObjects(unidadeRepository.findAll(), UnidadeVO.class);
//		assertThat(listaUnidades).isNotNull();
//	}
//	
//	@Test
//	void deveBuscarUnidadePorId() {
//		var entidade = unidadeRepository.findById(1L);
//		UnidadeVO unidadeVO = DozerConverter.parseObject(entidade, UnidadeVO.class);
//		assertThat(entidade).isNotNull();
//		assertThat(unidadeVO).isNotNull();
//	}
//	
//	@Test
//	void naoDeveBuscarUnidadePorId() {
//		var entidade = unidadeRepository.findById(300L);
//		UnidadeVO unidadeVO = DozerConverter.parseObject(entidade, UnidadeVO.class);
//		assertThat(entidade).isEmpty();
//		System.out.println(" naoDeveBuscarUnidadePorId : |-|" + unidadeVO.toString()+ "|-|");
//	}
//	
//	
//	@Test
//	void controllerBuscaNaService() {
//		UnidadeVO vo = unidadeController.buscar(1L);
//		assertThat(vo).isNotNull();
//	}
	
	
	
}
