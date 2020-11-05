package com.cobras.controle.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobras.controle.domain.exception.NegocioException;
import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.dto.UnidadeConsultaDTO;
import com.cobras.controle.domain.model.dto.UnidadeDTO;
import com.cobras.controle.domain.model.dto.UnidadePesquisaDTO;
import com.cobras.controle.domain.repository.UnidadeRepository;
import com.cobras.controle.domain.service.CadastroUnidadeService;

@Service
public class CadastroUnidadeServiceImpl implements CadastroUnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
//	@Override
//	public ResponseEntity<Unidade> buscarEntity(UnidadeConsultaDTO unidade) {
//		Unidade unidade2 = new Unidade();
//		unidade2.setCidade(new Municipio());
//		unidade2.getCidade().setEstado(new Estado());
//		if (unidade == null) {
//			return (ResponseEntity<Unidade>) unidadeRepository.findAll();
//		}
//
//		if (unidade.getCodigo() != null && !unidade.getCodigo().equals("")) {
//			unidade2.setCodigo(unidade.getCodigo());
//		}
//
//		if (unidade.getNome() != null && !unidade.getNome().equals("")) {
//			unidade2.setNome(unidade.getNome());
//		}
//		if (unidade.getResponsavel() != null && !unidade.getResponsavel().equals("")) {
//			unidade2.setResponsavel(unidade.getResponsavel());
//		}
//
//		if (unidade.getAtivo() != null && !unidade.getAtivo().equals("")) {
//			unidade2.setAtivo(unidade.getAtivo());
//		}
//
//		if (unidade.getCidadeId() != null) {
//			unidade2.getCidade().setId(unidade.getCidadeId());
//
//		}
//		
//		if (unidade.getEstadoId() != null) {
//				unidade2.getCidade().getEstado().setId(unidade.getEstadoId());
//
//		}
//		
//		Example<Unidade> example = Example.of(unidade2,
//				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
//		return (ResponseEntity<Unidade>) unidadeRepository.findAll(example);
//	}

	@Transactional(readOnly = true)
	@Override
	public List<Unidade> buscar(UnidadeConsultaDTO unidade) {
		Unidade unidade2 = new Unidade();
		unidade2.setCidade(new Municipio());
		unidade2.getCidade().setEstado(new Estado());
		if (unidade == null) {
			return unidadeRepository.findAll();
		}

		if (unidade.getCodigo() != null && !unidade.getCodigo().equals("")) {
			unidade2.setCodigo(unidade.getCodigo());
		}

		if (unidade.getNome() != null && !unidade.getNome().equals("")) {
			unidade2.setNome(unidade.getNome());
		}
		if (unidade.getResponsavel() != null && !unidade.getResponsavel().equals("")) {
			unidade2.setResponsavel(unidade.getResponsavel());
		}

		if (unidade.getAtivo() != null && !unidade.getAtivo().equals("")) {
			unidade2.setAtivo(unidade.getAtivo());
		}

		if (unidade.getCidadeId() != null && !unidade.getAtivo().equals("")) {
			unidade2.getCidade().setId(unidade.getCidadeId());
		}
		if (unidade.getEstadoId() != null && !unidade.getAtivo().equals("")) {
			unidade2.getCidade().getEstado().setId(unidade.getEstadoId());
		}
		
		Example<Unidade> example = Example.of(unidade2);
		return unidadeRepository.findAll(example);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Unidade> buscar(UnidadePesquisaDTO unidade) {
		Unidade unidade2 = new Unidade();
		unidade2.setCidade(new Municipio());
		unidade2.getCidade().setEstado(new Estado());
		if (unidade == null) {
			return unidadeRepository.findAll();
		}

		if (unidade.getCodigo() != null && !unidade.getCodigo().equals("")) {
			unidade2.setCodigo(unidade.getCodigo());
		}

		if (unidade.getNome() != null && !unidade.getNome().equals("")) {
			unidade2.setNome(unidade.getNome());
		}
		if (unidade.getResponsavel() != null && !unidade.getResponsavel().equals("")) {
			unidade2.setResponsavel(unidade.getResponsavel());
		}

		if (unidade.getAtivo() != null && !unidade.getAtivo().equals("")) {
			unidade2.setAtivo(unidade.getAtivo());
		}

		if (unidade.getCidade() != null) {
			if (unidade.getCidade().getId() != null) {
				unidade2.setCidade(new Municipio());
				unidade2.getCidade().setId(unidade.getCidade().getId());
			}
			if (unidade.getCidade().getEstado() != null) {
				if (unidade.getCidade().getEstado().getId() != null) {
					unidade2.getCidade().setEstado(new Estado());
					unidade2.getCidade().getEstado().setId(unidade.getCidade().getEstado().getId());
				}
			}
		}
		Example<Unidade> example = Example.of(unidade2);
		return unidadeRepository.findAll(example);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Unidade> buscar(Unidade unidade) {
		Unidade unidade2 = new Unidade();
		unidade2.setCidade(new Municipio());
		unidade2.getCidade().setEstado(new Estado());
		if (unidade == null) {
			return unidadeRepository.findAll();
		}

		if (unidade.getCodigo() != null && !unidade.getCodigo().equals("")) {
			unidade2.setCodigo(unidade.getCodigo());
		}

		if (unidade.getNome() != null && !unidade.getNome().equals("")) {
			unidade2.setNome(unidade.getNome());
		}
		if (unidade.getResponsavel() != null && !unidade.getResponsavel().equals("")) {
			unidade2.setResponsavel(unidade.getResponsavel());
		}

		if (unidade.getAtivo() != null && !unidade.getAtivo().equals("")) {
			unidade2.setAtivo(unidade.getAtivo());
		}

		if (unidade.getCidade() != null) {
			if (unidade.getCidade().getId() != null) {
				unidade2.setCidade(new Municipio());
				unidade2.getCidade().setId(unidade.getCidade().getId());
			}
			if (unidade.getCidade().getEstado() != null) {
				if (unidade.getCidade().getEstado().getId() != null) {
					unidade2.getCidade().setEstado(new Estado());
					unidade2.getCidade().getEstado().setId(unidade.getCidade().getEstado().getId());
				}
			}
		}
		Example<Unidade> example = Example.of(unidade2);
		return unidadeRepository.findAll(example);
	}
	
	@Override
	public List<Unidade> queryByExample(Unidade unidade) {
		Example<Unidade> example = Example.of(unidade);
	    return unidadeRepository.findAll(example);
	}
	
	@Override
	public Optional<Unidade> findById(Long id) {
		return unidadeRepository.findById(id);
	}
	
	@Override
	public Unidade incluir(UnidadeDTO unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());
		Unidade unidadePersistencia = converteDTOparaEntidade(unidade);
		
		if (unidadeExistente != null) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
		}
		
		return unidadeRepository.save(unidadePersistencia);
	}

	public Unidade converteDTOparaEntidade(UnidadeDTO unidade) {
		Unidade unidadePersistencia = new Unidade();
		unidadePersistencia.setCidade(new Municipio());
		unidadePersistencia.getCidade().setEstado(new Estado());
		
		unidadePersistencia.setCodigo(unidade.getCodigo());
		unidadePersistencia.setAtivo(unidade.getAtivo());
		unidadePersistencia.setResponsavel(unidade.getResponsavel());
		unidadePersistencia.setNome(unidade.getNome());
		unidadePersistencia.setEmail(unidade.getEmail());
		unidadePersistencia.setJustificativa(unidade.getJustificativa());
		if(unidade.getTelefone() != null) {
			unidadePersistencia.setTelefone(unidade.getTelefone()
				.replaceAll("[\\s()-]", "").replace(" ", "").trim());
		} else if(unidade.getTelefone() == null) {
			unidadePersistencia.setTelefone(null);
		}
		unidadePersistencia.setTipo(unidade.getTipo());
		
		//Cidade
		unidadePersistencia.setCidade(unidade.getCidade());
		
		unidadePersistencia.getCidade().setId(unidade.getCidade().getId());
		unidadePersistencia.getCidade().setCodigo(unidade.getCidade().getCodigo());
		unidadePersistencia.getCidade().setCodigoCompleto(unidade.getCidade().getCodigo());
		unidadePersistencia.getCidade().setNome(unidade.getCidade().getNome());
		
		//Estado
		unidadePersistencia.getCidade().setEstado(unidade.getCidade().getEstado());
		unidadePersistencia.getCidade().getEstado().setId(
				unidade.getCidade().getEstado().getId());
		unidadePersistencia.getCidade().getEstado().setCodigo(
				unidade.getCidade().getEstado().getCodigo());
		unidadePersistencia.getCidade().getEstado().setNome(
				unidade.getCidade().getEstado().getNome());
		unidadePersistencia.getCidade().getEstado().setSigla(
				unidade.getCidade().getEstado().getSigla());
		return unidadePersistencia;
	}

	public void alterar(UnidadeDTO unidade) {
		Unidade unidadePersistencia = converteDTOparaEntidade(unidade);
		unidadePersistencia.setId(unidade.getId());
			unidadeRepository.updateUnidade(
					unidadePersistencia.getId(), unidadePersistencia.getCodigo(),
					unidadePersistencia.getAtivo(), unidadePersistencia.getResponsavel(),
					unidadePersistencia.getNome(),
					unidadePersistencia.getEmail(),unidadePersistencia.getJustificativa());

	}

	@Override
	public List<Unidade> findAll() {
		return unidadeRepository.findAll();
	}

	@Override
	public boolean existsById(Long id) {
		return unidadeRepository.existsById(id);
	}

	@Override
	public ResponseEntity<Unidade> buscarEntity(UnidadeConsultaDTO unidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
