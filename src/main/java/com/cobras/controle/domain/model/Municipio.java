package com.cobras.controle.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mun")
public class Municipio {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="municipio_sequence")
	@SequenceGenerator(name="municipio_sequence", sequenceName="seq_mun", allocationSize=1)
	@Column(name = "NR_MUN")
	private Long id;
	
	@Column(name = "CD_MUN")
	private String codigo;
	
	@Column(name = "CD_MUN_CMT")
	private String codigoCompleto;
	
	@Column(name = "NM_MUN")
	private String nome;
	
	@Column(name = "NR_UND_FDRL")
	private long estado;

}
