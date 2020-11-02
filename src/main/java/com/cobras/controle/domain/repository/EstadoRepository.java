package com.cobras.controle.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cobras.controle.domain.model.Estado;
import com.cobras.controle.domain.model.Municipio;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
