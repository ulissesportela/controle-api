/*DROP SCHEMA public CASCADE;
CREATE SCHEMA public;*/


CREATE SEQUENCE public.seq_mun; 
CREATE SEQUENCE public.seq_tip_und;
CREATE SEQUENCE public.seq_und;
CREATE SEQUENCE public.seq_und_fdrl;   


CREATE TABLE public.tip_und (
	NR_TIP_UND SMALLINT NOT null DEFAULT nextval('public.seq_tip_und'),
	nm_tip_und bpchar(30) NOT NULL,
	CONSTRAINT pk_tip_und PRIMARY KEY (nr_tip_und)
);
CREATE UNIQUE INDEX idx_tip_und ON public.tip_und USING btree (nr_tip_und);
COMMENT ON TABLE public.TIP_UND IS 'Tipos de Unidade do Sistema';
COMMENT ON COLUMN public.TIP_UND.NR_TIP_UND IS 'PK tabela Tipo Unidade';
COMMENT ON COLUMN public.TIP_UND.NM_TIP_UND IS 'Nome do Tipo Unidade';
-- public.und_fdrl definition

-- Drop table

-- DROP TABLE public.und_fdrl;

CREATE TABLE public.und_fdrl (
	nr_und_fdrl smallserial NOT NULL,
	nm_und_fdrl bpchar(30) NOT NULL,
	sg_und_fdrl bpchar(2) NOT NULL,
	cd_und_fdrl bpchar(2) NOT NULL,
	CONSTRAINT pk_und_fdrl PRIMARY KEY (nr_und_fdrl)
);
CREATE UNIQUE INDEX idx_und_fdrl ON public.und_fdrl USING btree (nr_und_fdrl);


-- public.mun definition

-- Drop table

-- DROP TABLE public.mun;

CREATE TABLE public.mun (
	nr_mun SMALLINT NOT null DEFAULT nextval('public.seq_mun'),
	cd_mun bpchar(5) NOT NULL,
	nr_und_fdrl int2 NOT NULL,
	cd_mun_cmt bpchar(7) NOT NULL,
	nm_mun bpchar(50) NOT NULL,
	CONSTRAINT pk_mun PRIMARY KEY (nr_mun),
	CONSTRAINT fk_und_fdrl_mun FOREIGN KEY (nr_und_fdrl) REFERENCES und_fdrl(nr_und_fdrl)
);
CREATE UNIQUE INDEX idx_mun ON public.mun USING btree (nr_mun);
CREATE INDEX idx_und_fdrl_mun ON public.mun USING btree (nr_und_fdrl);

COMMENT ON TABLE public.MUN IS 'Tabela com o cadastro dos municípios';
COMMENT ON COLUMN public.MUN.NR_MUN IS 'PK tabela Município';
COMMENT ON COLUMN public.MUN.CD_MUN IS 'Código Município';
COMMENT ON COLUMN public.MUN.CD_MUN_CMT IS 'Código Município Completo';
COMMENT ON COLUMN public.MUN.NM_MUN IS 'Nome do Município';
COMMENT ON COLUMN public.MUN.NR_UND_FDRL IS 'FK tabela Unidade Federal';

-- public.und definition

-- Drop table

-- DROP TABLE public.und;

CREATE TABLE public.und (
	NR_UND INTEGER NOT null DEFAULT nextval('public.seq_und'),
	nm_und bpchar(100) NOT NULL,
	cd_und bpchar(4) NOT NULL,
	tx_emai_und bpchar(100) NULL,
	tx_tel_und bpchar(11) NULL,
	in_est_und_atv bpchar(1) NOT NULL DEFAULT '1',
	ts_cad_und timestamp NOT NULL DEFAULT now(),
	tx_jst_und_iatv varchar(255) NULL,
	nm_rsp_und bpchar(100) NULL,
	nr_mun int2 NOT NULL,
	nr_tip_und int2 NOT NULL,
	CONSTRAINT ck_in_est_und_atv CHECK ((in_est_und_atv = ANY (ARRAY['1'::bpchar, '0'::bpchar]))),
	CONSTRAINT uk_und_cd_und UNIQUE (cd_und),
	CONSTRAINT pk_und PRIMARY KEY (nr_und),
	CONSTRAINT fk_mun_und FOREIGN KEY (nr_mun) REFERENCES mun(nr_mun),
	CONSTRAINT fk_tip_und_und FOREIGN KEY (nr_tip_und) REFERENCES tip_und(nr_tip_und)
);
CREATE INDEX idx_mun_und ON public.und USING btree (nr_mun);
CREATE INDEX idx_tip_und_und ON public.und USING btree (nr_tip_und);
CREATE UNIQUE INDEX idx_und ON public.und USING btree (nr_und);

COMMENT ON TABLE public.UND IS 'Tabela com o cadastro das Unidades';
COMMENT ON COLUMN public.UND.NR_UND IS 'PK Tabela Unidade';
COMMENT ON COLUMN public.UND.NR_MUN IS 'FK tabela Cidade';
COMMENT ON COLUMN public.UND.NR_TIP_UND IS 'FK tabela Tipo Unidade';
COMMENT ON COLUMN public.UND.NM_UND IS 'Nome da Unidade';
COMMENT ON COLUMN public.UND.CD_UND IS 'Código da unidade';
COMMENT ON COLUMN public.UND.TX_EMAI_UND IS 'Email da Unidade';
COMMENT ON COLUMN public.UND.TX_TEL_UND IS 'Telefone da Unidade';
COMMENT ON COLUMN public.UND.TS_CAD_UND IS 'Data Hora Cadastro Unidade';
COMMENT ON COLUMN public.UND.IN_EST_UND_ATV IS '1 = Sim,0 = Não';
COMMENT ON COLUMN public.UND.TX_JST_UND_IATV IS 'Texto com a justificativa da inatividade da unidade';
COMMENT ON COLUMN public.UND.TX_JST_UND_IATV IS 'Nome Responsável pela Unidade';