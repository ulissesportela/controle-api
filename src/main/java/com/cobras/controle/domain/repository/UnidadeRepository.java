package com.cobras.controle.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cobras.controle.domain.model.Unidade;
import com.cobras.controle.domain.model.dto.UnidadeDTO;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	List<Unidade> findByNome(String nome);

	List<Unidade> findByNomeContaining(String nome);

	Unidade findByCodigo(String codigo);

	Unidade findByEmail(String email);

	List<Unidade> findByCodigoAndNomeAndResponsavel(String codigo, 
			String nome, String responsavel);

	Optional<Unidade> findByCodigoAndNome(String codigo, String nome);

	List<Unidade> findByCodigoAndNomeAndResponsavelAndAtivo(String codigo, 
			String nome, String responsavel, char ativo);
	
	@Query(value = "select u.nr_und, u.cd_und, u.in_est_und_atv,u.nm_rsp_und, u.nm_und,"
			+ "u.tx_emai_und, u.tx_jst_und_iatv, u.tx_tel_und, u.nr_tip_und,"
			+ "m.nr_mun, m.cd_mun, m.cd_mun_cmt, m.nm_mun,"
			+ "uf.nr_und_fdrl, uf.cd_und_fdrl, uf.nm_und_fdrl, uf.sg_und_fdrl "
			+ "from public.und u inner join PUBLIC.mun m on (u.nr_mun = m.nr_mun) "
			+ "inner join public.und_fdrl uf on (uf.nr_und_fdrl = m.nr_und_fdrl) " + 
			"where u.cd_und = :codigo and u.nm_und = :nome and u.nm_rsp_und = :responsavel "
			+ "and u.in_est_und_atv = :ativo"
			+ " and m.nome = :nomeMunicipio and uf.nm_und_fdrl =:nomeEstado", nativeQuery = true)
	List<UnidadeDTO> findByParametros(@Param("codigo") String codigo, 
			@Param("nome") String nome, @Param("responsavel")  String responsavel, 
			@Param("ativo") char ativo,@Param("nomeMunicipio") String nomeMunicipio, 
			@Param("nomeEstado") String nomeEstado);

}
