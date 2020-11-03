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
import com.cobras.controle.domain.model.dto.MunicipioDTO;
import com.cobras.controle.domain.service.EstadoService;
import com.cobras.controle.domain.service.MunicipioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Endpoint de Estados")
@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private MunicipioService municipioService;

	@ApiOperation("Listar Todos os Estados")
	@GetMapping(produces = { "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<Estado> listar() {
		return estadoService.findAll();
	}

	@ApiOperation("Listar Todos os municipios a partir do Id do Estado informado")
	@GetMapping(produces = { "application/json"}, path="/{id}/municipios")
	@ResponseStatus(HttpStatus.OK)
	public List<MunicipioDTO> listarMunicipios(@PathVariable Long id) {
		return municipioService.findByEstadoId(id);
	}
}
