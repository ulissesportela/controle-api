package com.cobras.controle.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "und_fdrl")
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estado_sequence")
	@SequenceGenerator(name="estado_sequence", sequenceName="seq_und_fdrl", allocationSize=1)
	@Column(name="nr_und_fdrl")
	private Long id;
	
	@Column(name = "cd_und_fdrl")
	private String codigo;
	
	@Column(name = "nm_und_fdrl")
	private String nome;
	
	@Column(name = "sg_und_fdrl")
    private String sigla;
	
}
