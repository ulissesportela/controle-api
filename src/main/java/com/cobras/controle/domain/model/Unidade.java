package com.cobras.controle.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

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
	//Tabela com o cadastro das Unidades
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unidade_sequence")
	@SequenceGenerator(name="unidade_sequence", sequenceName="seq_und", allocationSize=1)
	@Column(name="NR_UND")
	private Long id;
	//PK Tabela Unidade
	
	@NotBlank
	@Size(max = 50)
	@Column(name="TX_NM_UND")
	private String nome;
	//Nome da Unidade
	
	@NotBlank
	@Size(max = 4)
	@Column(name="CD_UND")
	private String codigo;
	//Código da unidade
	
	@NotNull
	@Column(name="NR_TIP_UND")
	private Long tipo;
	//PK tabela Tipo Unidade
	
	@NotNull
	@Column(name="NR_CID")
	private Long cidade;
	//FK tabela Cidade
	
	
	@Email
	@Size(max = 30)
	@Column(name="TX_EMAI_UND")
	private String email;
	//E-mail da Unidade
	
	@Size(max = 11)
	@Column(name="TX_TEL_UND")
	private String telefone;
	//Telefone da Unidade
	
	@Column(name="IN_UND_ATV")
	private char ativo;
	//1 = Sim 0 = Não
	
	//@Column(name="DT_HH_CAD_UND")
	//private LocalDate dataCadastro;
	////Data Hora Cadastro Unidade
	
	@Size(max = 30)
	@Column(name="TX_JST_UND_IATV")
	private String justificativa;
	//Texto com a justificativa da inatividade da unidade
}
