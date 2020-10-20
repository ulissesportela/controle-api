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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "und_fdrl")
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estado_sequence")
	@SequenceGenerator(name="estado_sequence", sequenceName="seq_und_fdrl", allocationSize=1)
	@Column(name="NR_UND_FDRL")
	private Long id;
	
	@Column(name = "CD_UND_FDRL")
	private String codigo;
	
	@Column(name = "NM_UND_FDRL")
	private String nome;
	
	@Column(name = "SG_UND_FDRL")
    private String sigla;
}
