package com.cobras.controle.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.dto.UnidadeConsultaDTO;
import com.cobras.controle.domain.model.dto.UnidadeDTO;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Endpoint de Unidades")
@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private CadastroUnidadeService cadastroComRegraUnidade;

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@ApiOperation(value = "Listar Unidades com ordenacao e paginacao")
	@GetMapping(produces = { "application/json" },
			consumes = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<Unidade> pesquisaParametrizada(@Valid
			@RequestBody(required = false) UnidadeConsultaDTO unidade) {
		return cadastroComRegraUnidade.buscar(unidade);
	}
	
	@ApiOperation(value = "Listar Unidades com ordenacao e paginacao")
	@GetMapping(produces = { "application/json" },
			consumes = { "application/json" }, path = "/pesquisar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Unidade> pesquisaParametros(
			@RequestBody(required = false) UnidadeConsultaDTO unidade) {

		try {
			List<Unidade> list = cadastroComRegraUnidade.buscar(unidade).stream().collect(Collectors.toList());
			
			return new ResponseEntity(list, HttpStatus.CREATED);
			//return ResponseEntity.ok(list);
		}catch (Exception e) {
			return new ResponseEntity( HttpStatus.NOT_FOUND );
		}
	}
	
	@ApiOperation(value = "Listar Unidades com ordenacao e paginacao")
	@GetMapping(produces = { "application/json" },
			consumes = { "application/json" }, path = "/pesquisar2")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Unidade> pesquisa2(
			@RequestParam(required = false) String codigo,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String responsavel) {
		Optional<Unidade> optionalUnidade = Optional.empty();
		try {
			List<Unidade> list = unidadeRepository.findByCodigoAndNomeAndResponsavel(codigo, nome, responsavel);
			
			return new ResponseEntity(list, HttpStatus.CREATED);
			//return ResponseEntity.ok(list);
		}catch (Exception e) {
			return new ResponseEntity( HttpStatus.NOT_FOUND );
		}
	}

	@ApiOperation(value = "Listar Unidades com ordenacao e paginacao")
	@GetMapping(produces = { "application/json" },
			consumes = { "application/json" }, path = "/pesquisar3")
	@ResponseStatus(HttpStatus.OK)
	public List<Unidade> pesquisa3(
			@RequestParam(required = false) String codigo,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String responsavel) {
		return unidadeRepository.findByCodigoAndNomeAndResponsavel(codigo, nome, responsavel);
	}
	
	@ApiOperation(value = "Listar Unidades com ordenacao e paginacao")
	@GetMapping(produces = { "application/json" },
			consumes = { "application/json" }, path = "/pesquisar4")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Unidade>> pesquisa4(
			@RequestParam(required = false) String codigo,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String responsavel) {
	
		return ResponseEntity.ok(unidadeRepository
				.findByCodigoAndNomeAndResponsavel(codigo,nome,responsavel));
	}
	
	@ApiOperation("Busca a Unidade por ID")
	@GetMapping(produces = { "application/json" }, path = "/{unidadeId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Unidade> buscaPorId(@PathVariable Long unidadeId) {
		Optional<Unidade> unidade = cadastroComRegraUnidade.findById(unidadeId);
		if (unidade.isPresent()) {
			return ResponseEntity.ok(unidade.get());
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Incluir uma Unidade")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public Unidade incluir(@RequestBody UnidadeDTO unidade) {
		return cadastroComRegraUnidade.incluir(unidade);
	}

	@ApiOperation("Alterar uma Unidade Ja existente")
	@PutMapping(path = "/{unidadeId}", consumes = { "application/json" }, 
		produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<UnidadeDTO> alterar(@PathVariable Long unidadeId, 
			@RequestBody UnidadeDTO unidade) {
		Unidade unidadeRetorno = new Unidade();
		// Verifica se a Unidade existe
		if (!cadastroComRegraUnidade.existsById(unidadeId)) {
			return ResponseEntity.notFound().build();
		}
		unidade.setId(unidadeId);
		cadastroComRegraUnidade.alterar(unidade);
		return ResponseEntity.ok(unidade);
	}

}