package br.com.devagro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devagro.model.Fazenda;

public interface FazendaRepository extends JpaRepository<Fazenda, Long>{

}
