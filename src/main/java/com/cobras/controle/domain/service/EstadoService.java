package com.cobras.controle.domain.service;

import java.util.List;

import com.cobras.controle.domain.model.dto.EstadoDTO;

public interface EstadoService {

	List<EstadoDTO> findEstados();
}
