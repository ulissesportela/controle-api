package com.cobras.controle.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

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
	@Column(name = "nr_mun")
	private Long id;
	
	@Column(name = "cd_mun")
	private String codigo;
	
	@Column(name = "cd_mun_cmt")
	private String codigoCompleto;
	
	@Column(name = "nm_mun")
	@Max(value = 50)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="nr_und_fdrl", insertable = false, updatable = false)
	private Estado estado;

}
