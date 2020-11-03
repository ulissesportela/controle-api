package com.cobras.controle.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobras.controle.domain.model.dto.MunicipioDTO;
import com.cobras.controle.domain.repository.MunicipioRepository;
import com.cobras.controle.domain.service.MunicipioService;

@Service
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;

	@Override
	public List<MunicipioDTO> findByEstadoId(Long id) {
		return municipioRepository.findByEstadoId(id);
	}

}
