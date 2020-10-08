
CREATE SEQUENCE public.seq_pss;

CREATE TABLE public.PSS (
                NR_PSS NUMERIC(8) NOT NULL DEFAULT nextval('public.seq_pss'),
                TX_NM_PSS VARCHAR(60) NOT NULL,
                TX_CPF_PSS VARCHAR(11) NOT NULL,
                TX_REG_GRL_PSS VARCHAR(9) NOT NULL,
                TX_TCEL_PSS VARCHAR(11) NOT NULL,
                TX_TEL_CML_PSS VARCHAR(11),
                TX_EMAI_PSS VARCHAR(30),
                DT_HH_CAD_PSS TIMESTAMP NOT NULL,
                CONSTRAINT nr_pss PRIMARY KEY (NR_PSS)
);
COMMENT ON TABLE public.PSS IS 'Tabela com o cadastro das pessoas';
COMMENT ON COLUMN public.PSS.NR_PSS IS 'PK tabela pessoa';
COMMENT ON COLUMN public.PSS.TX_NM_PSS IS 'Nome da Pessoa';
COMMENT ON COLUMN public.PSS.TX_CPF_PSS IS 'Cpf da Pessoa';
COMMENT ON COLUMN public.PSS.TX_REG_GRL_PSS IS 'Rg da pessoa';
COMMENT ON COLUMN public.PSS.TX_TCEL_PSS IS 'telefone celular da pessoa';
COMMENT ON COLUMN public.PSS.TX_TEL_CML_PSS IS 'Telefone comercial da pessoa';
COMMENT ON COLUMN public.PSS.TX_EMAI_PSS IS 'Email da pessoa';
COMMENT ON COLUMN public.PSS.DT_HH_CAD_PSS IS 'Data hora cadastro pessoa';


ALTER SEQUENCE public.seq_pss OWNED BY public.PSS.NR_PSS;

CREATE SEQUENCE public.seq_und;

CREATE TABLE public.UND (
                NR_UND NUMERIC(5) NOT NULL DEFAULT nextval('public.seq_und'),
                TX_NM_UND VARCHAR(50) NOT NULL,
                CD_UND VARCHAR(4) NOT NULL,
                CONSTRAINT nr_und PRIMARY KEY (NR_UND)
);
COMMENT ON TABLE public.UND IS 'Tabela com o cadastro das Unidades';
COMMENT ON COLUMN public.UND.NR_UND IS 'PK tabela Unidade';
COMMENT ON COLUMN public.UND.TX_NM_UND IS 'Nome da Unidade';
COMMENT ON COLUMN public.UND.CD_UND IS 'Código da unidade';


ALTER SEQUENCE public.seq_und OWNED BY public.UND.NR_UND;

CREATE SEQUENCE public.seq_usu_sis;

CREATE TABLE public.USU_SIS (
                NR_USU_SIS NUMERIC(5) NOT NULL DEFAULT nextval('public.seq_usu_sis'),
                TX_SNH_USU_SIS VARCHAR(10) NOT NULL,
                IN_USU_SIS_ATI CHAR(1) DEFAULT 1 NOT NULL,
                CD_CHV_SSBB VARCHAR(8),
                NR_PSS NUMERIC(8) NOT NULL,
                CONSTRAINT nr_usu_sis PRIMARY KEY (NR_USU_SIS)
);
COMMENT ON TABLE public.USU_SIS IS 'Tabela com o cadastro de usuários do sistema';
COMMENT ON COLUMN public.USU_SIS.NR_USU_SIS IS 'Pk tabela Usuário Sistema';
COMMENT ON COLUMN public.USU_SIS.TX_SNH_USU_SIS IS 'Senha do usuário sistema';
COMMENT ON COLUMN public.USU_SIS.IN_USU_SIS_ATI IS 'Ativo(1 =Sim ou 0=Não)';
COMMENT ON COLUMN public.USU_SIS.CD_CHV_SSBB IS 'Chave sissbb';
COMMENT ON COLUMN public.USU_SIS.NR_PSS IS 'PK tabela pessoa';


ALTER SEQUENCE public.seq_usu_sis OWNED BY public.USU_SIS.NR_USU_SIS;

CREATE SEQUENCE public.seq_menu;

CREATE TABLE public.MENU (
                NR_MENU NUMERIC(3) NOT NULL DEFAULT nextval('public.seq_menu'),
                TX_DCR_MENU VARCHAR(30) NOT NULL,
                IN_SIS_MENU CHAR(1) NOT NULL,
                NR_MENU_PAI NUMERIC(3),
                CONSTRAINT nr_menu PRIMARY KEY (NR_MENU)
);
COMMENT ON TABLE public.MENU IS 'Cadastro de menus do sistema';
COMMENT ON COLUMN public.MENU.NR_MENU IS 'Pk tabela Menu';
COMMENT ON COLUMN public.MENU.TX_DCR_MENU IS 'Descrição menu';
COMMENT ON COLUMN public.MENU.IN_SIS_MENU IS 'W=Web
M=Mobile';
COMMENT ON COLUMN public.MENU.NR_MENU_PAI IS 'FK tabela Menu';


ALTER SEQUENCE public.seq_menu OWNED BY public.MENU.NR_MENU;

CREATE SEQUENCE public.seq_prfl_;

CREATE TABLE public.PRFL (
                NR_PRFL NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_prfl_'),
                TX_NM_PRFL VARCHAR(30) NOT NULL,
                CONSTRAINT nr_prfl PRIMARY KEY (NR_PRFL)
);
COMMENT ON TABLE public.PRFL IS 'Tabela com o cadastro de perfis de usuário do sistema';
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
COMMENT ON TABLE public.PRFL_MENU IS 'Tabela com o vínculo entre os perfis e os menus exibidos no sistema';
COMMENT ON COLUMN public.PRFL_MENU.NR_PRFL_MENU IS 'PK tabela Perfil Menu';
COMMENT ON COLUMN public.PRFL_MENU.NR_MENU IS 'FK tabela Menu';
COMMENT ON COLUMN public.PRFL_MENU.NR_PRFL IS 'FK tabela Perfil';


ALTER SEQUENCE public.seq_prfl_menu OWNED BY public.PRFL_MENU.NR_PRFL_MENU;

CREATE SEQUENCE public.seq_prfl_und_usu;

CREATE TABLE public.PRFL_UND_USU (
                NR_PRFL_UND_USU NUMERIC(4) NOT NULL DEFAULT nextval('public.seq_prfl_und_usu'),
                NR_PRFL NUMERIC(4) NOT NULL,
                NR_UND NUMERIC(5) NOT NULL,
                NR_USU_SIS NUMERIC(5) NOT NULL,
                CONSTRAINT nr_prfl_und_usu PRIMARY KEY (NR_PRFL_UND_USU)
);
COMMENT ON TABLE public.PRFL_UND_USU IS 'Tabela de vinculo entre usuário perfil e unidade';
COMMENT ON COLUMN public.PRFL_UND_USU.NR_PRFL_UND_USU IS 'PK tabela Perfil Unidade Usuário';
COMMENT ON COLUMN public.PRFL_UND_USU.NR_PRFL IS 'FK tabela Perfil';
COMMENT ON COLUMN public.PRFL_UND_USU.NR_UND IS 'FK tabela Unidade';
COMMENT ON COLUMN public.PRFL_UND_USU.NR_USU_SIS IS 'FK tabela Usuario Sistema';


ALTER SEQUENCE public.seq_prfl_und_usu OWNED BY public.PRFL_UND_USU.NR_PRFL_UND_USU;

ALTER TABLE public.USU_SIS ADD CONSTRAINT pss_usu_sis_fk
FOREIGN KEY (NR_PSS)
REFERENCES public.PSS (NR_PSS)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_UND_USU ADD CONSTRAINT und_prfl_und_usu_fk
FOREIGN KEY (NR_UND)
REFERENCES public.UND (NR_UND)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.PRFL_UND_USU ADD CONSTRAINT usu_sis_prfl_und_usu_fk
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

ALTER TABLE public.PRFL_UND_USU ADD CONSTRAINT prfl_prfl_und_usu_fk
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