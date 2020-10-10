package com.cobras.controle.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@Entity
@Table(name="und")
public class Unidade {
	//Tabela com o cadastro das Unidade
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unidade_sequence")
	@SequenceGenerator(name="unidade_sequence", sequenceName="seq_und", allocationSize=1)
	@Column(name="NR_UND")
	private Long id;
	//PK Tabela Unidade
	
	@Column(name="TX_NM_UND")
	private String nome;
	//Nome da Unidade
	
	@Column(name="CD_UND")
	private String codigo;
	//Código da unidade
}

