package com.cobras.controle.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.TipoUnidadeEnum;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.EstadoRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "Endpoint de Unidades")
@RestController
@RequestMapping("/unidades")
@CrossOrigin(origins = "*", maxAge = 86400, allowedHeaders = "*")
public class UnidadeController {

	@Autowired
	private CadastroUnidadeService cadastroComRegraUnidade;

	@Autowired
	private EstadoRepository estadoRepository;

	@ApiOperation(value = "Listar Todas Unidades", produces = "application/json")
	@ApiResponse(code = 200, message = "Retornado todas as Unidades")
	@GetMapping(produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<Unidade> listar() {
		return cadastroComRegraUnidade.findAll();
	}

	@ApiOperation(value = "Listar Unidades com ordenacao e paginacao")
	@ApiResponse(code = 200, message = "Retornado todas as Unidades")
	@GetMapping(produces = { "application/json" }, path = "/pesquisarPaginada")
	@ResponseStatus(HttpStatus.OK)
	public Page<Unidade> listarTodosPaginado(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "ordernarPor", defaultValue = "nome") String ordernarPor,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, ordernarPor));
		return cadastroComRegraUnidade.findAll(pageable);
	}
	
	
	@GetMapping(
	path = "/pesquisar")
	@ResponseStatus(HttpStatus.OK)
	public List<Unidade> pesquisaParametrizada(
			@RequestBody(required = false) Unidade unidade) {
			Unidade unidade2 = new Unidade();
			unidade2.setCidade(new Municipio());
			unidade2.getCidade().setEstado(new Estado());
			
			if(unidade.getCodigo() != null) {
				unidade2.setCodigo(unidade.getCodigo());
			}

			if(unidade.getNome() != null) {
				unidade2.setNome(unidade.getNome());
			}
			if(unidade.getCidade().getId() != null) {
				unidade2.setCidade(unidade.getCidade());
			}
			if(unidade.getResponsavel() != null) {
				unidade2.setResponsavel(unidade.getResponsavel());
			}
			if(unidade.getAtivo() != null) {
				unidade2.setAtivo(unidade.getAtivo());
			}
			if(unidade.getCidade().getEstado() != null) {
				unidade2.getCidade().setEstado(unidade.getCidade().getEstado());
			}

			return cadastroComRegraUnidade.buscar(unidade2);
		}
		
	

//	@ApiOperation(value = "Busca Por parametros")
//	@ApiResponse(code = 200, message = "Retornado as Unidades com os parametros encontrados", response = Unidade.class)
//	@GetMapping(produces = { "application/json" }, consumes = { "application/json" }, path = "/pesquisar")
//	@ResponseStatus(HttpStatus.OK)
//	public List<Unidade> pesquisaParametrizada(@RequestBody(required = false) Optional<Unidade> unidade) {
//		if (unidade.isPresent()) {
//			Unidade unid = unidade.get();
//
//			String codigo = unid.getCodigo();
//			String nome = unid.getNome();
//			String responsavel = unid.getResponsavel();
//			char ativo = unid.getAtivo();
//			Long cidade = unid.getCidade();
//			Long estadoId = 0L;
//			Long estadoRep = unid.getEstado();
//			Optional<Estado> estado = estadoRepository.findById(estadoRep);
//			if (estado.isPresent()) {
//				Estado est = estado.get();
//				estadoId = est.getId();
//			}
//			TipoUnidadeEnum tipo = unid.getTipo();
//			return cadastroComRegraUnidade.findByListaParametros(codigo, nome, responsavel, ativo, cidade,
//					tipo.getValor(), estadoId);
//		}
//		return cadastroComRegraUnidade.findAll();
//	}

	@ApiOperation("Busca a Unidade por ID")
	@GetMapping(produces = { "application/json" }, path = "/{unidadeId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Unidade> buscar(@PathVariable Long unidadeId) {
		Optional<Unidade> unidade = cadastroComRegraUnidade.findById(unidadeId);
		if (unidade.isPresent()) {
			return ResponseEntity.ok(unidade.get());
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Incluir uma Unidade")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public Unidade incluir(@Valid @RequestBody Unidade unidade) {
		
		return cadastroComRegraUnidade.incluir(unidade);
	}

	@ApiOperation("Alterar uma Unidade Já existente")
	@PutMapping(path = "/{unidadeId}", consumes = { "application/json" }, produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Unidade> alterar(@Valid @PathVariable Long unidadeId, @RequestBody Unidade unidade) {
		// Verifica se a Unidade existe
		if (!cadastroComRegraUnidade.existsById(unidadeId)) {
			return ResponseEntity.notFound().build();
		}
		unidade.setId(unidadeId);
		unidade = cadastroComRegraUnidade.alterar(unidade);
		return ResponseEntity.ok(unidade);
	}

}