package com.cobras.controle.domain.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cobras.controle.domain.model.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>,
	PagingAndSortingRepository<Unidade, Long> {
	
	Page<Unidade> findAll(Pageable pageable);

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
			+ "u.tx_emai_und, u.tx_jst_und_iatv, u.tx_tel_und, u.nr_tip_und, u.nr_mun  "
			+ "from public.und u inner join PUBLIC.mun m on (u.nr_mun = m.nr_mun) "
			+ "inner join public.und_fdrl uf on (uf.nr_und_fdrl = m.nr_und_fdrl) " + 
			" where u.cd_und = :codigo OR "
			+ " u.nm_und = :nome OR "
			+ " m.nr_mun = :cidade OR "
			+ " u.nr_tip_und = :tipo OR "
			+ " uf.nr_und_fdrl = :estadoId OR "
			+ " u.nm_rsp_und = :responsavel and u.in_est_und_atv = :ativo"
			+ " ORDER BY u.nm_und ", nativeQuery = true)
	List<Unidade> findByListaParametros(@Param("codigo") String codigo, 
			@Param("nome") String nome, @Param("responsavel")  String responsavel,
			@Param("ativo") char ativo, @Param("cidade") Long cidade, 
			@Param("tipo") Integer tipo, @Param("estadoId") Long estadoId);

}
