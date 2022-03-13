package br.com.devagro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	@Query("SELECT f FROM Funcionario f WHERE f.empresa = :empresa")
	List<Funcionario> findAllByFuncionarios(Empresa empresa);
	
	@Query("select count(*) from Funcionario where empresa = :empresa")
	Integer numberMmployeesByCompany(Empresa empresa);
	
}
