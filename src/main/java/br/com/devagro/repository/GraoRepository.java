package br.com.devagro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Grao;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long>{
	@Query("SELECT f FROM Grao f WHERE f.empresa = :empresa")
	List<Grao> companyGradeList(Empresa empresa);
	
	@Query("select g.nome as nomeGrao, f.estoqueInicial\r\n"
			+ "FROM Grao g \r\n"
			+ "INNER JOIN Fazenda f\r\n"
			+ "ON g.id = f.grao\r\n"
			+ "where g.empresa = :empresa\r\n"
			+ "order  by f.estoqueInicial desc")
	<T> List<T> companyGrades(Empresa empresa);
	
	
}
