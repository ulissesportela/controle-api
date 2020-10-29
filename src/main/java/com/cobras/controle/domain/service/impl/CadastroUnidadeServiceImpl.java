package com.cobras.controle.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.exception.NegocioException;
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

		return unidadeRepository.save(unidade);
	}

	public Unidade alterar(Unidade unidade) {
		Unidade unidadeExistente = unidadeRepository.findByCodigo(unidade.getCodigo());

		if (unidadeExistente != null && !unidadeExistente.getId().equals(unidade.getId())) {
			throw new NegocioException("Já existe uma unidade cadastrada com esse código");
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
	public List<Unidade> findAllPesquisa(String codigo, String nome, String responsavel) {
		return unidadeRepository.findAllPesquisa(codigo, nome, responsavel);
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

}
