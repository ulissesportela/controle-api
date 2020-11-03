package com.cobras.controle.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.repository.EstadoRepository;
import com.cobras.controle.domain.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

}
