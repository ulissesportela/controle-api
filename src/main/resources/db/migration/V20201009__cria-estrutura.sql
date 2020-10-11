
CREATE SEQUENCE public.tip_und_nr_tip_und_seq;

CREATE TABLE public.TIP_UND (
                NR_TIP_UND NUMERIC(3) NOT NULL DEFAULT nextval('public.tip_und_nr_tip_und_seq'),
                NM_TIP_UND VARCHAR(30) NOT NULL,
                CONSTRAINT nr_tip_und PRIMARY KEY (NR_TIP_UND)
);
COMMENT ON TABLE public.TIP_UND IS 'Tipos de Unidade do Sistema';
COMMENT ON COLUMN public.TIP_UND.NR_TIP_UND IS 'PK tabela Tipo Unidade';
COMMENT ON COLUMN public.TIP_UND.NM_TIP_UND IS 'Nome do Tipo Unidade';


ALTER SEQUENCE public.tip_und_nr_tip_und_seq OWNED BY public.TIP_UND.NR_TIP_UND;

CREATE SEQUENCE public.seq_prm_sis;

CREATE TABLE public.PARMETRO_SISTEMA (
                NR_PRM_SIS NUMERIC(2) NOT NULL DEFAULT nextval('public.seq_prm_sis'),
                IN_AMB CHAR(1) NOT NULL,
                NR_MNTO_SSS_USU NUMERIC(3) NOT NULL,
                CONSTRAINT nr_prm_sis PRIMARY KEY (NR_PRM_SIS)
);
COMMENT ON TABLE public.PARMETRO_SISTEMA IS 'Tabela com o cadastro dos par�metros do sistema';
COMMENT ON COLUMN public.PARMETRO_SISTEMA.NR_PRM_SIS IS 'PK tabela Par�metro Sistema';
COMMENT ON COLUMN public.PARMETRO_SISTEMA.IN_AMB IS 'W=Web
M=Mobile';
COMMENT ON COLUMN public.PARMETRO_SISTEMA.NR_MNTO_SSS_USU IS 'N�mero de minutos de sess�o do usu�rio';


ALTER SEQUENCE public.seq_prm_sis OWNED BY public.PARMETRO_SISTEMA.NR_PRM_SIS;

CREATE SEQUENCE public.seq_und_fdrl;

CREATE TABLE public.UND_FDRL (
                NR_UND_FDRL NUMERIC(2) NOT NULL DEFAULT nextval('public.seq_und_fdrl'),
                CD_UND_FDRL VARCHAR(2) NOT NULL,
                TX_NM_UND_FDRL VARCHAR(30) NOT NULL,
                CONSTRAINT nr_und_fdrl PRIMARY KEY (NR_UND_FDRL)
);
COMMENT ON TABLE public.UND_FDRL IS 'Tabela com o cadastro dos estados';
COMMENT ON COLUMN public.UND_FDRL.NR_UND_FDRL IS 'PK tabela Unidade Federal';
COMMENT ON COLUMN public.UND_FDRL.CD_UND_FDRL IS 'C�digo da Unidade Federal (SP,DF,etc)';
COMMENT ON COLUMN public.UND_FDRL.TX_NM_UND_FDRL IS 'Nome da unidade federal';


ALTER SEQUENCE public.seq_und_fdrl OWNED BY public.UND_FDRL.NR_UND_FDRL;

CREATE SEQUENCE public.seq_cid;

CREATE TABLE public.CID (
                NR_CID NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_cid'),
                TX_NM_CID VARCHAR(50) NOT NULL,
                NR_UND_FDRL NUMERIC(2) NOT NULL,
                CONSTRAINT nr_cid PRIMARY KEY (NR_CID)
);
COMMENT ON TABLE public.CID IS 'Tabela com o cadastro das cidades';
COMMENT ON COLUMN public.CID.NR_CID IS 'PK tabela Cidade';
COMMENT ON COLUMN public.CID.TX_NM_CID IS 'Nome da Cidade';
COMMENT ON COLUMN public.CID.NR_UND_FDRL IS 'PK tabela Unidade Federal';


ALTER SEQUENCE public.seq_cid OWNED BY public.CID.NR_CID;

CREATE SEQUENCE public.seq_pss;

CREATE TABLE public.PSS (
                NR_PSS NUMERIC(8) NOT NULL DEFAULT nextval('public.seq_pss'),
                TX_NM_PSS VARCHAR(60) NOT NULL,
                TX_CPF_PSS VARCHAR(11) NOT NULL,
                TX_TCEL_PSS VARCHAR(11) NOT NULL,
                TX_EMAI_PSS VARCHAR(30),
                DT_HH_CAD_PSS TIMESTAMP NOT NULL,
                CONSTRAINT nr_pss PRIMARY KEY (NR_PSS)
);
COMMENT ON TABLE public.PSS IS 'Tabela com o cadastro das pessoas';
COMMENT ON COLUMN public.PSS.NR_PSS IS 'PK tabela pessoa';
COMMENT ON COLUMN public.PSS.TX_NM_PSS IS 'Nome da Pessoa';
COMMENT ON COLUMN public.PSS.TX_CPF_PSS IS 'Cpf da Pessoa';
COMMENT ON COLUMN public.PSS.TX_TCEL_PSS IS 'telefone celular da pessoa';
COMMENT ON COLUMN public.PSS.TX_EMAI_PSS IS 'Email da pessoa';
COMMENT ON COLUMN public.PSS.DT_HH_CAD_PSS IS 'Data hora cadastro pessoa';


ALTER SEQUENCE public.seq_pss OWNED BY public.PSS.NR_PSS;

CREATE SEQUENCE public.seq_und;

CREATE TABLE public.UND (
                NR_UND NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_und'),
                NR_CID NUMERIC(4) NOT NULL,
                TX_EMAI_UND VARCHAR(30),
                CD_UND VARCHAR(4) NOT NULL,
                TX_TEL_UND VARCHAR(11),
                TX_NM_UND VARCHAR(50) NOT NULL,
                IN_UND_ATV CHAR(1) NOT NULL,
                DT_HH_CAD_UND TIMESTAMP NOT NULL,
                TX_JST_UND_IATV VARCHAR(30),
                NR_TIP_UND NUMERIC(3) NOT NULL,
                CONSTRAINT nr_und PRIMARY KEY (NR_UND)
);
COMMENT ON TABLE public.UND IS 'Tabela com o cadastro das Unidades';
COMMENT ON COLUMN public.UND.NR_UND IS 'PK Tabela Unidade';
COMMENT ON COLUMN public.UND.NR_CID IS 'FK tabela Cidade';
COMMENT ON COLUMN public.UND.TX_EMAI_UND IS 'Email da Unidade';
COMMENT ON COLUMN public.UND.CD_UND IS 'C�digo da unidade';
COMMENT ON COLUMN public.UND.TX_TEL_UND IS 'Telefone da Unidade';
COMMENT ON COLUMN public.UND.TX_NM_UND IS 'Nome da Unidade';
COMMENT ON COLUMN public.UND.IN_UND_ATV IS '1 = Sim
0 = N�o';
COMMENT ON COLUMN public.UND.DT_HH_CAD_UND IS 'Data Hora Cadastro Unidade';
COMMENT ON COLUMN public.UND.TX_JST_UND_IATV IS 'Texto com a justificativa da inatividade da unidade';
COMMENT ON COLUMN public.UND.NR_TIP_UND IS 'PK tabela Tipo Unidade';


ALTER SEQUENCE public.seq_und OWNED BY public.UND.NR_UND;

CREATE SEQUENCE public.seq_usu_sis;

CREATE TABLE public.USU_SIS (
                NR_USU_SIS NUMERIC(6) NOT NULL DEFAULT nextval('public.seq_usu_sis'),
                TX_SNH_USU_SIS VARCHAR(11) NOT NULL,
                IN_USU_SIS_ATI CHAR(1) DEFAULT 1 NOT NULL,
                CD_CHV_SSBB VARCHAR(8),
                NR_PSS NUMERIC(8) NOT NULL,
                DT_HH_CAD_USU_SIS TIMESTAMP NOT NULL,
                CONSTRAINT nr_usu_sis PRIMARY KEY (NR_USU_SIS)
);
COMMENT ON TABLE public.USU_SIS IS 'Tabela com o cadastro de usu�rios do sistema';
COMMENT ON COLUMN public.USU_SIS.NR_USU_SIS IS 'Pk tabela Usu�rio Sistema';
COMMENT ON COLUMN public.USU_SIS.TX_SNH_USU_SIS IS 'Senha do usu�rio sistema';
COMMENT ON COLUMN public.USU_SIS.IN_USU_SIS_ATI IS 'Ativo(1 =Sim ou 0=N�o)';
COMMENT ON COLUMN public.USU_SIS.CD_CHV_SSBB IS 'Chave sissbb';
COMMENT ON COLUMN public.USU_SIS.NR_PSS IS 'PK tabela pessoa';
COMMENT ON COLUMN public.USU_SIS.DT_HH_CAD_USU_SIS IS 'Data Hora Cadastro Usu�rio Sistema';


ALTER SEQUENCE public.seq_usu_sis OWNED BY public.USU_SIS.NR_USU_SIS;

CREATE SEQUENCE public.seq_menu;

CREATE TABLE public.MENU (
                NR_MENU NUMERIC(3) NOT NULL DEFAULT nextval('public.seq_menu'),
                TX_DCR_MENU VARCHAR(30) NOT NULL,
                IN_SIS_MENU CHAR(1) NOT NULL,
                CONSTRAINT nr_menu PRIMARY KEY (NR_MENU)
);
COMMENT ON TABLE public.MENU IS 'Cadastro de menus do sistema';
COMMENT ON COLUMN public.MENU.NR_MENU IS 'Pk tabela Menu';
COMMENT ON COLUMN public.MENU.TX_DCR_MENU IS 'Descri��o menu';
COMMENT ON COLUMN public.MENU.IN_SIS_MENU IS 'W=Web
M=Mobile';


ALTER SEQUENCE public.seq_menu OWNED BY public.MENU.NR_MENU;

CREATE SEQUENCE public.seq_prfl_;

CREATE TABLE public.PRFL (
                NR_PRFL NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_prfl_'),
                TX_NM_PRFL VARCHAR(30) NOT NULL,
                CONSTRAINT nr_prfl PRIMARY KEY (NR_PRFL)
);
COMMENT ON TABLE public.PRFL IS 'Tabela com o cadastro de perfis de usu�rio do sistema';
COMMENT ON COLUMN public.PRFL.NR_PRFL IS 'PK tabela Perfil';
COMMENT ON COLUMN public.PRFL.TX_NM_PRFL IS 'Nome Perfil';


ALTER SEQUENCE public.seq_prfl_ OWNED BY public.PRFL.NR_PRFL;

CREATE SEQUENCE public.seq_prfl_menu;

CREATE TABLE public.PRFL_MENU (
                NR_PRFL_MENU NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_prfl_menu'),
                NR_MENU NUMERIC(3) NOT NULL,
                NR_PRFL NUMERIC(4) NOT NULL,
                CONSTRAINT nr_prfl_menu PRIMARY KEY (NR_PRFL_MENU)
);
COMMENT ON TABLE public.PRFL_MENU IS 'Tabela com o v�nculo entre os perfis e os menus exibidos no sistema';
COMMENT ON COLUMN public.PRFL_MENU.NR_PRFL_MENU IS 'PK tabela Perfil Menu';
COMMENT ON COLUMN public.PRFL_MENU.NR_MENU IS 'FK tabela Menu';
COMMENT ON COLUMN public.PRFL_MENU.NR_PRFL IS 'FK tabela Perfil';


ALTER SEQUENCE public.seq_prfl_menu OWNED BY public.PRFL_MENU.NR_PRFL_MENU;

CREATE SEQUENCE public.seq_prfl_und_usu;

CREATE TABLE public.PRFL_UND_USU_SIS (
                NR_PRFL_UND_USU_SIS NUMERIC(6) NOT NULL DEFAULT nextval('public.seq_prfl_und_usu'),
                NR_PRFL NUMERIC(4) NOT NULL,
                NR_UND NUMERIC(4),
                NR_USU_SIS NUMERIC(6) NOT NULL,
                DT_HH_CAD_PRFL_UND_SIS TIMESTAMP NOT NULL,
                CONSTRAINT nr_prfl_und_usu_sis PRIMARY KEY (NR_PRFL_UND_USU_SIS)
);
COMMENT ON TABLE public.PRFL_UND_USU_SIS IS 'Tabela de vinculo entre usu�rio sistema, perfil e unidade';
COMMENT ON COLUMN public.PRFL_UND_USU_SIS.NR_PRFL_UND_USU_SIS IS 'PK tabela Perfil Unidade Usu�rio Sistema';
COMMENT ON COLUMN public.PRFL_UND_USU_SIS.NR_PRFL IS 'FK tabela Perfil';
COMMENT ON COLUMN public.PRFL_UND_USU_SIS.NR_UND IS 'FK Tabela Unidade';
COMMENT ON COLUMN public.PRFL_UND_USU_SIS.NR_USU_SIS IS 'FK tabela Usuario Sistema';
COMMENT ON COLUMN public.PRFL_UND_USU_SIS.DT_HH_CAD_PRFL_UND_SIS IS 'Data hora Cadastro Perfil Usu�rio Sistema';


ALTER SEQUENCE public.seq_prfl_und_usu OWNED BY public.PRFL_UND_USU_SIS.NR_PRFL_UND_USU_SIS;

ALTER TABLE public.UND ADD CONSTRAINT tip_und_und_fk
FOREIGN KEY (NR_TIP_UND)
REFERENCES public.TIP_UND (NR_TIP_UND)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CID ADD CONSTRAINT und_fdrl_cid_fk
FOREIGN KEY (NR_UND_FDRL)
REFERENCES public.UND_FDRL (NR_UND_FDRL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.UND ADD CONSTRAINT cid_und_fk
FOREIGN KEY (NR_CID)
REFERENCES public.CID (NR_CID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.USU_SIS ADD CONSTRAINT pss_usu_sis_fk
FOREIGN KEY (NR_PSS)
REFERENCES public.PSS (NR_PSS)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_UND_USU_SIS ADD CONSTRAINT und_prfl_und_usu_sis_fk
FOREIGN KEY (NR_UND)
REFERENCES public.UND (NR_UND)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_UND_USU_SIS ADD CONSTRAINT usu_sis_prfl_und_usu_fk
FOREIGN KEY (NR_USU_SIS)
REFERENCES public.USU_SIS (NR_USU_SIS)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_MENU ADD CONSTRAINT menu_prfl_menu_fk
FOREIGN KEY (NR_MENU)
REFERENCES public.MENU (NR_MENU)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_UND_USU_SIS ADD CONSTRAINT prfl_prfl_und_usu_fk
FOREIGN KEY (NR_PRFL)
REFERENCES public.PRFL (NR_PRFL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_MENU ADD CONSTRAINT prfl_prfl_menu_fk
FOREIGN KEY (NR_PRFL)
REFERENCES public.PRFL (NR_PRFL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;