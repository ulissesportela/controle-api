package com.cobras.controle.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Builder
@Entity
@Table(name="und")
//Tabela com o cadastro das Unidades
public class Unidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unidade_sequence")
	@SequenceGenerator(name="unidade_sequence", sequenceName="seq_und", allocationSize=1)
	@Column(name="NR_UND")
	//PK Tabela Unidade
	private Long id;
	
	@NotBlank(message = "O nome da unidade nao pode ser vazio")
	@Size(max = 50)
	@Column(name="NM_UND")
	//Nome da Unidade
	private String nome;
	
	@NotNull
	@Size(max = 4)
	@Column(name="CD_UND")
	@NotBlank(message = "O codigo da Unidade nao pode ser vazio")
	//Codigo da unidade
	private String codigo;
	
	@NotNull
	@NotBlank(message = "O Tipo da Unidade nao pode ser vazio")
	@Column(name="NR_TIP_UND")
	@Enumerated(EnumType.ORDINAL)
	//PK tabela Tipo Unidade
	private TipoUnidade tipo;
	
	@NotNull
	@Column(name="NR_MUN")
	//FK tabela Cidade
	private Long cidade;
	
	@Email
	@Size(max = 30)
	@Column(name="TX_EMAI_UND")
	//E-mail da Unidade
	private String email;
	
	@Size(max = 11)
	@Column(name="TX_TEL_UND")
	//Telefone da Unidade
	private String telefone;
	
	@Column(name="IN_UND_ATV")
	//1 = Sim 0 = Nao
	private char ativo;
	
	@Size(max = 30)
	@Column(name="TX_JST_UND_IATV")
	//Texto com a justificativa da inatividade da unidade
	private String justificativa;
	
}
