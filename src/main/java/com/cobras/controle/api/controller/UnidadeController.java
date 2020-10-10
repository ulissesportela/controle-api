package com.cobras.controle.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@GetMapping()
	public List<Unidade> listar() {
		return unidadeRepository.findAll();
	}
	
	@GetMapping("/{unidadeId}")
	public ResponseEntity<Unidade> buscar(@PathVariable  Long unidadeId) {
		Optional<Unidade> unidade = unidadeRepository.findById(unidadeId);
		
		if (unidade.isPresent()) {
			return ResponseEntity.ok(unidade.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Unidade incluir(@RequestBody Unidade unidade) {
		return unidadeRepository.save(unidade);
	}
	
	@PutMapping("/{unidadeId}")
	public ResponseEntity<Unidade> alterar( @PathVariable Long unidadeId, @RequestBody Unidade unidade) {
		
		//Verifica se a Unidade existe
		if (!unidadeRepository.existsById(unidadeId)) {
			return ResponseEntity.notFound().build();
		}
		
		unidade.setId(unidadeId);
		unidade = unidadeRepository.save(unidade);
		
		return ResponseEntity.ok(unidade);
	}
	
	@DeleteMapping("/{unidadeId}")
	public ResponseEntity<Void> excluir( @PathVariable Long unidadeId ) {
		
		//Verifica se a Unidade existe
		if (!unidadeRepository.existsById(unidadeId)) {
			return ResponseEntity.notFound().build();
		}
		
		unidadeRepository.deleteById(unidadeId);
		
		return ResponseEntity.noContent().build();
	}

}