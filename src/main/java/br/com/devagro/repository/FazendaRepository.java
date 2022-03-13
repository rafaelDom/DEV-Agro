package br.com.devagro.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Fazenda;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
	@Query("SELECT f FROM Fazenda f WHERE f.empresa = :empresa")
	List<Fazenda> findAllByEmpresa(Empresa empresa);

	@Query("select count(*) from Fazenda where empresa = :empresa")
	Integer numberFarmsByCompany(Empresa empresa);
	
	@Query("SELECT f.id, f.nome, (f.dataUltimaColheita + g.tempoMedioColheitaDias) as data_proxima_colheita from Fazenda f INNER JOIN Grao g ON f.empresa = g.empresa where f.empresa = :empresa")
	<T> List<T> listFarmsNextHarvest(Empresa empresa);
	
	@Transactional @Modifying @Query("UPDATE Fazenda\r\n"
			+ "	set dataUltimaColheita = :dataColheita,\r\n"
			+ "	estoque_inicial = estoqueInicial + :qtdeAumentarEstoque\r\n"
			+ "	where id = :id")
	Integer registerHarvestFarm(Long id, Date dataColheita, Double qtdeAumentarEstoque);
	
	@Transactional @Modifying @Query("UPDATE Fazenda\r\n"
			+ "	set estoque_inicial = estoqueInicial - :qtdeRemoverEstoque\r\n"
			+ "	where id = :id")
	Integer removeGrain(Long id, Double qtdeRemoverEstoque);

	
}
