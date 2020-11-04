package com.cobras.controle.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobras.controle.domain.exception.NegocioException;
import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

@Service
public class CadastroUnidadeServiceImpl implements CadastroUnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public Unidade incluir(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());


		if (unidadeExistente != null) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
		}
		unidade.setTelefone(unidade.getTelefone().replaceAll("[\\s()-]", "").replace(" ", "").trim());
		return unidadeRepository.save(unidade);
	}

	public Unidade alterar(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		if (unidadeExistente != null && !unidadeExistente.getId().equals(unidade.getId())) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
		}
		if(unidade.getTelefone() != null) {
			unidade.setTelefone(unidade.getTelefone().replaceAll("[\\s()-]", "").replace(" ", "").trim());
		}
		return unidadeRepository.save(unidade);
	}

	@Override
	public List<Unidade> findByNomeContaining(String nome) {
		return unidadeRepository.findByNomeContaining(nome);
	}

	@Override
	public Unidade findByCodigo(String codigo) {
		return unidadeRepository.findByCodigo(codigo);
	}

	@Override
	public Unidade findByEmail(String email) {
		return unidadeRepository.findByEmail(email);
	}


	@Override
	public List<Unidade> findByCodigoAndNomeAndResponsavel(String codigo, 
			String nome, String responsavel) {
		return unidadeRepository.findByCodigoAndNomeAndResponsavel(codigo, nome, 
				responsavel);
	}

	@Override
	public Optional<Unidade> findByCodigoAndNome(String codigo, String nome) {
		return unidadeRepository.findByCodigoAndNome(codigo, nome);
	}

	@Override
	public List<Unidade> findByCodigoAndNomeAndResponsavelAndAtivo(String codigo, String nome,
			String responsavel, char ativo) {
		return unidadeRepository.findByCodigoAndNomeAndResponsavelAndAtivo(codigo, nome, 
				responsavel, ativo);
	}

	@Override
	public List<Unidade> findAll() {
		return unidadeRepository.findAll();
	}

	@Override
	public Optional<Unidade> findById(Long id) {
		return unidadeRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return unidadeRepository.existsById(id);
	}

	@Override
	public List<Unidade> findByListaParametros(String codigo, String nome, 
			String responsavel, char ativo, Long cidade, Integer tipo, Long estadoId) {
		return unidadeRepository.findByListaParametros(codigo, nome, responsavel, 
				ativo, cidade, tipo, estadoId);
	}

	@Override
	public Page<Unidade> findAll(Pageable pageable) {
		return unidadeRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Unidade> buscar(Unidade unidade) {
		Unidade unidade2 = new Unidade();
		if(unidade2.getCidade() == null) {
			unidade2.setCidade(new Municipio());
		}
		
		if(unidade.getCidade() != null ) {
			if(unidade.getCidade().getId() != null) {
				unidade2.setCidade(unidade.getCidade());
			}
			if(unidade.getCidade().getEstado() != null) {
				unidade2.getCidade().setEstado(unidade.getCidade().getEstado());
			}
		}
		unidade2.getCidade().setEstado(new Estado());
		if(unidade == null) {
			return unidadeRepository.findAll();
		}
		if(unidade.getCodigo() != null) {
			unidade2.setCodigo(unidade.getCodigo());
		}

		if(unidade.getNome() != null) {
			unidade2.setNome(unidade.getNome());
		}
	
		if(unidade.getResponsavel() != null && unidade.getResponsavel().equals("")) {
			unidade2.setResponsavel(null);
		}
		if(unidade.getResponsavel() != null && !unidade.getResponsavel().equals("")) {
			unidade2.setResponsavel(unidade.getResponsavel());
		}
		if(unidade.getAtivo() != null) {
			unidade2.setAtivo(unidade.getAtivo());
		}

		Example<Unidade> example = Example.of( unidade2, 
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING) );
		return unidadeRepository.findAll(example);
	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public Page<Unidade> buscar(Unidade unidade, Pageable page) {
//		Example example = Example.of( unidade, 
//				ExampleMatcher.matching()
//					.withIgnoreCase()
//					.withStringMatcher(StringMatcher.CONTAINING) );
//		return unidadeRepository.findAll(example, page);
//	}


}
