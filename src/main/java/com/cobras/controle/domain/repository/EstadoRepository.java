package com.cobras.controle.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.dto.EstadoDTO;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	@Query(value = "SELECT new com.cobras.controle.domain.model.dto.EstadoDTO"
			+ "(e.id, e.codigo, e.nome, e.sigla) FROM Estado e")
	List<EstadoDTO> findEstados();

}
