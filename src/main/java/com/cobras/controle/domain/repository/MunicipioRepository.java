package com.cobras.controle.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cobras.controle.domain.model.Municipio;
import com.cobras.controle.domain.model.dto.MunicipioDTO;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	
	List<Municipio> findByEstado(Long estado);
	
	@Query(value = "Select new com.cobras.controle.domain.model.dto.MunicipioDTO(m.id,"
			+ "m.codigo, m.codigoCompleto, m.nome, e.id, e.codigo,e.nome,e.sigla) "
			+ "FROM Municipio m inner join m.estado e WHERE e.id = :id")
	List<MunicipioDTO> findByEstadoId(Long id);

}
