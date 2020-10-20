package com.cobras.controle.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cobras.controle.domain.model.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	
	List<Municipio> findByEstado(Long estado);

}
