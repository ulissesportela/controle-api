package com.cobras.controle.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Builder
@Entity
@Table(name = "und")
//Tabela com o cadastro das Unidades
public class Unidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_sequence")
	@SequenceGenerator(name = "unidade_sequence", sequenceName = "seq_und", allocationSize = 1)
	@Column(name = "nr_und")
	// PK Tabela Unidade
	private Long id;

	@NotNull
	@Size(max = 4)
	@Column(name = "cd_und")
	@NotBlank(message = "O codigo da Unidade nao pode ser vazio")
	// Codigo da unidade
	private String codigo;
	
	@Column(name = "in_est_und_atv")
	// 1 = Sim 0 = Nao
	private char ativo;
	
	@Size(max = 100)
	@Column(name = "nm_rsp_und")
	private String responsavel;
	
	@NotBlank(message = "O nome da unidade nao pode ser vazio")
	@Size(max = 100)
	@Column(name = "nm_und")
	// Nome da Unidade
	private String nome;
	
	@Email
	@Size(max = 100)
	@Column(name = "tx_emai_und")
	// E-mail da Unidade
	private String email;

	@Size(max = 30)
	@Column(name = "tx_jst_und_iatv")
	// Texto com a justificativa da inatividade da unidade
	private String justificativa;

	@Size(max = 11)
	@Column(name = "tx_tel_und")
	// Telefone da Unidade
	private String telefone;

	@NotNull
	@Column(name="nr_mun")
	//FK tabela Cidade
	private Long cidade;
	
	@NotNull
	@Column(name = "nr_tip_und")
	@Enumerated(EnumType.ORDINAL)
	// PK tabela Tipo Unidade
	private TipoUnidade tipo;
}
