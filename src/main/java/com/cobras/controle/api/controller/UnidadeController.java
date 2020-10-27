package com.cobras.controle.api.controller;

import java.util.List;
import java.util.Optional;

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

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.service.impl.CadastroUnidadeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CRUD de Unidade")
@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private CadastroUnidadeServiceImpl cadastroComRegraUnidade;
	
	@ApiOperation("Listar Todas Unidades")
	@GetMapping(produces = { "application/json"})
	public List<Unidade> listar() {
		return cadastroComRegraUnidade.findAll();
	}
	
	@ApiOperation("Buscar por ID")
	@GetMapping(produces = { "application/json"}, 
		path = "/{unidadeId}")
	public ResponseEntity<Unidade> buscar(@PathVariable  Long unidadeId) {
		Optional<Unidade> unidade = cadastroComRegraUnidade.findById(unidadeId);
		if (unidade.isPresent()) {
			return ResponseEntity.ok(unidade.get());
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Incluir uma Unidade")
	@PostMapping( produces = { "application/json"}, 
		consumes= {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public Unidade incluir(@Valid @RequestBody Unidade unidade) {
		return cadastroComRegraUnidade.incluir(unidade);
	}
	
	@ApiOperation("Alterar uma Unidade")
	@PutMapping(path = "/{unidadeId}", 
		consumes= {"application/json"}, 
		produces = { "application/json"})
	public ResponseEntity<Unidade> alterar(@Valid @PathVariable Long unidadeId, 
			@RequestBody Unidade unidade) {
		//Verifica se a Unidade existe
		if (!cadastroComRegraUnidade.existsById(unidadeId)) {
			return ResponseEntity.notFound().build();
		}
		unidade.setId(unidadeId);
		unidade = cadastroComRegraUnidade.alterar(unidade);
		return ResponseEntity.ok(unidade);
	}
	
}