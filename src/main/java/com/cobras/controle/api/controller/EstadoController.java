package com.cobras.controle.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.dto.MunicipioDTO;
import com.cobras.controle.domain.repository.EstadoRepository;
import com.cobras.controle.domain.repository.MunicipioRepository;
import com.cobras.controle.domain.service.MunicipioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Api(tags = "Endpoint de Estados")
@RestController
@RequestMapping("/estados")
public class EstadoController {

	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private MunicipioService municipioService;

	@ApiOperation("Listar Todos os Estados")
	@GetMapping(produces = { "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}

	@ApiOperation("Listar Todos os municipios a partir do Id do Estado informado")
	@GetMapping(produces = { "application/json"}, path="/{id}/municipios")
	@ResponseStatus(HttpStatus.OK)
	public List<MunicipioDTO> listarMunicipios(@PathVariable Long id) {
		List<MunicipioDTO> municipioLista = municipioService.findByEstadoId(id);
		return municipioLista;
	}
}
