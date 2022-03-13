package br.com.devagro.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Fazenda;
import br.com.devagro.repository.FazendaRepository;

@Service
public class FazendaService {
	 private final FazendaRepository repository;

	    public FazendaService(FazendaRepository repository) {
	        this.repository = repository;
	    }

	    public List<Fazenda> listaFazendas(){
	        return (List<Fazenda>) repository.findAll();
	    }

	    public Fazenda adicionaFazenda(Fazenda fazenda){
	        return repository.save(fazenda);
	    }

	    public Fazenda atualizaFazenda(Long id, Fazenda fazenda){
	    	Fazenda fazendaAtualizada = repository.findById(id).get();
	    	fazendaAtualizada.setNome(fazenda.getNome());
	    	fazendaAtualizada.setEndereco(fazenda.getEndereco());
	    	fazendaAtualizada.setGrao(fazenda.getGrao());
	    	fazendaAtualizada.setEstoqueInicial(fazenda.getEstoqueInicial());
	    	fazendaAtualizada.setEmpresa(fazenda.getEmpresa());
	    	fazendaAtualizada.setDataUltimaColheita(fazenda.getDataUltimaColheita());
	    	
	        return repository.save(fazendaAtualizada);
	    }

	    public void deletaFazenda(Long id){
	        repository.deleteById(id);
	    }
	    
	    public List<Fazenda> listaFazendasEmpresa(Empresa empresa){
	    	return repository.findAllByEmpresa(empresa);
	    }
	    
	    public Integer qtdeFazendasPorEmpresa(Empresa empresa) {
	    	return repository.numberFarmsByCompany(empresa);
	    }
	    
	    public <T> List<T> listFarmsNextHarvest(Empresa empresa){
	    	return repository.listFarmsNextHarvest(empresa);
	 
	    }
	    
	    public Integer registerHarvestFarm(Long id, Date dataColheita, Double qtdeAumentarEstoque) {
			return repository.registerHarvestFarm(id, dataColheita, qtdeAumentarEstoque);
	
	    }
	    
	    public Integer removeGrain(Long id, Double qtdeRemoverEstoque) {
			return repository.removeGrain(id, qtdeRemoverEstoque);
	
	    }
	    
	    
	    
}
