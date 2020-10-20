/*DROP SCHEMA public CASCADE;
CREATE SCHEMA public;*/



CREATE SEQUENCE public.seq_tip_und;

CREATE TABLE public.TIP_UND (
                NR_TIP_UND NUMERIC(3) NOT NULL DEFAULT nextval('public.seq_tip_und'),
                NM_TIP_UND VARCHAR(30) NOT NULL,
                CONSTRAINT nr_tip_und PRIMARY KEY (NR_TIP_UND)
);
COMMENT ON TABLE public.TIP_UND IS 'Tipos de Unidade do Sistema';
COMMENT ON COLUMN public.TIP_UND.NR_TIP_UND IS 'PK tabela Tipo Unidade';
COMMENT ON COLUMN public.TIP_UND.NM_TIP_UND IS 'Nome do Tipo Unidade';


ALTER SEQUENCE public.seq_tip_und OWNED BY public.TIP_UND.NR_TIP_UND;

CREATE SEQUENCE public.seq_prm_sis;

CREATE TABLE public.PRM_SIS (
                NR_PRM_SIS NUMERIC(2) NOT NULL DEFAULT nextval('public.seq_prm_sis'),
                IN_AMB CHAR(1) NOT NULL,
                NR_MNTO_SSS_USU NUMERIC(3) NOT NULL,
                CONSTRAINT nr_prm_sis PRIMARY KEY (NR_PRM_SIS)
);
COMMENT ON TABLE public.PRM_SIS IS 'Tabela com o cadastro dos parâmetros do sistema';
COMMENT ON COLUMN public.PRM_SIS.NR_PRM_SIS IS 'PK tabela Parâmetro Sistema';
COMMENT ON COLUMN public.PRM_SIS.IN_AMB IS 'W=Web
M=Mobile';
COMMENT ON COLUMN public.PRM_SIS.NR_MNTO_SSS_USU IS 'Número de minutos de sessão do usuário';


ALTER SEQUENCE public.seq_prm_sis OWNED BY public.PRM_SIS.NR_PRM_SIS;

CREATE SEQUENCE public.seq_und_fdrl;

CREATE TABLE public.UND_FDRL (
                NR_UND_FDRL NUMERIC(2) NOT NULL DEFAULT nextval('public.seq_und_fdrl'),
                CD_UND_FDRL VARCHAR(2) NOT NULL,
                NM_UND_FDRL VARCHAR(30) NOT NULL,
                SG_UND_FDRL VARCHAR(2) NOT NULL,
                CONSTRAINT nr_und_fdrl PRIMARY KEY (NR_UND_FDRL)
);
COMMENT ON TABLE public.UND_FDRL IS 'Tabela com o cadastro dos estados';
COMMENT ON COLUMN public.UND_FDRL.NR_UND_FDRL IS 'PK tabela Unidade Federal';
COMMENT ON COLUMN public.UND_FDRL.CD_UND_FDRL IS 'Código da Unidade Federal (SP,DF,etc)';
COMMENT ON COLUMN public.UND_FDRL.NM_UND_FDRL IS 'Nome da unidade federal';
COMMENT ON COLUMN public.UND_FDRL.SG_UND_FDRL IS 'Sigla Unidade Federal(DF,SP,RJ)';


ALTER SEQUENCE public.seq_und_fdrl OWNED BY public.UND_FDRL.NR_UND_FDRL;

CREATE SEQUENCE public.seq_mun;

CREATE TABLE public.MUN (
                NR_MUN NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_mun'),
                CD_MUN VARCHAR(5) NOT NULL,
                CD_MUN_CMT VARCHAR(7) NOT NULL,
                NM_MUN VARCHAR(50) NOT NULL,
                NR_UND_FDRL NUMERIC(2) NOT NULL,
                CONSTRAINT nr_mun PRIMARY KEY (NR_MUN)
);
COMMENT ON TABLE public.MUN IS 'Tabela com o cadastro dos municípios';
COMMENT ON COLUMN public.MUN.NR_MUN IS 'PK tabela Município';
COMMENT ON COLUMN public.MUN.CD_MUN IS 'Código Município';
COMMENT ON COLUMN public.MUN.CD_MUN_CMT IS 'Código Município Completo';
COMMENT ON COLUMN public.MUN.NM_MUN IS 'Nome do Município';
COMMENT ON COLUMN public.MUN.NR_UND_FDRL IS 'PK tabela Unidade Federal';


ALTER SEQUENCE public.seq_mun OWNED BY public.MUN.NR_MUN;

CREATE SEQUENCE public.seq_und;

CREATE TABLE public.UND (
                NR_UND NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_und'),
                NR_MUN NUMERIC(4) NOT NULL,
                NR_TIP_UND NUMERIC(3) NOT NULL,
                TX_EMAI_UND VARCHAR(30),
                CD_UND VARCHAR(4) NOT NULL,
                TX_TEL_UND VARCHAR(11),
                TX_NM_UND VARCHAR(50) NOT NULL,
                IN_UND_ATV CHAR(1) NOT NULL,
                DT_HH_CAD_UND TIMESTAMP NOT NULL,
                TX_JST_UND_IATV VARCHAR(30),
                CONSTRAINT nr_und PRIMARY KEY (NR_UND)
);
COMMENT ON TABLE public.UND IS 'Tabela com o cadastro das Unidades';
COMMENT ON COLUMN public.UND.NR_UND IS 'PK Tabela Unidade';
COMMENT ON COLUMN public.UND.NR_MUN IS 'FK tabela Cidade';
COMMENT ON COLUMN public.UND.NR_TIP_UND IS 'PK tabela Tipo Unidade';
COMMENT ON COLUMN public.UND.TX_EMAI_UND IS 'Email da Unidade';
COMMENT ON COLUMN public.UND.CD_UND IS 'Código da unidade';
COMMENT ON COLUMN public.UND.TX_TEL_UND IS 'Telefone da Unidade';
COMMENT ON COLUMN public.UND.TX_NM_UND IS 'Nome da Unidade';
COMMENT ON COLUMN public.UND.IN_UND_ATV IS '1 = Sim
0 = Não';
COMMENT ON COLUMN public.UND.DT_HH_CAD_UND IS 'Data Hora Cadastro Unidade';
COMMENT ON COLUMN public.UND.TX_JST_UND_IATV IS 'Texto com a justificativa da inatividade da unidade';


ALTER SEQUENCE public.seq_und OWNED BY public.UND.NR_UND;

CREATE SEQUENCE public.seq_prfl;

CREATE TABLE public.PRFL (
                NR_PRFL NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_prfl'),
                NM_PRFL VARCHAR(30) NOT NULL,
                CONSTRAINT nr_prfl PRIMARY KEY (NR_PRFL)
);
COMMENT ON TABLE public.PRFL IS 'Tabela com o cadastro de perfis de usuário do sistema';
COMMENT ON COLUMN public.PRFL.NR_PRFL IS 'PK tabela Perfil';
COMMENT ON COLUMN public.PRFL.NM_PRFL IS 'Nome Perfil';


ALTER SEQUENCE public.seq_prfl OWNED BY public.PRFL.NR_PRFL;

CREATE SEQUENCE public.seq_usu_sis;

CREATE TABLE public.USU_SIS (
                NR_USU_SIS NUMERIC(6) NOT NULL DEFAULT nextval('public.seq_usu_sis'),
                NR_PRFL NUMERIC(4) NOT NULL,
                NM_USU_SIS VARCHAR(60) NOT NULL,
                TX_CPF_USU_SIS VARCHAR(11) NOT NULL,
                TX_TCEL_USU_SIS VARCHAR(11) NOT NULL,
                TX_EMAI_USU_SIS VARCHAR(30) NOT NULL,
                TX_SNH_USU_SIS VARCHAR(11),
                IN_USU_SIS_ATI CHAR(1) DEFAULT 1 NOT NULL,
                DT_HH_CAD_USU_SIS TIMESTAMP NOT NULL,
                CONSTRAINT nr_usu_sis PRIMARY KEY (NR_USU_SIS)
);
COMMENT ON TABLE public.USU_SIS IS 'Tabela com o cadastro de usuários do sistema';
COMMENT ON COLUMN public.USU_SIS.NR_USU_SIS IS 'Pk tabela Usuário Sistema';
COMMENT ON COLUMN public.USU_SIS.NR_PRFL IS 'PK tabela Perfil';
COMMENT ON COLUMN public.USU_SIS.NM_USU_SIS IS 'Nome Usuário Sistema';
COMMENT ON COLUMN public.USU_SIS.TX_CPF_USU_SIS IS 'Texto CPF Usuário Sistema';
COMMENT ON COLUMN public.USU_SIS.TX_TCEL_USU_SIS IS 'Texto Telefone Celular Usuário Sistema';
COMMENT ON COLUMN public.USU_SIS.TX_EMAI_USU_SIS IS 'Texto Email Usuário Sistema';
COMMENT ON COLUMN public.USU_SIS.TX_SNH_USU_SIS IS 'Senha do usuário sistema';
COMMENT ON COLUMN public.USU_SIS.IN_USU_SIS_ATI IS 'Ativo(1 =Sim ou 0=Não)';
COMMENT ON COLUMN public.USU_SIS.DT_HH_CAD_USU_SIS IS 'Data Hora Cadastro Usuário Sistema';


ALTER SEQUENCE public.seq_usu_sis OWNED BY public.USU_SIS.NR_USU_SIS;

CREATE SEQUENCE public.seq_und_usu;

CREATE TABLE public.UND_USU_SIS (
                NR_UND_USU_SIS NUMERIC(6) NOT NULL DEFAULT nextval('public.seq_und_usu'),
                DT_HH_CAD_UND_USU_SIS TIMESTAMP NOT NULL,
                IN_UND_USU_SIS_ATI CHAR(1) NOT NULL,
                TX_JST_UND_USU_IATV VARCHAR(30),
                NR_UND NUMERIC(4) NOT NULL,
                NR_USU_SIS NUMERIC(6) NOT NULL,
                CONSTRAINT nr_und_usu_sis PRIMARY KEY (NR_UND_USU_SIS)
);
COMMENT ON TABLE public.UND_USU_SIS IS 'Tabela de vinculo entre unidade e usuários do sistema';
COMMENT ON COLUMN public.UND_USU_SIS.NR_UND_USU_SIS IS 'PK tabela Unidade Usuário Sistema';
COMMENT ON COLUMN public.UND_USU_SIS.DT_HH_CAD_UND_USU_SIS IS 'Data Hora Cadastro Unidade Usuário Sistema';
COMMENT ON COLUMN public.UND_USU_SIS.IN_UND_USU_SIS_ATI IS 'Indicador Unidade Usuário Sistema Ativo 
Ativo = 1
Inativo = 0';
COMMENT ON COLUMN public.UND_USU_SIS.TX_JST_UND_USU_IATV IS 'Texto Justificativa Unidade Usuário Inativo';
COMMENT ON COLUMN public.UND_USU_SIS.NR_UND IS 'PK Tabela Unidade';
COMMENT ON COLUMN public.UND_USU_SIS.NR_USU_SIS IS 'Pk tabela Usuário Sistema';


ALTER SEQUENCE public.seq_und_usu OWNED BY public.UND_USU_SIS.NR_UND_USU_SIS;

ALTER TABLE public.UND ADD CONSTRAINT tip_und_und_fk
FOREIGN KEY (NR_TIP_UND)
REFERENCES public.TIP_UND (NR_TIP_UND)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.MUN ADD CONSTRAINT und_fdrl_cid_fk
FOREIGN KEY (NR_UND_FDRL)
REFERENCES public.UND_FDRL (NR_UND_FDRL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.UND ADD CONSTRAINT cid_und_fk
FOREIGN KEY (NR_MUN)
REFERENCES public.MUN (NR_MUN)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.UND_USU_SIS ADD CONSTRAINT und_und_usu_sis_fk
FOREIGN KEY (NR_UND)
REFERENCES public.UND (NR_UND)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.USU_SIS ADD CONSTRAINT prfl_usu_sis_fk
FOREIGN KEY (NR_PRFL)
REFERENCES public.PRFL (NR_PRFL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.UND_USU_SIS ADD CONSTRAINT usu_sis_und_usu_sis_fk
FOREIGN KEY (NR_USU_SIS)
REFERENCES public.USU_SIS (NR_USU_SIS)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;