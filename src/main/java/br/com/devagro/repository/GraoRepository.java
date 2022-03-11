package br.com.devagro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devagro.model.Grao;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long>{

}
