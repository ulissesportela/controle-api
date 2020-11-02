package com.cobras.controle.domain.service;

import java.util.List;

import com.cobras.controle.domain.model.dto.MunicipioDTO;

public interface MunicipioService {

	List<MunicipioDTO> findByEstadoId(Long id);
}
