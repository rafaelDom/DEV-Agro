package br.com.devagro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.devagro.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
