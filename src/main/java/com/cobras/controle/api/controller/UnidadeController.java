package com.cobras.controle.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.vo.UnidadeVO;
import com.cobras.controle.domain.service.impl.CadastroUnidadeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "EndPoint de Unidades")
@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private CadastroUnidadeServiceImpl cadastroComRegraUnidade;
	
	@ApiOperation("Listar Todas Unidades")
	@GetMapping(produces = { "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<UnidadeVO> listar() {
		return cadastroComRegraUnidade.findAll();
	}
	
	@ApiOperation("Buscar a Unidade por ID")
	@GetMapping(produces = { "application/json"}, 
		path = "/{unidadeId}")
	@ResponseStatus(HttpStatus.OK)
	public UnidadeVO buscar(@PathVariable Long unidadeId) {
		return cadastroComRegraUnidade.findById(unidadeId);
	}

	@ApiOperation("Incluir uma Unidade")
	@PostMapping( produces = { "application/json"}, 
		consumes= {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public UnidadeVO incluir(@Valid @RequestBody UnidadeVO unidade) {
		return cadastroComRegraUnidade.incluir(unidade);
	}
	
	@ApiOperation("Alterar Os dados de uma unidade ja existente")
	@PutMapping(path = "/{unidadeId}", 
		consumes= {"application/json"}, 
		produces = { "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UnidadeVO> alterar(@Valid @PathVariable Long unidadeId, 
			@RequestBody UnidadeVO unidade) {
		//Verifica se a Unidade existe
		if (!cadastroComRegraUnidade.existsById(unidadeId)) {
			return ResponseEntity.notFound().build();
		}
		unidade.setId(unidadeId);
		unidade = cadastroComRegraUnidade.alterar(unidade);
		return ResponseEntity.ok(unidade);
	}
	
}