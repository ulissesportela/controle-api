
/*public.mun*/
ALTER TABLE public.mun ALTER COLUMN cd_mun TYPE varchar(5) USING cd_mun::varchar;
ALTER TABLE public.mun ALTER COLUMN cd_mun_cmt TYPE varchar(7) USING cd_mun_cmt::varchar;
ALTER TABLE public.mun ALTER COLUMN nm_mun TYPE varchar(50) USING nm_mun::varchar;

/*public.tip_und*/
ALTER TABLE public.tip_und ALTER COLUMN nm_tip_und TYPE varchar(30) USING nm_tip_und::varchar;


/*public.und*/
ALTER TABLE public.und ALTER COLUMN nm_und TYPE varchar(100) USING nm_und::varchar;
ALTER TABLE public.und ALTER COLUMN cd_und TYPE varchar(4) USING cd_und::varchar;
ALTER TABLE public.und ALTER COLUMN tx_emai_und TYPE varchar(100) USING tx_emai_und::varchar;
ALTER TABLE public.und ALTER COLUMN tx_tel_und TYPE varchar(11) USING tx_tel_und::varchar; 
ALTER TABLE public.und ALTER COLUMN nm_rsp_und TYPE varchar(100) USING nm_rsp_und::varchar;

/*public.und_fdrl*/
ALTER TABLE public.und_fdrl ALTER COLUMN nm_und_fdrl TYPE varchar(30) USING nm_und_fdrl::varchar;
ALTER TABLE public.und_fdrl ALTER COLUMN sg_und_fdrl TYPE varchar(2) USING sg_und_fdrl::varchar;
ALTER TABLE public.und_fdrl ALTER COLUMN cd_und_fdrl TYPE varchar(2) USING cd_und_fdrl::varchar;